package com.tangmaowen.mis.xhzy.sms.web.struts2.stusearch;

import java.util.Calendar;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.AuthorityConstants;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.web.StudentSearchInfoVO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;

public abstract class StuSearchBaseAction extends MisXhzySmsBaseAction implements ModelDriven<StudentSearchInfoVO> {

	@Override
	protected String actionInfo() {
		return "查询基类";
	}

	protected PageingBO getPageing(){
		PageingBO bo = new PageingBO();
		bo.setStart(start);
		bo.setLimit(limit);

		bo.setConditionExceptNull("and", "", "", "msbbh", "=", studentBaseInfo.getMsbbh());
		bo.setConditionExceptNull("and", "", "", "msrq", ">=", studentBaseInfo.getMsrq_before());
		bo.setConditionExceptNull("and", "", "", "msrq", "<=", studentBaseInfo.getMsrq_after());
		bo.setConditionExceptNull("and", "", "", "bkxl", "=", studentBaseInfo.getBkxl());
		bo.setConditionExceptNull("and", "", "", "bdzy", "=", studentBaseInfo.getBdzy());
		bo.setConditionExceptNull("and", "", "", "jie", ">=", studentBaseInfo.getJie_before());
		bo.setConditionExceptNull("and", "", "", "jie", "<=", studentBaseInfo.getJie_after());
		bo.setConditionExceptNull("and", "", "", "jj", "=", studentBaseInfo.getJj());
		if("0".equals(studentBaseInfo.getYjf())) {
			bo.setConditionExceptNull("and", "(", "", "yjfje", "<=", 0.01);
			bo.setCondition("or", ")", "", "yjfje", "=", null);
		} else if("1".equals(studentBaseInfo.getYjf())) {
			bo.setConditionExceptNull("and", "", "", "yjfje", ">=", 0.01);
		}
		bo.setConditionExceptNull("and", "", "", "yjfskr", "like", studentBaseInfo.getYjfskr());
		if("0".equals(studentBaseInfo.getJf())) {
			bo.setConditionExceptNull("and", "(", "", "jfje", "<=", 0.01);
			bo.setCondition("or", ")", "", "jfje", "=", null);
		} else if("1".equals(studentBaseInfo.getJf())) {
			bo.setConditionExceptNull("and", "", "", "jfje", ">=", 0.01);
			bo.setConditionExceptNull("and", "", "", "jfze", ">=", studentBaseInfo.getJfze());
		}
		
		bo.setConditionExceptNull("and", "", "", "xm", "like", studentBaseInfo.getXm());
		bo.setConditionExceptNull("and", "", "", "xb", "=", studentBaseInfo.getXb());
		bo.setConditionExceptNull("and", "", "", "sfzhm", "like", studentBaseInfo.getSfzhm());
		bo.setConditionExceptNull("and", "", "", "mz", "=", studentBaseInfo.getMz());
		bo.setConditionExceptNull("and", "", "", "zzmm", "=", studentBaseInfo.getZzmm());
		bo.setConditionExceptNull("and", "", "", "zfzr", "=", studentBaseInfo.getZfzr());
		bo.setConditionExceptNull("and", "", "", "zsls", "like", studentBaseInfo.getZsls());
		bo.setConditionExceptNull("and", "", "", "byxx", "like", studentBaseInfo.getByxx());
		bo.setConditionExceptNull("and", "", "", "syd", "like", studentBaseInfo.getSyd());
		bo.setConditionExceptNull("and", "", "", "tj", "=", studentBaseInfo.getTj());
		bo.setConditionExceptNull("and", "", "", "lq", "=", studentBaseInfo.getLq());
		bo.setConditionExceptNull("and", "", "", "bdk", "=", studentBaseInfo.getBdk());
		bo.setConditionExceptNull("and", "", "", "bz", "like", studentBaseInfo.getBz());
		
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
		
		if(userSession.getAuthoritys().indexOf(AuthorityConstants.D_ALL) == -1 && userSession.getAuthoritys().indexOf(AuthorityConstants.D_ONESELF) != -1) {
			bo.setConditionExceptNull("and", "(", "", "zfzr", "=", userSession.getUserid());
			bo.setConditionExceptNull("or", "", "", "creater", "=", userSession.getUserid());
			bo.setConditionExceptNull("or", ")", "", "lastupdater", "=", userSession.getUserid());
		}
		bo.setOrder("stuid", "desc");
		return bo;
	}

	private StudentSearchInfoVO studentBaseInfo = new StudentSearchInfoVO();

	@Override
	public StudentSearchInfoVO getModel() {
		return studentBaseInfo;
	}
	
	private int start = 0;
	private int limit = -1;

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
