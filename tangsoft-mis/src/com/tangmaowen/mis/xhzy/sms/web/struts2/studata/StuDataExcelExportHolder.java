package com.tangmaowen.mis.xhzy.sms.web.struts2.studata;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.tangmaowen.mis.common.DictConstants;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.utils.Dictionary;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-30 上午09:39:54
 *
 */
public class StuDataExcelExportHolder {
	
	private HSSFRow row;
	private String bkxl;
	private String[][] userIDNameArray;
	
	public ByteArrayOutputStream exportStuBaseInfo(List<StudentBaseInfoBO> boList, String[][] userIDNameArray, String excelTempPath) throws Exception {
		this.userIDNameArray = userIDNameArray;
		POIFSFileSystem fs =new POIFSFileSystem(new FileInputStream(excelTempPath));
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        generateContentDatas(boList, wb, sheet);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        wb.write(out);
		return out;
	}
	
	private void generateContentDatas(List<StudentBaseInfoBO> boList,HSSFWorkbook wb,HSSFSheet sheet){
		for(int i = 0; i < boList.size(); i++){
        	StudentBaseInfoBO bo = boList.get(i);
        	row = sheet.createRow(i + 3);// 起始行3
        	setCellValue(0, bo.getMsbbh());
        	setCellValue(1, formatDateToyyMMdd(bo.getMsrq()));
        	setCellValue(2, bo.getJie());
        	setCellValue(3, getDictValue(DictConstants.JJ, bo.getJj()));
        	setCellValue(4, bo.getXm());
        	setCellValue(5, getDictValue(DictConstants.XB, bo.getXb()));
        	setCellValue(6, getDictValue(DictConstants.MZ, bo.getMz()));
        	setCellValue(7, getStringByDouble(bo.getSg()));
        	setCellValue(8, getDictValue(DictConstants.BKXL, bkxl = bo.getBkxl()));
        	setCellValue(9, getBdzy(bo.getBdzy()));
        	setCellValue(10, getDictValue(DictConstants.ZZMM, bo.getZzmm()));
        	setCellValue(11, formatDateToyyMMdd(bo.getCsrq()));
        	setCellValue(12, bo.getSfzhm());
        	setCellValue(13, getDictValue(DictConstants.HJ, bo.getHj()));
        	setCellValue(14, getDictValue(DictConstants.KSLB, bo.getKslb()));
        	setCellValue(15, getDictValue(DictConstants.YKLX, bo.getYklx()));
        	setCellValue(16, getDictValue(DictConstants.BYZ, bo.getByz()));
        	setCellValue(17, bo.getJtxsdz());
        	setCellValue(18, bo.getXslxdh());
        	setCellValue(19, bo.getJzlxdh());
        	setCellValue(20, bo.getByxx());
        	setCellValue(21, bo.getSyd());
        	setCellValue(22, bo.getZsls());
        	setCellValue(23, getUserName(bo.getZfzr()));
        	setCellValue(24, getDictValue(DictConstants.ZS, bo.getZs()));
        	setCellValue(25, getDictValue(DictConstants.TJ, bo.getTj()));
        	setCellValue(26, getDictValue(DictConstants.LQ, bo.getLq()));
        	setCellValue(27, formatDateToyyMMdd(bo.getYjfrq()));
        	setCellValue(28, getStringByDouble(bo.getYjfje()));
        	setCellValue(29, getSkrName(bo.getYjfskr()));
        	setCellValue(30, formatDateToyyMMdd(bo.getJfrq()));
        	setCellValue(31, getStringByDouble(bo.getJfje()));
        	setCellValue(32, getSkrName(bo.getJfskr()));
        	setCellValue(33, bo.getBz());
        }
	}
	
	private void setCellValue(int cellCount, String value) {
		if(Tools.isEmpty(value)) value = "";
    	HSSFCell cell = row.createCell(cellCount);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(new HSSFRichTextString(value));
		
	}
	
	private String getDictValue(String code, String key) {
		if(Tools.isNull(key)) return "";
		String value = Dictionary.getInstance().dicValueByKey(code, key);
		if(Tools.isNull(value)) return "";
		return value;
	}
	
	private String formatDateToyyMMdd(String value) {
		if(Tools.isEmpty(value) || value.length() != 10) return "";
		return Tools.formatDateTime(value, "yyyy-MM-dd", "yyMMdd");
	}
	
	private String getBdzy(String key) {
		String value = "";
		if("1".equals(bkxl)) {
			value = getDictValue(DictConstants.BDZYDZ, key);
		} else if("2".equals(bkxl)) {
			value = getDictValue(DictConstants.BDZYZZ, key);
		}
		return value;
	}
	
	private String getUserName(Integer userId) {
		if(Tools.isNull(userId)) return "";
		return getUserNameHolder(userId);
	}

	private String getSkrName(String userId) {
		if(Tools.isNull(userId)) return "";
		if(userId.matches("^[0-9]*$")) {
			return getUserNameHolder(Integer.valueOf(userId));
		}
		return userId;
	}
	
	private String getUserNameHolder(Integer userId) {
		if(Tools.isEmpty(userIDNameArray)) return "";
		for(int i = 0; i < userIDNameArray.length; i++) {
			Integer id = Integer.valueOf(userIDNameArray[i][0]);
			if(id.equals(userId)) {
				return userIDNameArray[i][1];
			}
		}
		return "";
	}
	
	private String getStringByDouble(Double value) {
		if(Tools.isEmpty(value)) return "";
		return String.valueOf(value);
	}
	
}
