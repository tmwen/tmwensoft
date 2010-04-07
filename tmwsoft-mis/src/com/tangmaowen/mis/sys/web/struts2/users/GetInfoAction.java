package com.tangmaowen.mis.sys.web.struts2.users;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.UserBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-21 上午03:09:19
 *
 */
public class GetInfoAction extends MisSysBaseAction {
	
	@Override
	protected String misExecute() {
		UserBO bo = getMisSys().getUserInfo(userid);
		setResultInfo("{success: true, data:" + Tools.getJsonStringFromObject(bo) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "查看系统用户：" + userid + "的基本信息";
	}
	
	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
