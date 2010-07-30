package com.tangmaowen.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.util.JSONUtils;

/**
 * null值处理器，空即是空，不做任何处理
 * @author 唐懋文
 * @since 2009-11-18 下午03:38:16
 * 
 */
public class MisNullToJsonDefaultValueProcessor implements DefaultValueProcessor {
	
	@SuppressWarnings("rawtypes")
	public Object getDefaultValue(Class type) {
		if (JSONUtils.isArray(type)) {
			return new JSONArray();
		} else if (JSONUtils.isNumber(type)) {
			if (JSONUtils.isDouble(type)) {
				return JSONNull.getInstance();
			} else {
				return JSONNull.getInstance();
			}
		} else if (JSONUtils.isBoolean(type)) {
			return Boolean.FALSE;
		} else if (JSONUtils.isString(type)) {
			return "";
		}
		return JSONNull.getInstance();
	}
}
