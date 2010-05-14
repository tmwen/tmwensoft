package com.tangmaowen.mis.common.web.struts2;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.common.domain.UserSessionInfo;
import com.tangmaowen.mis.sys.domain.UserBO;
import com.tangmaowen.mis.sys.web.LoginVO;
import com.tangmaowen.utils.MD5;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-20 下午01:53:01
 *
 */
public class LoginAction extends BaseAction implements ModelDriven<LoginVO> {

	@Override
	public String execute() {
		setVerifyRequest("no");
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		UserBO user = verifyLogin();
		logIn(user);
		return Constants.FORWARDJSONINFO;
	}
	
	private UserBO verifyLogin() {
		if (Tools.isNull(login.getId()) || Tools.isNull(login.getPassword())) {
			setResultInfo("{success: false, message: '请输入账号或密码'}");
			return null;
		}
		//验证用户名密码
		UserBO user = getMisComm().login(login.getId(), MD5.crypt(login.getPassword()));
		if (user == null) {
			setResultInfo("{success: false, message: '无效的账号或密码'}");
		} else if(user.getActive().equals(Constants.USERSTOPACTION)) {
			setResultInfo("{success: false, message: '账号已停用'}");
			user = null;
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	private void logIn(UserBO user) {
		if(user == null) return;
		//验证成功
		//装载用户信息
		String authoritys = getMisComm().getUserAuthorityByStr(user.getUserid());
		String loginTime = Tools.getCurrDefaultDateTime();
		userSession = new UserSessionInfo();
		userSession.setUserid(user.getUserid());
		userSession.setUsername(user.getUsername());
		userSession.setStatus(user.getStatus());
		userSession.setLogintime(loginTime);
		userSession.setAuthoritys(authoritys);
		//将用户信息记录到session中
		context.getSession().clear();
		context.getSession().put(Constants.USERSESSION, userSession);
		setResultInfo("{success: true, message: ''}");
		//记录用户登录信息
		getMisComm().updateUserLoginInfo(user.getUserid());
	}

	@Override
	protected String actionInfo() {
		return "用户：" + login.getId() + " 请求登录";
	}
	
	private LoginVO login = new LoginVO();
	
	@Override
	public LoginVO getModel() {
		return login;
	}
}
