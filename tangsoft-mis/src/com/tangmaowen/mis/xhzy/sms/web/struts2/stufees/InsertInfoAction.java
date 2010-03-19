package com.tangmaowen.mis.xhzy.sms.web.struts2.stufees;

import net.sf.json.JSONObject;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentFeesBO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-4 下午01:25:29
 *
 */
public class InsertInfoAction extends MisXhzySmsBaseAction {
	
	@Override
	protected String misExecute() {
		JSONObject jsonObj = JSONObject.fromObject(data);
		StudentFeesBO bo = (StudentFeesBO)JSONObject.toBean(jsonObj, StudentFeesBO.class);
		String time = Tools.getCurrDefaultDateTime();
		bo.setJfrq(bo.getJfrq().substring(0,10));
		bo.setCreater(userSession.getUserid());
		bo.setCreatetime(time);
		bo.setLastupdater(userSession.getUserid());
		bo.setLastupdatertime(time);
		StudentFeesBO newbo = getMisXhzySms().insertStudentFees(bo);
		setResultInfo("{success: true, message: '新增成功', data:" + Tools.getJsonStringFromObject(newbo) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "新增学生费用信息:" + data;
	}
	
	private String data;

	public String getData() {
		return data;
	}

	/**
	 * @param data 客户端传来的json字符串
	 */
	public void setData(String data) {
		this.data = data;
	}
}
