package com.tangmaowen.mis.sys.dao.hibernate.maps;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 唐懋文
 * @since 2009-11-13 下午04:36:36
 *
 */
public class RolePO implements java.io.Serializable {

	private Integer roleid;

	private String rolename;

	private String roledesc;

	private Set<UserRolePO> userRoles = new HashSet<UserRolePO>(0);

	private Set<RoleAuthorityPO> roleAuthorities = new HashSet<RoleAuthorityPO>(0);
	
	public RolePO() {
	}

	public RolePO(Integer roleid, String rolename) {
		this.roleid = roleid;
		this.rolename = rolename;
	}

	public RolePO(Integer roleid, String rolename, String roledesc,
			Set<UserRolePO> userRoles, Set<RoleAuthorityPO> roleAuthorities) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.roledesc = roledesc;
		this.userRoles = userRoles;
		this.roleAuthorities = roleAuthorities;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledesc() {
		return this.roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public Set<UserRolePO> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRolePO> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<RoleAuthorityPO> getRoleAuthorities() {
		return this.roleAuthorities;
	}

	public void setRoleAuthorities(Set<RoleAuthorityPO> roleAuthorities) {
		this.roleAuthorities = roleAuthorities;
	}

}