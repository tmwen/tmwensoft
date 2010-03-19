package com.tangmaowen.mis.sys.web.struts2.setup;

import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;

/**
 * @author 唐懋文
 * @since 2009-11-24 下午01:28:49
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
		return SUCCESS;
	}

	@Override
	protected String actionInfo() {
		return "跳转到系统设置主页面";
	}
}
