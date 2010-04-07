package com.tangmaowen.mis.sys.web.struts2.authority;

import java.util.List;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.AuthorityBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-19 下午07:03:43
 *
 */
public class GetRoleAuthListAction extends MisSysBaseAction {

	@Override
	public String execute() {
		setLog(false);
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		List<AuthorityBO> boList = null;
		if(!Tools.isEmpty(roleid)) {
			boList = getMisSys().getRoleAuth(roleid);
		}
		if(Tools.isEmpty(boList)) {
			setResultInfo("{success: true, count: 0, data:[]}");
		} else {
			setResultInfo("{success: true, count: " + boList.size() + ", data:" + Tools.getJsonStringFromObject(boList) + "}");
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "获取角色拥有的权限";
	}
	
	private Integer roleid;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
}
