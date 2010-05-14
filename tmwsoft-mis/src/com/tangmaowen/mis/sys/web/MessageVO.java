package com.tangmaowen.mis.sys.web;

import java.io.Serializable;

public class MessageVO implements Serializable {
	
	private String active;
	private String info;
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
