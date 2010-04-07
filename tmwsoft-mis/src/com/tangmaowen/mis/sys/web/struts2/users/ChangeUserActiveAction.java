package com.tangmaowen.mis.sys.web.struts2.users;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;

/**
 * @author 唐懋文
 * @since 2009-10-21 上午03:09:19
 *
 */
public class ChangeUserActiveAction extends MisSysBaseAction {
	
	@Override
	protected String misExecute() {
		String active = getMisSys().changeUserActive(userid);
		if(active.equals(Constants.USERUSINGACTION)) {
			active = "启用成功";
		} else if(active.equals(Constants.USERSTOPACTION)) {
			active = "停用成功";
		} else {
			active = "没进行任何操作";
		}
		setResultInfo("{success: true, message: '对用户：" + userid + " " + active + "'}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "更改用户：" + userid + "的账号状态";
	}
	
	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
