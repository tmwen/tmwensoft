package com.tangmaowen.mis.sys.web.struts2.log;

import java.util.List;
import java.util.Map;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.LogBO;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-21 上午03:09:19
 *
 */
public class GetListAction extends MisSysBaseAction {

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
		bo.setConditionExceptNull("operater", operater);
		bo.setOrder("logid", "desc");

		Map<String, Object> map = getMisSys().getLogList(bo);
		List<LogBO> boList = (List<LogBO>)map.get("boList");
		setResultInfo("{success: true, count: " + map.get("count") + ", data:" + Tools.getJsonStringFromObject(boList) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "获取系统日志列表";
	}
	
	private Integer operater;

	public Integer getOperater() {
		return operater;
	}

	public void setOperater(Integer operater) {
		this.operater = operater;
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
