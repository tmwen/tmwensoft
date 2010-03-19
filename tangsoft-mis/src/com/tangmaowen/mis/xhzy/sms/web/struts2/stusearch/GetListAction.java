package com.tangmaowen.mis.xhzy.sms.web.struts2.stusearch;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.AuthorityConstants;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.StudentSearchInfoVO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-16 下午02:58:25
 *
 */
public class GetListAction extends MisXhzySmsBaseAction implements ModelDriven<StudentSearchInfoVO> {

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
	
	private PageingBO getPageing(){
		PageingBO bo = new PageingBO();
		bo.setStart(start);
		bo.setLimit(limit);
		
		bo.setConditionExceptNull("and", "", "", "bkxl", "=", studentBaseInfo.getBkxl());
		bo.setConditionExceptNull("and", "", "", "jie", "=", studentBaseInfo.getJie());
		bo.setConditionExceptNull("and", "", "", "jj", "=", studentBaseInfo.getJj());
		bo.setConditionExceptNull("and", "", "", "msrq", "=", studentBaseInfo.getMsrq());
		bo.setConditionExceptNull("and", "", "", "msbbh", "like", studentBaseInfo.getMsbbh());
		bo.setConditionExceptNull("and", "", "", "xm", "like", studentBaseInfo.getXm());
		bo.setConditionExceptNull("and", "", "", "sfzhm", "like", studentBaseInfo.getSfzhm());
		bo.setConditionExceptNull("and", "", "", "bdzy", "=", studentBaseInfo.getBdzy());
		bo.setConditionExceptNull("and", "", "", "xb", "=", studentBaseInfo.getXb());
		bo.setConditionExceptNull("and", "", "", "mz", "=", studentBaseInfo.getMz());
		bo.setConditionExceptNull("and", "", "", "zzmm", "=", studentBaseInfo.getZzmm());
		bo.setConditionExceptNull("and", "", "", "zfzr", "=", studentBaseInfo.getZfzr());
		bo.setConditionExceptNull("and", "", "", "zsls", "=", studentBaseInfo.getZsls());
		bo.setConditionExceptNull("and", "", "", "byxx", "like", studentBaseInfo.getByxx());
		bo.setConditionExceptNull("and", "", "", "syd", "like", studentBaseInfo.getSyd());
		bo.setConditionExceptNull("and", "", "", "lq", "=", studentBaseInfo.getLq());
		bo.setConditionExceptNull("and", "", "", "jfze", ">=", studentBaseInfo.getJfze());
		if(null != studentBaseInfo.getYjfje() && 0 == studentBaseInfo.getYjfje()) {
			bo.setConditionExceptNull("and", "(", "", "yjfje", "<=", 0.01);
			bo.setCondition("or", ")", "", "yjfje", "=", null);
		} else {
			bo.setConditionExceptNull("and", "", "", "yjfje", ">=", studentBaseInfo.getYjfje());
		}
		if(null != studentBaseInfo.getJfje() && 0 == studentBaseInfo.getJfje()) {
			bo.setConditionExceptNull("and", "(", "", "jfje", "<=", 0.01);
			bo.setCondition("or", ")", "", "jfje", "=", null);
		} else {
			bo.setConditionExceptNull("and", "", "", "jfje", ">=", studentBaseInfo.getJfje());
		}
		
		if(userSession.getAuthoritys().indexOf(AuthorityConstants.D_ALL) == -1 && userSession.getAuthoritys().indexOf(AuthorityConstants.D_ONESELF) != -1) {
			bo.setConditionExceptNull("and", "(", "", "zfzr", "=", userSession.getUserid());
			bo.setConditionExceptNull("or", "", "", "creater", "=", userSession.getUserid());
			bo.setConditionExceptNull("or", ")", "", "lastupdater", "=", userSession.getUserid());
		}
		bo.setOrder("stuid", "desc");
		return bo;
	}

	@Override
	protected String actionInfo() {
		return "获取学生列表";
	}
	
	private StudentSearchInfoVO studentBaseInfo = new StudentSearchInfoVO();

	@Override
	public StudentSearchInfoVO getModel() {
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
