package com.tangmaowen.mis.xhzy.sms.web.struts2.stusearch;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import com.tangmaowen.mis.common.AuthorityConstants;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-27 下午03:08:16
 *
 */
public class StuBaseInfoExportAction extends StuSearchBaseAction {
	
	private static final Logger logger = Logger.getLogger(StuBaseInfoExportAction.class);
	private ByteArrayOutputStream out;
	
	@SuppressWarnings("unchecked")
	@Override
	protected String misExecute() {
		try {
			if(userSession.getAuthoritys().indexOf(AuthorityConstants.D_ALL) != -1 || userSession.getAuthoritys().indexOf(AuthorityConstants.D_ONESELF) != -1) {
				Map<String, ?> map = getMisXhzySms().getStudentBaseInfoList(getPageing());
				List<StudentBaseInfoBO> boList = (List<StudentBaseInfoBO>)map.get("boList");
				ServletContext servletContext = (ServletContext)context.get("com.opensymphony.xwork2.dispatcher.ServletContext");
				String excelTempPath = servletContext.getRealPath(Constants.STUINFOEXCELTEMP);
				StuDataExcelExportHolder holder = new StuDataExcelExportHolder();
				out = holder.exportStuBaseInfo(boList, getUserIDNameArray(), excelTempPath);
			} else {
				setResultInfo("{success: false, message: '无数据权限'}");
			}
		} catch (Exception e) {
			logger.error("导出学生基本信息", e);
			String info = Tools.isNull(e.getMessage()) ? e.toString() : e.getMessage();
			setResultInfo("{success: false, message: '导出Excel文件失败：" + info + "'}");
		}
		return SUCCESS;
	}

	@Override
	protected String actionInfo() {
		return "导出学生基本信息";
	}
	
	private String fileName;
	private String exportContent;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getExportContent() {
		return exportContent;
	}

	public void setExportContent(String exportContent) {
		this.exportContent = exportContent;
	}

	public String getDownloadFileName() throws Exception {
		String downFileName = fileName;
		downFileName = "学生信息" + Tools.getCurrDefaultDateTime() + ".xls";
		String newstr = new String(downFileName.getBytes("GBK"), "ISO-8859-1");
		return newstr;
	}
	
	public InputStream getInputStream() throws Exception {
		return new ByteArrayInputStream(out.toByteArray());
	}
}
