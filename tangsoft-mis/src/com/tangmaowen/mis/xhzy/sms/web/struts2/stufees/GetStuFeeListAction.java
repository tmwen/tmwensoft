package com.tangmaowen.mis.xhzy.sms.web.struts2.stufees;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.StudentFeesVO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-4 上午12:38:27
 *
 */
public class GetStuFeeListAction extends MisXhzySmsBaseAction implements ModelDriven<StudentFeesVO> {

	@Override
	public String execute() {
		setLog(false);
		return super.execute();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected String misExecute() {
		PageingBO bo = new PageingBO();
		bo.setStart(0);
		bo.setLimit(-1);
		bo.setConditionExceptNull("stuid", studentFees.getStuid());
		bo.setOrder("feeid", "desc");

		Map<String, ?> map = getMisXhzySms().getStudentFeesList(bo);
		List<StudentBaseInfoBO> boList = (List<StudentBaseInfoBO>)map.get("boList");
		setResultInfo("{success: true, count: " + map.get("count") + ", data:" + Tools.getJsonStringFromObject(boList) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "获取学生缴费列表";
	}
	
	private StudentFeesVO studentFees = new StudentFeesVO();

	@Override
	public StudentFeesVO getModel() {
		return studentFees;
	}

}
