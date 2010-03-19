package com.tangmaowen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;

import com.tangmaowen.mis.common.MisException;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午12:40:09
 *
 */
public class Tools {
	private static final Logger logger = Logger.getLogger(Tools.class);
	
	/**
	 * 得到yyyy-MM-dd HH:mm:ss格式的服务器当前日期时间
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrDefaultDateTime() {
		return formatDateTime(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 将Date对像格式化成对应的日期字符串
	 * @param date 要格式化的Date对像
	 * @param pattern 日期格式
	 * @return
	 */
	public static String formatDateTime(Date date, String pattern) {
		if(Tools.isNull(date)) return "";
		SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern);
		return sDateFormat.format(date);
	}
	
	/**
	 * 将输入文本格式化成相应的格式
	 * @param value 要格式化的文本
	 * @param currPattern 输入文本的日期格式
	 * @param newPattern 目标日期格式
	 * @return
	 */
	public static String formatDateTime(String value, String currPattern, String newPattern) {
		if(Tools.isNull(value)) return "";
		Date date = null;
		String dateTime = "";
		try {
			SimpleDateFormat sDateFormat = new SimpleDateFormat(currPattern);
			date = sDateFormat.parse(value);
			dateTime = formatDateTime(date, newPattern);
		} catch (ParseException e) {
			logger.error("格式化日期型字符串", e);
			throw new MisException("将字符串从格式" + currPattern + "转换为格式" + newPattern + "出错");
		}
		return dateTime;
	}
	
	/**
	 * 判断传入的对像是否为null，如果不为null判断对像是否空字符串
	 * @param str
	 * @return true:null、空引用或空字符串；false:不为空
	 */
	public static boolean isNull(Object obj) {
		boolean tag = true;
		if(obj != null) {
			tag = false;
			if(obj instanceof String) {
				tag = ((String)obj).trim().isEmpty();
			}
		}
		return tag;
	}
	
	public static boolean isEmpty(Object obj) {
		boolean tag = true;
		if(obj != null) {
			tag = false;
			if(obj instanceof String) {
				tag = ((String)obj).trim().isEmpty();
			} else if(obj instanceof Collection<?>) {
				tag = ((Collection<?>)obj).isEmpty();
			} else if(obj instanceof Integer) {
				tag = ((Integer)obj) == 0;
			} else if(obj instanceof Double) {
				tag = ((Double)obj) == 0;
			} else if(obj.getClass().isArray()){
		        Class<?> type = obj.getClass().getComponentType();
		        if(type == String.class) {
					String[] array = (String[])obj;
					tag = array.length < 1 || (array.length == 1 && array[0].equals(""));
		        }
			}
		}
		return tag;
	}
	
	/**
	 * 将java对像转换为json格式的字符串，如Collection,javabean
	 * 默认对空值不进行处理
	 * @param obj 要转换的java对像
	 * @return json格式的字符串
	 */
	public static String getJsonStringFromObject(Object obj) {
		if(isEmpty(obj)) return "[]";
		return JSONArray.fromObject(obj, getMisJsonConfig()).toString();
	}

	/**
	 * @return json-lib 数据处理配置扩展类，对数字为空不进行处理
	 */
	private static JsonConfig getMisJsonConfig() {
		JsonConfig jc = new JsonConfig();
		MisNullToJsonDefaultValueProcessor nullProcessor = new MisNullToJsonDefaultValueProcessor();
		jc.registerDefaultValueProcessor(Integer.class, nullProcessor);
		jc.registerDefaultValueProcessor(Double.class, nullProcessor);
		return jc;
	}

}
