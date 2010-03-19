package com.tangmaowen.mis.sys.dao;

import java.util.List;

import com.tangmaowen.mis.sys.domain.DictionaryBO;

/**
 * @author 唐懋文
 * @since 2009-10-30 上午09:53:44
 *
 */
public interface DictionaryDao {
	
	/**
	 * @return 全部数据字典编码列表
	 */
	public List<DictionaryBO> getDictionaryList();
	
	/**
	 * @return 数据字典根编码列表
	 */
	public List<DictionaryBO> getDicRootCodeList();
	
	public List<DictionaryBO> getEntryList(String parentcode);
	
	public DictionaryBO getEntry(Integer id);
	
	public DictionaryBO insertEntry(DictionaryBO bo);

	public DictionaryBO updateEntry(DictionaryBO bo);
	
	public DictionaryBO deleteEntry(Integer id);
}
