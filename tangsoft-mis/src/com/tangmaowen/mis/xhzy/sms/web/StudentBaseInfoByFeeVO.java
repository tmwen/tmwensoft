package com.tangmaowen.mis.xhzy.sms.web;

import java.io.Serializable;

/**
 * @author 唐懋文
 * @since 2009-12-29 下午08:40:21
 *
 */
public class StudentBaseInfoByFeeVO implements Serializable {

	private Integer stuid;
	private String yjfrq;
	private Double yjfje;
	private String yjfskr;
	private String jfrq;
	private Double jfje;
	private String jfskr;
	private Double jfze;
	private Double yjje;
	private String cwbz;
	
	public Integer getStuid() {
		return stuid;
	}
	public void setStuid(Integer stuid) {
		this.stuid = stuid;
	}
	public String getYjfrq() {
		return yjfrq;
	}
	public void setYjfrq(String yjfrq) {
		this.yjfrq = yjfrq;
	}
	public Double getYjfje() {
		return yjfje;
	}
	public void setYjfje(Double yjfje) {
		this.yjfje = yjfje;
	}
	public String getYjfskr() {
		return yjfskr;
	}
	public void setYjfskr(String yjfskr) {
		this.yjfskr = yjfskr;
	}
	public String getJfrq() {
		return jfrq;
	}
	public void setJfrq(String jfrq) {
		this.jfrq = jfrq;
	}
	public Double getJfje() {
		return jfje;
	}
	public void setJfje(Double jfje) {
		this.jfje = jfje;
	}
	public String getJfskr() {
		return jfskr;
	}
	public void setJfskr(String jfskr) {
		this.jfskr = jfskr;
	}
	public Double getJfze() {
		return jfze;
	}
	public void setJfze(Double jfze) {
		this.jfze = jfze;
	}
	public Double getYjje() {
		return yjje;
	}
	public void setYjje(Double yjje) {
		this.yjje = yjje;
	}
	public String getCwbz() {
		return cwbz;
	}
	public void setCwbz(String cwbz) {
		this.cwbz = cwbz;
	}
}
