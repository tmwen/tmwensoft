package com.tangmaowen.mis.sys.web.struts2.authority;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;

/**
 * @author 唐懋文
 * @since 2009-11-20 下午02:10:54
 *
 */
public class UpdateRoleAuthAction extends MisSysBaseAction {

	@Override
	protected String misExecute() {
		getMisSys().updateRoleAuth(roleid, authids);
		setResultInfo("{success: true, message: '修改成功'}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "修改角色：" + roleid + "拥有的权限:" + authids;
	}
	
	private Integer roleid;
	private String authids;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getAuthids() {
		return authids;
	}

	/**
	 * @param authids 多个权限id，形如：a,b,c,d,e,f
	 */
	public void setAuthids(String authids) {
		this.authids = authids;
	}

}
