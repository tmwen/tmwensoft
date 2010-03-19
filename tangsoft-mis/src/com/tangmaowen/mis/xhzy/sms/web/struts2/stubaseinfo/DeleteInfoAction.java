package com.tangmaowen.mis.xhzy.sms.web.struts2.stubaseinfo;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-25 下午07:43:57
 *
 */
public class DeleteInfoAction extends MisXhzySmsBaseAction {
	
	private StudentBaseInfoBO bo = null;
	
	@Override
	protected String misExecute() {
		bo = getMisXhzySms().getStudentBaseInfo(stuid);
		String result = getMisXhzySms().deleteStudentBaseInfo(bo.getStuid());
		if(Tools.isEmpty(result)) {
			setResultInfo("{success: true, message: '删除成功'}");
		} else {
			setResultInfo("{success: false, message: '" + result + "'}");
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "删除学生:" + stuid + "的基本信息:" + Tools.getJsonStringFromObject(bo);
	}
	
	private Integer stuid;

	public Integer getStuid() {
		return stuid;
	}

	/**
	 * @param data 客户端传来的json字符串
	 */
	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}
}
