package com.tangmaowen.mis.sys.domain;

/**
 * @author 唐懋文
 * @since 2009-11-23 上午11:10:42
 *
 */
public class RoleAuthorityBO implements java.io.Serializable {

	private Integer roleid;
	private String authid;
	
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getAuthid() {
		return authid;
	}
	public void setAuthid(String authid) {
		this.authid = authid;
	}
}