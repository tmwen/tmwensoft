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
public interface RoleAuthorityDao {
	
	public String getRoleAuth(Integer id);

	public void updateRoleAuth(Integer roleid, String authids);

}
