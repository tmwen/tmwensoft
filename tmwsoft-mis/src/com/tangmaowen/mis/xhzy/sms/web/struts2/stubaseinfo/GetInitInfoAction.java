package com.tangmaowen.mis.xhzy.sms.web.struts2.stubaseinfo;

import java.util.Calendar;

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
		setVerifyRequest("no");
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		String curDate = Tools.getCurrDefaultDateTime().substring(0, 10);
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		if((month == 10 && day >= 15) || month > 10) {
			year++;
		}
		String season = "1";
		if( (month > 3 && month < 10) || (month == 3 && day >= 15) || (month == 10 && day <= 14)) {
			season = "2";
		}
		setResultInfo("{success: true, data:[{jie:" + year + ",jj:" + season + ",msrq:'" + curDate + "'}]}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "初始化学生基本信息";
	}
}
