package com.tangmaowen.mis.common.domain;

import java.io.Serializable;


/**
 * @author 唐懋文
 * @since 2009-10-25 下午03:18:43
 *
 */
public class UserSessionInfo implements Serializable {
	private Integer userid;
	private String accountid;
	private String username;
	private String status;
	private String logintime;
	private String authoritys;
	private String active;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public String getAuthoritys() {
		return authoritys;
	}
	public void setAuthoritys(String authoritys) {
		this.authoritys = authoritys;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}
