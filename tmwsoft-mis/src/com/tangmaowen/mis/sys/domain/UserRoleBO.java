package com.tangmaowen.mis.sys.domain;

/**
 * @author 唐懋文
 * @since 2009-11-23 下午08:31:26
 *
 */
public class UserRoleBO implements java.io.Serializable {

	private Integer userid;
	private Integer roleid;

	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
}