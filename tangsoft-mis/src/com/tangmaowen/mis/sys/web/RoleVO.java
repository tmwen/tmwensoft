package com.tangmaowen.mis.sys.web;

/**
 * @author 唐懋文
 * @since 2009-11-20 下午02:25:11
 *
 */
public class RoleVO implements java.io.Serializable {

	private Integer roleid;

	private String rolename;

	private String roledesc;
	
	public RoleVO() {
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

}