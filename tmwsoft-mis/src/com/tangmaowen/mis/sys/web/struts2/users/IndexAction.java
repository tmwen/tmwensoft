package com.tangmaowen.mis.sys.web.struts2.users;

import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午10:50:27
 *
 */
public class IndexAction extends MisSysBaseAction {

	@Override
	public String execute() {
		setAjax(false);
		setLog(false);
		return super.execute();
	}

	@Override
	protected String misExecute() {
		userList = getUserIDNameJsArray();
		return SUCCESS;
	}

	@Override
	protected String actionInfo() {
		return "跳转到用户管理主页面";
	}
	
	private String userList;

	public String getUserList() {
		return userList;
	}

	public void setUserList(String userList) {
		this.userList = userList;
	}
	
}
