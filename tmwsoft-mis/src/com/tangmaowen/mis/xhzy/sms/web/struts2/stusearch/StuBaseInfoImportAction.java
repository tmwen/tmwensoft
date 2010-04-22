package com.tangmaowen.mis.xhzy.sms.web.struts2.stusearch;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ModelDriven;
import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.StudentBaseInfoImportVO;
import com.tangmaowen.mis.xhzy.sms.web.struts2.MisXhzySmsBaseAction;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-10 下午05:13:01
 *
 */
public class StuBaseInfoImportAction extends MisXhzySmsBaseAction implements ModelDriven<StudentBaseInfoImportVO> {

	private static final Logger logger = Logger.getLogger(StuBaseInfoImportAction.class);
	private List<StudentBaseInfoBO> list;
	
	@Override
	protected String misExecute() {
		try {
			/**
			if(studentBaseInfoImport.getUpload() == null) {  
				setResultInfo("{success: false, message: '请选择要导入的Excel文件'}");
	        } else if(!studentBaseInfoImport.getUploadFileName().endsWith(".xls")
	        		|| !studentBaseInfoImport.getUploadContentType().equals("application/vnd.ms-excel")) {  
				setResultInfo("{success: false, message: '请导入扩展名为xls的Excel文件'}");
	        } else {
		        //以服务器的文件保存地址savePath和原文件名建立上传文件输出流  
		        FileOutputStream fos = new FileOutputStream("upload\\" + getUploadFileName());  
		        //以上传文件建立一个文件上传流  
		        FileInputStream fis = new FileInputStream(getUpload());  
		        //将上传文件的内容写入服务器  
		        byte[] buffer = new byte[1024];  
		        int len = 0;  
		        while((len = fis.read(buffer)) > 0) {  
		            fos.write(buffer,0,len);  
		        }
	        }
	        */
	        StuDataExcelImportHolder holder = new StuDataExcelImportHolder();
	        studentBaseInfoImport.setUserid(userSession.getUserid());
	        studentBaseInfoImport.setUserIDNameArray(getUserIDNameArray());
	        list = holder.analyzeStuBaseData(studentBaseInfoImport);
	        getMisXhzySms().insertStudentInfoByExcel(list);
			setResultInfo("{success: true, message: '" + holder.getReturnInfo() + "', messageboxtype: 'alert'}");
		}catch(Exception e) {
			logger.error("导入学生基本信息", e);
			String info = Tools.isNull(e.getMessage()) ? e.toString() : e.getMessage();
			setResultInfo("{success: false, message: 'Excel文件内容有误，请检查！ " + info + "'}");
		}
		return Constants.FORWARDJSONINFO;
	}

	@Override
	protected String actionInfo() {
		String info = "";
		if(!Tools.isEmpty(list)) {
			info = Tools.getJsonStringFromObject(list);
			if(info.length() > 4900) info = info.substring(0, 4900) + "...";
			info = list.size() + "条:" + info;
		}
		return "导入学生基本信息:" + info;
	}
	
	private StudentBaseInfoImportVO studentBaseInfoImport = new StudentBaseInfoImportVO();

	@Override
	public StudentBaseInfoImportVO getModel() {
		return studentBaseInfoImport;
	}
}
