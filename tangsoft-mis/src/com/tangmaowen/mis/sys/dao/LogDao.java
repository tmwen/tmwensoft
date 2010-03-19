package com.tangmaowen.mis.sys.dao;

import java.util.Map;

import com.tangmaowen.mis.sys.domain.LogBO;
import com.tangmaowen.mis.sys.domain.PageingBO;

/**
 * @author 唐懋文
 * @since 2009-11-1 上午11:54:35
 *
 */
public interface LogDao {

	public void insertLog(LogBO bo);
	
	public Map<String, Object> getLogList(PageingBO bo);
	
	public LogBO getLogInfo(Integer id);
}
