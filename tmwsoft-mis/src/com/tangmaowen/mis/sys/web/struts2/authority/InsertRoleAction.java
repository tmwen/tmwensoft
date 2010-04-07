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
 * @since 2009-11-20 下午02:11:24
 *
 */
public class InsertRoleAction extends MisSysBaseAction implements ModelDriven<RoleVO> {
	
	@Override
	protected String misExecute() {
		RoleBO bo = new RoleBO();
		BeanUtils.copyProperties(role, bo);
		RoleBO newbo = getMisSys().insertRole(bo);
		setResultInfo("{success: true, message: '新增成功', data:" + Tools.getJsonStringFromObject(newbo) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "新增角色:" + role.getRolename();
	}
	
	private RoleVO role = new RoleVO();

	@Override
	public RoleVO getModel() {
		return role;
	}
}
