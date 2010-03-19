package com.tangmaowen.mis.xhzy.sms.web.struts2.stufees;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentFeesBO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-4 下午01:57:19
 *
 */
public class DeleteInfoAction extends MisXhzySmsBaseAction {
	private StudentFeesBO bo = null;
	
	@Override
	protected String misExecute() {
		Integer feeid = Integer.valueOf(data);
		bo = getMisXhzySms().getStudentFees(feeid);
		bo.setLastupdater(userSession.getUserid());
		bo.setLastupdatertime(Tools.getCurrDefaultDateTime());
		getMisXhzySms().deleteStudentFees(bo);
		setResultInfo("{success: true, message: '删除成功'}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "删除学生:" + bo.getStuid() + "的缴费信息:" + Tools.getJsonStringFromObject(bo);
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
