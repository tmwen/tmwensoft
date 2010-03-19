/**
 * @author 唐懋文
 * @since 2009-11-23下午04:04:13
 */
package com.tangmaowen.mis.sys.dao;

/**
 * @author 唐懋文
 * @since 2009-11-23 下午04:04:13
 *
 */
public interface UserRoleDao {
	
	public String getUserRole(Integer id);

	public void updateUserRole(Integer userid, String roleids);

}
