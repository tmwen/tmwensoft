package com.tangmaowen.mis.sys.dao;

import java.util.List;
import java.util.Map;

import com.tangmaowen.mis.sys.domain.AuthorityBO;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.sys.domain.UserBO;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午12:36:04
 *
 */
public interface UsersDao {

	public UserBO getUserInfo(Integer id);

	public void insertUserInfo(UserBO bo);

	public void updateUserInfo(UserBO bo);
	
	public Map<String, Object> getUsersList(PageingBO bo);
	
	/**
	 * 用户列表，id排前
	 * @param id 用户ID, 可以为空
	 * @return
	 */
	public List<UserBO> getUserIDNameList(Integer id);

	public UserBO login(Integer id, String password);
	
	public List<AuthorityBO> getUserAuthority(Integer id);
	
	public boolean verifyPassword(Integer id, String password);
	
	public void passwordAlter(Integer id, String newpass);
	
	/**
	 * 角色ID字符串
	 * @param id
	 * @return ",1,3,8,12,"
	 */
	public String getUserRole(Integer id);

	public void updateUserRole(Integer userid, String roleids);
}
