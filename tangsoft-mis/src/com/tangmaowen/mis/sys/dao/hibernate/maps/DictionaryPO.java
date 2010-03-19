package com.tangmaowen.mis.sys.dao.hibernate.maps;

import java.io.Serializable;

/**
 * @author 唐懋文
 * @since 2009-10-29 下午08:07:12
 *
 */
public class DictionaryPO implements Serializable {

	private Integer dictid;
	private String dictcode;
	private String codecontent;
	private String parentcode;
	private Integer levelseq;
	private Integer level;

	public DictionaryPO() {}
	
	public Integer getDictid() {
		return dictid;
	}
	public void setDictid(Integer dictid) {
		this.dictid = dictid;
	}
	public String getDictcode() {
		return dictcode;
	}
	public void setDictcode(String dictcode) {
		this.dictcode = dictcode;
	}
	public String getCodecontent() {
		return codecontent;
	}
	public void setCodecontent(String codecontent) {
		this.codecontent = codecontent;
	}
	public String getParentcode() {
		return parentcode;
	}
	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}
	public Integer getLevelseq() {
		return levelseq;
	}
	public void setLevelseq(Integer levelseq) {
		this.levelseq = levelseq;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
}
