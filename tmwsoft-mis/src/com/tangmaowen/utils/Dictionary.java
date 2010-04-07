package com.tangmaowen.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.tangmaowen.mis.sys.domain.DictionaryBO;

/**
 * 数据字典工具类
 * 
 * @author 唐懋文
 * @since 2009-11-10 下午11:18:09
 * 
 */
public class Dictionary {
	private static final Logger logger = Logger.getLogger(Dictionary.class);
	private volatile static Dictionary uniqueInstance = null;
//	private static Map<String, Object> dicCodes;
//	private static Map<String, Map<String, Object>> entries;
	private volatile static Map<String, Map<String, String>> dics;
	private static String jsDics;

	private Dictionary() {
	}

	public static Dictionary getInstance() {
		if (uniqueInstance == null) {
			synchronized (Dictionary.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Dictionary();
				}
			}
		}
		return uniqueInstance;
	}


	public String dicValueByKey(String code, String key) {
		Map<String, String> entryMap = (Map<String, String>) dics.get(code);
		String value = (String) entryMap.get(key);
		if (Tools.isEmpty(value)) value = "";
		return value;
	}

	@SuppressWarnings("unchecked")
	public String dicKeyByValue(String code, String value) {
		Map<String, String> entryMap = (Map<String, String>) dics.get(code);
		Iterator entryIter = entryMap.entrySet().iterator();
		Map.Entry<String, String> entry;
		while(entryIter.hasNext()) {
			entry = (Map.Entry<String, String>)entryIter.next();
			if(entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		return "";
	}
	
	public String getJSDics() {
		return jsDics;
	}
	
	public final void initDics(String xt, List<DictionaryBO> dicList) {
		if(dics == null) {
			synchronized (Dictionary.class) {
				if (dics == null) {
					try {
						dics = new TreeMap<String, Map<String, String>>();
						DictionaryBO bo;
						Map<String, String> entries;
						for(int i = 0; i < dicList.size(); i++) {
							bo = dicList.get(i);
							if(bo.getLevel().equals("0")) {
								if(dics.get(bo.getDictcode()) == null) {
									dics.put(bo.getDictcode(), new TreeMap<String, String>());
								}
							} else {
								entries = dics.get(bo.getParentcode());
								if(entries == null) {
									entries = new TreeMap<String, String>();
									dics.put(bo.getParentcode(), entries);
								}
								entries.put(bo.getDictcode(), bo.getCodecontent());
							}
						}
						jsDics = initJSDics();
					} catch(Exception e) {
						logger.error("初始化数据字典", e);
						dics = null;
					}
				}
			}
		}
	}
	
	private String initJSDics() {
		StringBuilder value = new StringBuilder();
		Iterator<String> dicIter = dics.keySet().iterator();
		while(dicIter.hasNext()) {
			String key = (String)dicIter.next();
			value.append("initDics('" + key + "'," + getJSArray(dics.get(key)) + ");");
		}
		return value.toString();
	}
	
	private StringBuilder getJSArray(Map<String, String> entries) {
		Iterator<String> entIter = entries.keySet().iterator();
		StringBuilder value = new StringBuilder();
		value.append("[");
		while(entIter.hasNext()) {
			String key = (String)entIter.next();
			value.append("['" + key + "','" + entries.get(key) + "'],");
		}
		if(entries.size() > 1) value.deleteCharAt(value.length() - 1);
		value.append("]");
		return value;
	}
}
