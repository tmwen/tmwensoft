package com.tangmaowen.mis.sys.web.struts2.users;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.sys.domain.UserBO;
import com.tangmaowen.mis.sys.web.UserVO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-21 上午03:09:19
 *
 */
public class GetListAction extends MisSysBaseAction implements ModelDriven<UserVO> {

	@Override
	public String execute() {
		setLog(false);
		return super.execute();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected String misExecute() {
		PageingBO bo = new PageingBO();
		bo.setStart(start);
		bo.setLimit(limit);
		
		bo.setConditionExceptNull("userid", user.getUserid());
		bo.setConditionExceptNull("and", "", "", "userid", "!=", userSession.getUserid());
		bo.setConditionExceptNull("and", "", "", "userid", "!=", Constants.ADMIN);
		bo.setConditionExceptNull("username", user.getUsername());
		
		bo.setOrder("userid", "desc");

		Map<String, Object> map = getMisSys().getUsersList(bo);
		List<UserBO> boList = (List<UserBO>)map.get("boList");
		setResultInfo("{success: true, count: " + map.get("count") + ", data:" + Tools.getJsonStringFromObject(boList) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "获取系统用户列表";
	}
	
	UserVO user = new UserVO();

	@Override
	public UserVO getModel() {
		return user;
	}
	
	private int start = 0;
	private int limit = 0;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
