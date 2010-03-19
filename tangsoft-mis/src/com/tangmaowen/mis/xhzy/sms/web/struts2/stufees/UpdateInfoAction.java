package com.tangmaowen.mis.xhzy.sms.web.struts2.stufees;

import net.sf.json.JSONObject;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentFeesBO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-20 下午01:53:01
 *
 */
public class UpdateInfoAction extends MisXhzySmsBaseAction {

	@Override
	protected String misExecute() {
		JSONObject jsonObj = JSONObject.fromObject(data);
		StudentFeesBO bo = (StudentFeesBO)JSONObject.toBean(jsonObj, StudentFeesBO.class);
		bo.setJfrq(bo.getJfrq().substring(0,10));
		bo.setLastupdater(userSession.getUserid());
		bo.setLastupdatertime(Tools.getCurrDefaultDateTime());
		StudentFeesBO newbo = getMisXhzySms().updateStudentFees(bo);
		setResultInfo("{success: true, message: '修改成功', data:" + Tools.getJsonStringFromObject(newbo) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "更新学生费用信息:" + data;
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
