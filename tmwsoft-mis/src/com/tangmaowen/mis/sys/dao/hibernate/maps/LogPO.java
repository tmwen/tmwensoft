package com.tangmaowen.mis.sys.dao.hibernate.maps;

import java.io.Serializable;

/**
 * @author 唐懋文
 * @since 2009-11-1 上午11:54:03
 *
 */
public class LogPO implements Serializable {

	private Integer logid;
	private Integer operater;
	private String opertime;
	private String operip;
	private String operaction;
	private String operinfo;
	private String operresult;
	
	public LogPO() {}
	
	public Integer getLogid() {
		return logid;
	}
	public void setLogid(Integer logid) {
		this.logid = logid;
	}
	public Integer getOperater() {
		return operater;
	}
	public void setOperater(Integer operater) {
		this.operater = operater;
	}
	public String getOpertime() {
		return opertime;
	}
	public void setOpertime(String opertime) {
		this.opertime = opertime;
	}
	public String getOperip() {
		return operip;
	}
	public void setOperip(String operip) {
		this.operip = operip;
	}
	public String getOperaction() {
		return operaction;
	}
	public void setOperaction(String operaction) {
		this.operaction = operaction;
	}
	public String getOperinfo() {
		return operinfo;
	}
	public void setOperinfo(String operinfo) {
		this.operinfo = operinfo;
	}
	public String getOperresult() {
		return operresult;
	}
	public void setOperresult(String operresult) {
		this.operresult = operresult;
	}
	
}
