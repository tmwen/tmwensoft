package com.tangmaowen.mis.xhzy.sms.web.struts2.stubaseinfo;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.AuthorityConstants;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.StudentBaseInfoVO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-16 下午02:58:25
 *
 */
public class GetListAction extends MisXhzySmsBaseAction implements ModelDriven<StudentBaseInfoVO> {

	@Override
	public String execute() {
		setLog(false);
		return super.execute();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected String misExecute() {
		// 查询条件组装
		PageingBO bo = new PageingBO();
		bo.setStart(start);
		bo.setLimit(limit);
		
		bo.setConditionExceptNull("xm", studentBaseInfo.getXm());
		bo.setConditionExceptNull("sfzhm", studentBaseInfo.getSfzhm());
		if(userSession.getAuthoritys().indexOf(AuthorityConstants.D_ALL) != -1) {
			
		} else if(userSession.getAuthoritys().indexOf(AuthorityConstants.D_ONESELF) != -1) {
			bo.setConditionExceptNull("and", "(", "", "zfzr", "=", userSession.getUserid());
			bo.setConditionExceptNull("or", "", "", "creater", "=", userSession.getUserid());
			bo.setConditionExceptNull("or", ")", "", "lastupdater", "=", userSession.getUserid());
		} else {
			setResultInfo("{success: true, count: 0, data: []}");
			return Constants.FORWARDJSONINFO;
		}
		
		bo.setOrder("stuid", "desc");

		Map<String, ?> map = getMisXhzySms().getStudentBaseInfoList(bo);
		List<StudentBaseInfoBO> boList = (List<StudentBaseInfoBO>)map.get("boList");
		setResultInfo("{success: true, count: " + map.get("count") + ", data:" + Tools.getJsonStringFromObject(boList) + "}");
		//"{data: [{stuid:1,sfzhm:'5101001111',xm:'xm',xb:'',hj:'',zzmm:'',bdzy:'',kslb:'',zsls:''}]}";
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "获取学生列表";
	}
	
	private StudentBaseInfoVO studentBaseInfo = new StudentBaseInfoVO();

	@Override
	public StudentBaseInfoVO getModel() {
		return studentBaseInfo;
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
