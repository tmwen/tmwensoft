package com.tangmaowen.mis.sys.web.struts2;

import com.tangmaowen.mis.common.web.struts2.BaseAction;
import com.tangmaowen.mis.sys.domain.logic.MisSysFacade;

/**
 * MisSms的action抽像基类，包括该系统初始化
 * @author 唐懋文
 * @since 2009-11-19 上午11:35:12
 *
 */
public abstract class MisSysBaseAction extends BaseAction {
	private MisSysFacade misSys;

	protected void initSys() {
		setSystem("MisSys");
		super.initSys();
	}

	protected MisSysFacade getMisSys() {
		return misSys;
	}

	public void setMisSys(MisSysFacade misSys) {
		this.misSys = misSys;
	}

}
