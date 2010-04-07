package com.tangmaowen.mis.sys.web.struts2.users;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;

/**
 * @author 唐懋文
 * @since 2009-11-24 上午12:12:51
 *
 */
public class UpdateUserRoleAction extends MisSysBaseAction {

	@Override
	protected String misExecute() {
		getMisSys().updateUserRole(userid, roleids);
		setResultInfo("{success: true, message: '修改成功'}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "修改用户：" + userid + "拥有的角色:" + roleids;
	}
	
	private Integer userid;
	private String roleids;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getRoleids() {
		return roleids;
	}

	/**
	 * @param roleids 多个角色id，形如：a,b,c,d,e,f
	 */
	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}

}
