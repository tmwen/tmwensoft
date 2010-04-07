package com.tangmaowen.mis.sys.web.struts2.authority;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.RoleBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-4 下午01:57:19
 *
 */
public class DeleteRoleAction extends MisSysBaseAction {
	
	private RoleBO bo = null;
	@Override
	protected String misExecute() {
		bo = getMisSys().deleteRole(roleid);
		if(Tools.isEmpty(bo)) {
			setResultInfo("{success: false, message: '删除失败，角色还拥有权限或角色不存在'}");
		} else {
			setResultInfo("{success: true, message: '删除成功'}");
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "删除角色" + roleid + ":" + Tools.getJsonStringFromObject(bo);
	}
	
	private Integer roleid;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

}
