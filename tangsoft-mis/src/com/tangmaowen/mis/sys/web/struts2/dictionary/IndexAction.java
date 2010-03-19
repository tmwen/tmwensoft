package com.tangmaowen.mis.sys.web.struts2.dictionary;

import java.util.List;

import com.tangmaowen.mis.sys.domain.DictionaryBO;
import com.tangmaowen.mis.sys.web.struts2.MisSysBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-13 下午08:58:17
 *
 */
public class IndexAction extends MisSysBaseAction {

	@Override
	public String execute() {
		setAjax(false);
		setLog(false);
		return super.execute();
	}

	@Override
	protected String misExecute() {
		List<DictionaryBO> boList = getMisSys().getDicRootCodeList();
		StringBuilder value = new StringBuilder();
		value.append("[");
		if(!Tools.isEmpty(boList)) {
			for(int i = 0; i < boList.size(); i++) {
				value.append("{text:'" + boList.get(i).getCodecontent() + "',id:'" + boList.get(i).getDictcode() + "',isClass:true,iconCls:'icon-pkg',leaf:true},");
			}
			value.deleteCharAt(value.length() - 1);
		}
		value.append("]");
		tree = value.toString();
		return SUCCESS;
	}

	@Override
	protected String actionInfo() {
		return "跳转到数据字典主页面";
	}
	
	private String tree;

	public String getTree() {
		return tree;
	}
	
}
