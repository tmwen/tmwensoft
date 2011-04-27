package com.tangmaowen.mis.xhzy.sms.web.struts2.stufees;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
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
public class GetStuListAction extends MisXhzySmsBaseAction implements ModelDriven<StudentBaseInfoVO> {

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
		
		bo.setConditionExceptNull("xm", studentBaseInfo.getXm());
		bo.setConditionExceptNull("sfzhm", studentBaseInfo.getSfzhm());
		if(!userSession.isAdmin()) {
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DAY_OF_MONTH);
			if((month == 10 && day >= 15) || month > 10) {
				year++;
			}
			bo.setConditionExceptNull("and", "", "", "jie", "=", year + "");
		}
		bo.setOrder("stuid", "desc");

		Map<String, ?> map = getMisXhzySms().getStudentBaseInfoList(bo);
		List<StudentBaseInfoBO> boList = (List<StudentBaseInfoBO>)map.get("boList");
		setResultInfo("{success: true, count: " + map.get("count") + ", data:" + Tools.getJsonStringFromObject(boList) + "}");
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
