package com.tangmaowen.mis.sys.dao;

/**
 * @author 唐懋文
 * @since 2009-11-23 下午04:04:13
 *
 */
public interface UserRoleDao {
	
	/**
	 * 角色ID字符串
	 * @param id
	 * @return ",1,3,8,12,"
	 */
	public String getUserRole(Integer id);

	public void updateUserRole(Integer userid, String roleids);

}
