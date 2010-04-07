package com.tangmaowen.mis.xhzy.sms.web.struts2;

import com.tangmaowen.mis.common.web.struts2.BaseAction;
import com.tangmaowen.mis.xhzy.sms.domain.logic.MisXhzySmsFacade;

/**
 * MisXhzySms的action抽像基类，包括该系统初始化
 * @author 唐懋文
 * @since 2009-11-19 上午11:34:15
 *
 */
public abstract class MisXhzySmsBaseAction extends BaseAction {
	private MisXhzySmsFacade misXhzySms;

	protected void initSys() {
		setSystem("MisXhzySms");
		super.initSys();
	}

	protected MisXhzySmsFacade getMisXhzySms() {
		return misXhzySms;
	}

	public void setMisXhzySms(MisXhzySmsFacade misXhzySms) {
		this.misXhzySms = misXhzySms;
	}

}
