package com.tangmaowen.mis.xhzy.sms.web.struts2.stubaseinfo;

import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午10:50:27
 *
 */
public class IndexAction extends MisXhzySmsBaseAction {

	@Override
	public String execute() {
		setAjax(false);
		setLog(false);
		return super.execute();
	}

	@Override
	protected String misExecute() {
		userList = getUserIDNameJsArray();
		aliveUserList = getAliveUserIDNameJsArray();
		return SUCCESS;
	}

	@Override
	protected String actionInfo() {
		return "跳转到学生基本信息主页面";
	}
	
	private String aliveUserList;
	
	private String userList;

	public String getAliveUserList() {
		return aliveUserList;
	}

	public void setAliveUserList(String aliveUserList) {
		this.aliveUserList = aliveUserList;
	}

	public String getUserList() {
		return userList;
	}

	public void setUserList(String userList) {
		this.userList = userList;
	}
	
}
