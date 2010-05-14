package com.tangmaowen.mis.xhzy.sms.web.struts2.stusearch;

import java.util.List;
import java.util.Map;

import com.tangmaowen.mis.common.AuthorityConstants;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-16 下午02:58:25
 *
 */
public class GetListAction extends StuSearchBaseAction {

	@Override
	public String execute() {
		setLog(false);
		return super.execute();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected String misExecute() {
		if(userSession.getAuthoritys().indexOf(AuthorityConstants.D_ALL) != -1 || userSession.getAuthoritys().indexOf(AuthorityConstants.D_ONESELF) != -1) {
			Map<String, ?> map = getMisXhzySms().getStudentBaseInfoList(getPageing());
			List<StudentBaseInfoBO> boList = (List<StudentBaseInfoBO>)map.get("boList");
			setResultInfo("{success: true, count: " + map.get("count") + ", data:" + Tools.getJsonStringFromObject(boList) + "}");
		} else {
			setResultInfo("{success: true, count: 0, data: []}");
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "获取学生列表";
	}
}
