package com.tangmaowen.mis.sys.dao.hibernate.maps;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午12:40:46
 *
 */
public class UserPO implements Serializable {
	private Integer userid;
	private String accountid;
	private String active;
	private String username;
	private String password;
	private String email;
	private String status;
	private String addressunit;
	private String addresshome;
	private String phoneunit;
	private String phonehome;
	private String lastvisittime;
	private Integer visitcount;
	private Integer creater;
	private String createtime;
	private Integer lastupdater;
	private String lastupdatertime;
	private Set<UserRolePO> userRoles = new HashSet<UserRolePO>(0);
	
	public UserPO() {}
	
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getLastvisittime() {
		return lastvisittime;
	}
	public void setLastvisittime(String lastvisittime) {
		this.lastvisittime = lastvisittime;
	}
	public Integer getVisitcount() {
		return visitcount;
	}
	public void setVisitcount(Integer visitcount) {
		this.visitcount = visitcount;
	}
	public Integer getCreater() {
		return creater;
	}
	public void setCreater(Integer creater) {
		this.creater = creater;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getLastupdater() {
		return lastupdater;
	}
	public void setLastupdater(Integer lastupdater) {
		this.lastupdater = lastupdater;
	}
	public String getLastupdatertime() {
		return lastupdatertime;
	}
	public void setLastupdatertime(String lastupdatertime) {
		this.lastupdatertime = lastupdatertime;
	}
	public Set<UserRolePO> getUserRoles() {
		return this.userRoles;
	}
	public void setUserRoles(Set<UserRolePO> userRoles) {
		this.userRoles = userRoles;
	}
}
