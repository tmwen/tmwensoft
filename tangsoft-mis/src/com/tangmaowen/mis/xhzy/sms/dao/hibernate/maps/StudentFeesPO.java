package com.tangmaowen.mis.xhzy.sms.dao.hibernate.maps;

import java.io.Serializable;

/**
 * @author 唐懋文
 * @since 2009-11-4 上午12:00:13
 *
 */
public class StudentFeesPO implements Serializable {

	private Integer feeid;
	private Integer stuid;
	private String jfrq;
	private Double je;
	private String skr;
	private String jflx;
	private Integer creater;
	private String createtime;
	private Integer lastupdater;
	private String lastupdatertime;
	
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
}
