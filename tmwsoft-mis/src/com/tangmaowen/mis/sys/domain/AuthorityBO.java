package com.tangmaowen.mis.sys.domain;

import java.io.Serializable;

public class AuthorityBO implements Serializable {
	
	private String authid;
	private String authname;
	private String authdesc;
	private String authtype;
	private boolean check;
	
	public String getAuthid() {
		return authid;
	}
	public void setAuthid(String authid) {
		this.authid = authid;
	}
	public String getAuthname() {
		return authname;
	}
	public void setAuthname(String authname) {
		this.authname = authname;
	}
	public String getAuthdesc() {
		return authdesc;
	}
	public void setAuthdesc(String authdesc) {
		this.authdesc = authdesc;
	}
	public String getAuthtype() {
		return authtype;
	}
	public void setAuthtype(String authtype) {
		this.authtype = authtype;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}

}
