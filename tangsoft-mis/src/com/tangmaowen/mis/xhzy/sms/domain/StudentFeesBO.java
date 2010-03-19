package com.tangmaowen.mis.xhzy.sms.domain;

import java.io.Serializable;

/**
 * @author 唐懋文
 * @since 2009-11-4 上午12:00:13
 *
 */
public class StudentFeesBO implements Serializable {

	private Integer feeid = null;
	private Integer stuid = null;
	private String jfrq = null;
	private Double je = null;
	private String skr = null;
	private String jflx = null;
	private Integer creater = null;
	private String createtime = null;
	private Integer lastupdater = null;
	private String lastupdatertime = null;
	
	public Integer getFeeid() {
		return feeid;
	}
	public void setFeeid(Integer feeid) {
		this.feeid = feeid;
	}
	public Integer getStuid() {
		return stuid;
	}
	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}
	public String getJfrq() {
		return jfrq;
	}
	public void setJfrq(String jfrq) {
		this.jfrq = jfrq;
	}
	public Double getJe() {
		return je;
	}
	public void setJe(Double je) {
		this.je = je;
	}
	public String getSkr() {
		return skr;
	}
	public void setSkr(String skr) {
		this.skr = skr;
	}
	public String getJflx() {
		return jflx;
	}
	public void setJflx(String jflx) {
		this.jflx = jflx;
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
	
	public void reset() {
		feeid = null;
		stuid = null;
		jfrq = null;
		je = null;
		skr = null;
		jflx = null;
		creater = null;
		createtime = null;
		lastupdater = null;
		lastupdatertime = null;
	}
}
