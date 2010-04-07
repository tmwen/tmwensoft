package com.tangmaowen.mis.sys.domain.logic;

import java.util.List;
import java.util.Map;

import com.tangmaowen.mis.common.domain.logic.MisFacade;
import com.tangmaowen.mis.sys.domain.AuthorityBO;
import com.tangmaowen.mis.sys.domain.DictionaryBO;
import com.tangmaowen.mis.sys.domain.LogBO;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.sys.domain.RoleBO;
import com.tangmaowen.mis.sys.domain.UserBO;

/**
 * @author 唐懋文
 * @since 2009-10-20 上午01:41:41
 *
 */
public interface MisSysFacade extends MisFacade {
	
	//---------------users---------------------------
	public UserBO getUserInfo(Integer id);

	public void insertUserInfo(UserBO bo);

	public void updateUserInfo(UserBO bo);

	public Map<String, Object> getUsersList(PageingBO bo);
	
	/**
	 * 根据用户账号状态来停用或启用账号
	 * @param id 用户id
	 * @return 账号状态
	 */
	public String changeUserActive(Integer id);
	
	public List<RoleBO> getUserRole(Integer id);

	public void updateUserRole(Integer userid, String roleids);
	
	//---------------user---------------------------
	
	public boolean verifyPassword(Integer id, String password);
	
	public void passwordAlter(Integer id, String newpass);
	
	//---------------log---------------------------
	
	public Map<String, Object> getLogList(PageingBO bo);
	
	public LogBO getLogInfo(Integer id);
	
	//---------------dics---------------------------
	public List<DictionaryBO> getDictionaryList();
	
	public List<DictionaryBO> getDicRootCodeList();
	
	public List<DictionaryBO> getEntryList(String parentcode);
	
	public DictionaryBO insertEntry(DictionaryBO bo);

	public DictionaryBO updateEntry(DictionaryBO bo);
	
	public DictionaryBO deleteEntry(Integer id);

	//---------------authority---------------------------
	
	public List<AuthorityBO> getAllAuth();
	
	public List<AuthorityBO> getRoleAuth(Integer id);

	public void updateRoleAuth(Integer roleid, String authids);
	
	//---------------role---------------------------
	public List<RoleBO> getRoleList();
	
	public RoleBO getRole(Integer id);
	
	public RoleBO insertRole(RoleBO bo);

	public RoleBO updateRole(RoleBO bo);
	
	public RoleBO deleteRole(Integer id);
}
