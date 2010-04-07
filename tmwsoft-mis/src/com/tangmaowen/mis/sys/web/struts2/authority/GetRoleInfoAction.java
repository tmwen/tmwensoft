package com.tangmaowen.mis.sys.web.struts2.authority;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.RoleBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-20 下午02:49:55
 *
 */
public class GetRoleInfoAction extends MisSysBaseAction {
	
	@Override
	protected String misExecute() {
		RoleBO bo = getMisSys().getRole(roleid);
		setResultInfo("{success: true, data:" + Tools.getJsonStringFromObject(bo) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "查看角色：" + roleid + "的信息";
	}
	
	private Integer roleid;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

}
