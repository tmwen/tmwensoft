package com.tangmaowen.mis.sys.web.struts2.dictionary;

import net.sf.json.JSONObject;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.DictionaryBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-20 下午01:53:01
 *
 */
public class UpdateEntryAction extends MisSysBaseAction {

	@Override
	protected String misExecute() {
		JSONObject jsonObj = JSONObject.fromObject(data);
		DictionaryBO bo = (DictionaryBO)JSONObject.toBean(jsonObj, DictionaryBO.class);
		DictionaryBO newbo = getMisSys().updateEntry(bo);
		setResultInfo("{success: true, message: '修改成功', data:" + Tools.getJsonStringFromObject(newbo) + "}");
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		return "更新字典条目:" + data;
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
