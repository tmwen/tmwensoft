package com.tangmaowen.mis.sys.web.struts2.authority;

import org.springframework.beans.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.RoleBO;
import com.tangmaowen.mis.sys.web.RoleVO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-20 下午02:11:04
 *
 */
public class UpdateRoleAction extends MisSysBaseAction implements ModelDriven<RoleVO> {

	@Override
	protected String misExecute() {
		RoleBO bo = getMisSys().getRole(role.getRoleid());
		BeanUtils.copyProperties(role, bo);
		getMisSys().updateRole(bo);
		setResultInfo("{success: true, message: '修改成功'}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "更新角色：" + role.getRolename() + "的信息 " + Tools.getJsonStringFromObject(role);
	}
	
	private RoleVO role = new RoleVO();

	@Override
	public RoleVO getModel() {
		return role;
	}
}
