package com.tangmaowen.mis.sys.web.struts2.log;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.LogBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-21 上午03:09:19
 *
 */
public class GetInfoAction extends MisSysBaseAction {

	@Override
	public String execute() {
		setLog(false);
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		LogBO bo = getMisSys().getLogInfo(logid);
		setResultInfo("{success: true, data:" + Tools.getJsonStringFromObject(bo) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "查看系统日志：" + logid + "的信息";
	}
	
	private Integer logid;

	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

}
