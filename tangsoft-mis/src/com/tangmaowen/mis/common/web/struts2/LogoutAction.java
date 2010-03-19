package com.tangmaowen.mis.common.web.struts2;

import com.tangmaowen.mis.common.Constants;


/**
 * @author 唐懋文
 * @since 2009-11-6 下午01:50:06
 *
 */
public class LogoutAction extends BaseAction {

	private String userid = "null";
	
	@Override
	public String execute() {
		setVerifyRequest(false);
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		if(userSession != null && userSession.getUserid() != null) userid = String.valueOf(userSession.getUserid());
		if(context != null && context.getSession() != null && userSession != null) {
			context.getSession().clear();
			userSession = null;
			setResultInfo("{success: true, message: '注销成功'}");
		} else {
			setResultInfo("{success: true, message: '未进行任何操作'}");
		}
		return Constants.LOGIN;
	}

	@Override
	protected String actionInfo() {
		return "用户：" + userid + " 请求注销";
	}
}
