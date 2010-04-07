package com.tangmaowen.mis.sys.web.struts2.authority;

import java.util.List;

import com.tangmaowen.mis.sys.domain.RoleBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-13 下午08:58:17
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
		List<RoleBO> boList = getMisSys().getRoleList();
		StringBuilder value = new StringBuilder();
		value.append("[");
		if(!Tools.isEmpty(boList)) {
			for(int i = 0; i < boList.size(); i++) {
				value.append("{text:'" + boList.get(i).getRolename() + "',id:'" + boList.get(i).getRoleid() + "',isClass:true,iconCls:'icon-pkg',leaf:true},");
			}
			value.deleteCharAt(value.length() - 1);
		}
		value.append("]");
		tree = value.toString();
		return SUCCESS;
	}

	@Override
	protected String actionInfo() {
		return "跳转到角色权限主页面";
	}
	
	private String tree;

	public String getTree() {
		return tree;
	}
	
}
