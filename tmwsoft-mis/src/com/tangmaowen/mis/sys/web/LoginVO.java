package com.tangmaowen.mis.sys.web;


/**
 * @author 唐懋文
 * @since 2009-10-24 下午08:32:00
 *
 */
public class LoginVO {
	private String id;
	private String password;
	private String username;
	private String status;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}
