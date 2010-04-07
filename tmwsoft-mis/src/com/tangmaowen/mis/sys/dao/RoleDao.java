package com.tangmaowen.mis.sys.dao;

import java.util.List;

import com.tangmaowen.mis.sys.domain.RoleBO;

/**
 * @author 唐懋文
 * @since 2009-11-16 上午10:49:00
 *
 */
public interface RoleDao {
	
	public List<RoleBO> getAllRole();
	
	public RoleBO getRole(Integer id);
	
	public RoleBO insertRole(RoleBO bo);

	public RoleBO updateRole(RoleBO bo);
	
	public RoleBO deleteRole(Integer id);
}
