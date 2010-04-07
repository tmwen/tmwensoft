package com.tangmaowen.mis.sys.web.struts2.users;

import java.util.List;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.RoleBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-21 上午03:09:19
 *
 */
public class GetUserRoleAction extends MisSysBaseAction {
	
	@Override
	protected String misExecute() {
		List<RoleBO> boList = null;
		if(!Tools.isEmpty(userid)) {
			boList = getMisSys().getUserRole(userid);
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
		return "获取系统用户：" + userid + "拥有的角色";
	}
	
	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
