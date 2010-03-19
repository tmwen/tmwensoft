package com.tangmaowen.mis.xhzy.sms.web;

import java.io.File;
import java.io.Serializable;

/**
 * @author 唐懋文
 * @since 2009-11-25 下午06:31:42
 *
 */
public class StudentBaseInfoImportVO implements Serializable {

	private File upload;
    private String uploadContentType;
    private String uploadFileName;
	private Integer userid;
	private String[][] userIDNameArray;
	private String jie;
	private String jj;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String[][] getUserIDNameArray() {
		return userIDNameArray;
	}
	public void setUserIDNameArray(String[][] userIDNameArray) {
		this.userIDNameArray = userIDNameArray;
	}
	public String getJie() {
		return jie;
	}
	public void setJie(String jie) {
		this.jie = jie;
	}
	public String getJj() {
		return jj;
	}
	public void setJj(String jj) {
		this.jj = jj;
	}
}
