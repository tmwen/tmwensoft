package com.tangmaowen.mis.xhzy.sms.web.struts2.stubaseinfo;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-6 下午03:06:48
 *
 */
public class GetInitInfoAction extends MisXhzySmsBaseAction {

	@Override
	public String execute() {
		setLog(false);
		setVerifyRequest(false);
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		String curDate = Tools.getCurrDefaultDateTime().substring(0, 10);
		setResultInfo("{success: true, data:[{jie:2010,jj:2,msrq:'" + curDate + "'}]}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "初始化学生基本信息";
	}
}
