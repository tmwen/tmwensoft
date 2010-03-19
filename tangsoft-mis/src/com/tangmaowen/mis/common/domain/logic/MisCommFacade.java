package com.tangmaowen.mis.common.domain.logic;

import java.util.List;

import com.tangmaowen.mis.sys.domain.AuthorityBO;
import com.tangmaowen.mis.sys.domain.DictionaryBO;
import com.tangmaowen.mis.sys.domain.LogBO;
import com.tangmaowen.mis.sys.domain.UserBO;

/**
 * @author 唐懋文
 * @since 2009-10-20 上午01:41:41
 *
 */
public interface MisCommFacade extends MisFacade {
	
	
	//---------------login---------------------------
	public UserBO login(String loginid, String password);
	
	public List<AuthorityBO> getUserAuthority(Integer id);
	
	public String getUserAuthorityByStr(Integer id);
	
	public void updateUserLoginInfo(Integer id);

	public void insertLog(LogBO bo);
	
	public List<AuthorityBO> getAuth(String authtype);
	
	//---------------dics---------------------------
	public List<DictionaryBO> getDictionaryList();

	//---------------users---------------------------
	/**
	 * @param system 所属系统名称
	 * @param id 用户ID
	 * @return 所在系统的用户ID和名称的数组, 其中将id排前
	 */
	public String[][] getUserIDNameArray(String system, Integer id);
	
	/**
	 * @param system 所属系统名称
	 * @param id 用户ID
	 * @return 所在系统启用的用户ID和名称的JS数组，形如[['1001', '张三'], ['1002', '王五2']]
	 */
	public String getAliveUserIDNameJsArray(String system, Integer id);
	
	/**
	 * @param system 所属系统名称
	 * @param id 用户ID
	 * @return 所在系统所有的用户ID和名称的JS数组，形如[['1001', '张三'], ['1002', '王五2']]
	 */
	public String getUserIDNameJsArray(String system, Integer id);
}
