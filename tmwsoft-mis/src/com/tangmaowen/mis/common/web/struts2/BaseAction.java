package com.tangmaowen.mis.common.web.struts2;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.common.domain.UserSessionInfo;
import com.tangmaowen.mis.common.domain.logic.MisCommFacade;
import com.tangmaowen.mis.sys.domain.LogBO;
import com.tangmaowen.utils.Dictionary;
import com.tangmaowen.utils.Tools;

/**
 * action抽像基类，包括系统初始化、请求验证、具体业务处理
 * @author 唐懋文
 * @since 2009-10-20 下午01:52:54
 *
 */
public abstract class BaseAction extends ActionSupport {

	private static final Logger logger = Logger.getLogger(BaseAction.class);
	private static MisCommFacade misComm;
	private String system;
	private String resultInfo = "";
	private boolean ajax = true;
	private boolean log = true;
	private String verifyRequest = "login_auth";
	private String authority = "";
	
	protected ActionContext context;
	protected UserSessionInfo userSession;

	/* 
	 * action初始化
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		String result = null;
		try {
			initSys();
			result = verifyRequest();
			if(Tools.isNull(result)) result = misExecute();
			log();
		} catch(Exception e) {
			logger.error(authority, e);
			return errorHolder(e.toString());
		}
		if(Tools.isNull(result)) result = errorHolder("找不到转发页面");
		return result;
	}
	
	/**
	 * ActionSupport的execute()扩展，在BaseAction的子类中覆盖该方法，并设置result
	 * @return execute 返回result
	 */
	protected abstract String misExecute() ;
	
	/**
	 * @return 格式化了的客户端请求信息，用于日志记录，客户端负责组织信息
	 */
	protected abstract String actionInfo();

	//-----------------protected fun-----------------------
	protected void initSys() {
		Dictionary.getInstance().initDics(system, misComm.getDictionaryList());
		context = ActionContext.getContext();
		userSession = (UserSessionInfo)context.getSession().get(Constants.USERSESSION);
		ActionMapping mapping = (ActionMapping)context.get("struts.actionMapping");
		String namespace = mapping.getNamespace();
		String actionName = (String)context.get(ActionContext.ACTION_NAME);
		authority = namespace + "/" + actionName;
	}

	//-----------------private fun-----------------------	
	private String verifyRequest() {
		if(verifyRequest.equals("no")) return "";
		if(!verifyRequest.equals("no")) {
			if(userSession == null) {
				if(ajax) {
					setResultInfo("{success: false, message: '会话失效，请重新登录', verifyresult: 'login'}");
					return Constants.FORWARDJSONINFO;
				} else {
					return Constants.LOGIN;
				}
			}
		}
		if(verifyRequest.equals("login_auth")) {
			if(!verifyAuthority(authority, userSession.getAuthoritys())) {
				setResultInfo("{success: false, message: '无权限，请与管理员联系', verifyresult: 'notauth'}");
				return Constants.FORWARDJSONINFO;
			}
		}
		return "";
	}
	
	private void log() {
		if(!log) return;
		LogBO log = new LogBO();
		log.setOperaction(authority);
		log.setOperater(userSession == null ? Constants.GUESTID : userSession.getUserid());
		String info = actionInfo();
		log.setOperinfo((info.length() > 4900) ? (info.substring(0, 4900) + "...") : info);
		log.setOperip(ServletActionContext.getRequest().getRemoteAddr());
		log.setOperresult(resultInfo);
		log.setOpertime(Tools.getCurrDefaultDateTime());
		misComm.insertLog(log);
	}
	
	private boolean verifyAuthority(String actionName, String authoritys) {
		// 权限验证,action名字与权限对应,见AuthorityConstants
		if(authoritys.indexOf("`" + actionName + "`") == -1) return false;
		return true;
	}
	
	private String errorHolder(String info) {
		if(ajax) {
			setResultInfo("{success: false, message: '" + Constants.SERVERERRORINFO + "<br>错误信息:" + info + "', messageboxtype: 'error'}");
			return Constants.FORWARDJSONINFO;
		} else {
			setResultInfo(Constants.SERVERERRORINFO + "<br>错误信息:" + info);
			return Constants.ERROR;
		}
	}
	
	//----------------set get------------------------

	/**
	 * @param xt 所属系统名称
	 */
	protected String getSystem() {
		return system;
	}

	protected void setSystem(String system) {
		this.system = system;
	}

	protected MisCommFacade getMisComm() {
		return misComm;
	}

	public void setMisComm(MisCommFacade aMisComm) {
		misComm = aMisComm;
	}

	/**
	 * @return Json值，返回给EXT等AJAX调用
	 */
	public String getResultInfo() {
		return resultInfo;
	}

	/**
	 * @param resultInfo 处理好的Json值，用于页面
	 */
	protected void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	/**
	 * @param ajax true:ajax请求；false:http请求
	 */
	protected void setAjax(boolean ajax) {
		this.ajax = ajax;
	}

	/**
	 * @param log true:记录action信息到日志；false:不记录到日志
	 */
	protected void setLog(boolean log) {
		this.log = log;
	}

	/**
	 * @param verifyRequest login_auth:验证登录和权限; login:验证登录; no:不进行验证; 验证权限的前提条件是验证登录
	 */
	protected void setVerifyRequest(String verifyRequest) {
		this.verifyRequest = verifyRequest;
	}
	
	//---------------------------公共方法--------------------------------------------
	/**
	 * @return 所在系统的用户ID和名称的数组
	 */
	protected String[][] getUserIDNameArray() {
		return misComm.getUserIDNameArray(system, userSession.getUserid());
	}

	/**
	 * @return 所在系统启用的用户ID和名称的JS数组，形如[["1001", "张三"], ["1002", "王五"]]
	 */
	protected String getAliveUserIDNameJsArray() {
		return misComm.getAliveUserIDNameJsArray(system, userSession.getUserid());
	}

	/**
	 * @return 所在系统所有的用户ID和名称的JS数组，形如[["1001", "张三"], ["1002", "王五"]]
	 */
	protected String getUserIDNameJsArray() {
		return misComm.getUserIDNameJsArray(system, userSession.getUserid());
	}

}
