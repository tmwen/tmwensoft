package com.tangmaowen.mis.xhzy.sms.web.struts2.stubaseinfo;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-21 上午03:09:19
 *
 */
public class GetInfoAction extends MisXhzySmsBaseAction {

	@Override
	public String execute() {
		setLog(false);
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		StudentBaseInfoBO bo = getMisXhzySms().getStudentBaseInfo(stuid);
		setResultInfo("{success: true, data:" + Tools.getJsonStringFromObject(bo) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "查看学生：" + stuid + "的基本信息";
	}
	
	private Integer stuid;

	public Integer getStuid() {
		return stuid;
	}

	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}
}
