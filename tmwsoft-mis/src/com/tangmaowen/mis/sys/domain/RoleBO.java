package com.tangmaowen.mis.sys.domain;

/**
 * @author 唐懋文
 * @since 2009-11-16 上午10:55:25
 *
 */
public class RoleBO implements java.io.Serializable {

	private Integer roleid;
	private String rolename;
	private String roledesc;
	private boolean check;
	
	public RoleBO() {
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

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

}