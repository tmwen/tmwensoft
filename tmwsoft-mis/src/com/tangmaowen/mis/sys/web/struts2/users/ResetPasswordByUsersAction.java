package com.tangmaowen.mis.sys.web.struts2.users;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.MD5;

/**
 * @author 唐懋文
 * @since 2009-12-30 下午10:42:35
 *
 */
public class ResetPasswordByUsersAction extends MisSysBaseAction {
	
	@Override
	protected String misExecute() {
		getMisSys().passwordAlter(userid, MD5.crypt(Constants.USERINITPASSWORD));
		setResultInfo("{success: true, message: '对用户：" + userid + "重置密码成功,密码为：" + Constants.USERINITPASSWORD + "'}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "重置用户" + userid + "的密码";
	}
	
	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
