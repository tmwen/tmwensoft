package com.tangmaowen.mis.sys.dao.hibernate.maps;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 唐懋文
 * @since 2009-11-13 下午04:35:17
 *
 */
public class AuthorityPO implements Serializable {

	private String authid;

	private String authname;

	private String authdesc;

	private String authtype;

	private Set<RoleAuthorityPO> roleAuthorities = new HashSet<RoleAuthorityPO>(0);

	public AuthorityPO() {
	}

	public AuthorityPO(String authid, String authname) {
		this.authid = authid;
		this.authname = authname;
	}

	public AuthorityPO(String authid, String authname, String authdesc,
			String authtype, Set<RoleAuthorityPO> roleAuthorities) {
		this.authid = authid;
		this.authname = authname;
		this.authdesc = authdesc;
		this.authtype = authtype;
		this.roleAuthorities = roleAuthorities;
	}
	
	public String getAuthid() {
		return this.authid;
	}

	public void setAuthid(String authid) {
		this.authid = authid;
	}

	public String getAuthname() {
		return this.authname;
	}

	public void setAuthname(String authname) {
		this.authname = authname;
	}

	public String getAuthdesc() {
		return this.authdesc;
	}

	public void setAuthdesc(String authdesc) {
		this.authdesc = authdesc;
	}

	public String getAuthtype() {
		return this.authtype;
	}

	public void setAuthtype(String authtype) {
		this.authtype = authtype;
	}

	public Set<RoleAuthorityPO> getRoleAuthorities() {
		return this.roleAuthorities;
	}

	public void setRoleAuthorities(Set<RoleAuthorityPO> roleAuthorities) {
		this.roleAuthorities = roleAuthorities;
	}
}
