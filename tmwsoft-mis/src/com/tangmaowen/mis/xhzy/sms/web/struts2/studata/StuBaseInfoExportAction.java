package com.tangmaowen.mis.xhzy.sms.web.struts2.studata;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.AuthorityConstants;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.StudentSearchInfoVO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-27 下午03:08:16
 *
 */
public class StuBaseInfoExportAction extends MisXhzySmsBaseAction implements ModelDriven<StudentSearchInfoVO> {
	
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
	
	private PageingBO getPageing(){
		PageingBO bo = new PageingBO();
		bo.setStart(0);
		bo.setLimit(-1);

		bo.setConditionExceptNull("and", "", "", "bkxl", "=", studentBaseInfo.getBkxl());
		bo.setConditionExceptNull("and", "", "", "jie", "=", studentBaseInfo.getJie());
		bo.setConditionExceptNull("and", "", "", "jj", "=", studentBaseInfo.getJj());
		bo.setConditionExceptNull("and", "", "", "msrq", "=", studentBaseInfo.getMsrq());
		bo.setConditionExceptNull("and", "", "", "msbbh", "like", studentBaseInfo.getMsbbh());
		bo.setConditionExceptNull("and", "", "", "xm", "like", studentBaseInfo.getXm());
		bo.setConditionExceptNull("and", "", "", "sfzhm", "like", studentBaseInfo.getSfzhm());
		bo.setConditionExceptNull("and", "", "", "bdzy", "=", studentBaseInfo.getBdzy());
		bo.setConditionExceptNull("and", "", "", "xb", "=", studentBaseInfo.getXb());
		bo.setConditionExceptNull("and", "", "", "mz", "=", studentBaseInfo.getMz());
		bo.setConditionExceptNull("and", "", "", "zzmm", "=", studentBaseInfo.getZzmm());
		bo.setConditionExceptNull("and", "", "", "zfzr", "=", studentBaseInfo.getZfzr());
		bo.setConditionExceptNull("and", "", "", "zsls", "=", studentBaseInfo.getZsls());
		bo.setConditionExceptNull("and", "", "", "byxx", "like", studentBaseInfo.getByxx());
		bo.setConditionExceptNull("and", "", "", "syd", "like", studentBaseInfo.getSyd());
		bo.setConditionExceptNull("and", "", "", "lq", "=", studentBaseInfo.getLq());
		bo.setConditionExceptNull("and", "", "", "jfze", ">=", studentBaseInfo.getJfze());
		if(null != studentBaseInfo.getYjfje() && 0 == studentBaseInfo.getYjfje()) {
			bo.setConditionExceptNull("and", "(", "", "yjfje", "<=", 0.01);
			bo.setCondition("or", ")", "", "yjfje", "=", null);
		} else {
			bo.setConditionExceptNull("and", "", "", "yjfje", ">=", studentBaseInfo.getYjfje());
		}
		if(null != studentBaseInfo.getJfje() && 0 == studentBaseInfo.getJfje()) {
			bo.setConditionExceptNull("and", "(", "", "jfje", "<=", 0.01);
			bo.setCondition("or", ")", "", "jfje", "=", null);
		} else {
			bo.setConditionExceptNull("and", "", "", "jfje", ">=", studentBaseInfo.getJfje());
		}
		
		if(userSession.getAuthoritys().indexOf(AuthorityConstants.D_ALL) == -1 && userSession.getAuthoritys().indexOf(AuthorityConstants.D_ONESELF) != -1) {
			bo.setConditionExceptNull("and", "(", "", "zfzr", "=", userSession.getUserid());
			bo.setConditionExceptNull("or", "", "", "creater", "=", userSession.getUserid());
			bo.setConditionExceptNull("or", ")", "", "lastupdater", "=", userSession.getUserid());
		}
		bo.setOrder("stuid", "desc");
		return bo;
	}

	@Override
	protected String actionInfo() {
		return "导出学生基本信息";
	}
	
	private StudentSearchInfoVO studentBaseInfo = new StudentSearchInfoVO();

	@Override
	public StudentSearchInfoVO getModel() {
		return studentBaseInfo;
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
