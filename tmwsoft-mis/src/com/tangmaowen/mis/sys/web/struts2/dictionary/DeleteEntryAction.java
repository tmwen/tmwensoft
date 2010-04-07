package com.tangmaowen.mis.sys.web.struts2.dictionary;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.DictionaryBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-4 下午01:57:19
 *
 */
public class DeleteEntryAction extends MisSysBaseAction {
	
	private DictionaryBO bo = null;
	@Override
	protected String misExecute() {
		Integer entryid = Integer.valueOf(data);
		bo = getMisSys().deleteEntry(entryid);
		setResultInfo("{success: true, message: '删除成功'}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "删除字典条目" + data + ":" + Tools.getJsonStringFromObject(bo);
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
