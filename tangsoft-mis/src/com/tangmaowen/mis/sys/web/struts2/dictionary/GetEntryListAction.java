package com.tangmaowen.mis.sys.web.struts2.dictionary;

import java.util.List;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.DictionaryBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-19 下午07:03:43
 *
 */
public class GetEntryListAction extends MisSysBaseAction {

	@Override
	public String execute() {
		setLog(false);
		return super.execute();
	}
	
	@Override
	protected String misExecute() {
		List<DictionaryBO> boList = getMisSys().getEntryList(parentcode);
		setResultInfo("{success: true, count: " + boList.size() + ", data:" + Tools.getJsonStringFromObject(boList) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "获取字典项：" + parentcode + "的条目";
	}
	
	private String parentcode;

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}
}
