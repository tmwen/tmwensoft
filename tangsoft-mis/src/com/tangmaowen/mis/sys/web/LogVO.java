package com.tangmaowen.mis.sys.web;

import java.io.Serializable;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午12:40:46
 *
 */
public class LogVO implements Serializable {
	private Integer userid;
	private String username;
	private String email;
	private String status;
	private String addressunit;
	private String addresshome;
	private String phoneunit;
	private String phonehome;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddressunit() {
		return addressunit;
	}
	public void setAddressunit(String addressunit) {
		this.addressunit = addressunit;
	}
	public String getAddresshome() {
		return addresshome;
	}
	public void setAddresshome(String addresshome) {
		this.addresshome = addresshome;
	}
	public String getPhoneunit() {
		return phoneunit;
	}
	public void setPhoneunit(String phoneunit) {
		this.phoneunit = phoneunit;
	}
	public String getPhonehome() {
		return phonehome;
	}
	public void setPhonehome(String phonehome) {
		this.phonehome = phonehome;
	}
}
