package com.tangmaowen.mis.xhzy.sms.web.struts2.stusearch;

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
	private int cellnum;
	
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
    		cellnum = -1;
        	setCellValue(bo.getMsbbh());
        	setCellValue(formatDateToyyMMdd(bo.getMsrq()));
        	setCellValue(bo.getJie());
        	setCellValue(getDictValue(DictConstants.JJ, bo.getJj()));
        	setCellValue(bo.getXm());
        	setCellValue(getDictValue(DictConstants.XB, bo.getXb()));
        	setCellValue(getDictValue(DictConstants.MZ, bo.getMz()));
        	setCellValue(getStringByDouble(bo.getSg()));
        	setCellValue(getDictValue(DictConstants.BKXL, bkxl = bo.getBkxl()));
        	setCellValue(getBdzy(bo.getBdzy()));
        	setCellValue(getDictValue(DictConstants.ZZMM, bo.getZzmm()));
        	setCellValue(formatDateToyyMMdd(bo.getCsrq()));
        	setCellValue(bo.getSfzhm());
        	setCellValue(getDictValue(DictConstants.HJ, bo.getHj()));
        	setCellValue(getDictValue(DictConstants.KSLB, bo.getKslb()));
        	setCellValue(getDictValue(DictConstants.YKLX, bo.getYklx()));
        	setCellValue(getDictValue(DictConstants.BYZ, bo.getByz()));
        	setCellValue(bo.getJtxsdz());
        	setCellValue(bo.getXslxdh());
        	setCellValue(bo.getJzlxdh());
        	setCellValue(bo.getByxx());
        	setCellValue(bo.getSyd());
        	setCellValue(bo.getZsls());
        	setCellValue(getUserName(bo.getZfzr()));
        	setCellValue(getDictValue(DictConstants.ZS, bo.getZs()));
        	setCellValue(getDictValue(DictConstants.TJ, bo.getTj()));
        	setCellValue(getDictValue(DictConstants.LQ, bo.getLq()));
        	setCellValue(getDictValue(DictConstants.BDK, bo.getBdk()));
        	setCellValue(getDictValue(DictConstants.XY, bo.getXy()));
        	setCellValue(bo.getBz());
    		// 费用
        	setCellValue(formatDateToyyMMdd(bo.getYjfrq()));
        	setCellValue(getStringByDouble(bo.getYjfje()));
        	setCellValue(bo.getYjfskr());
        	setCellValue(formatDateToyyMMdd(bo.getJfrq()));
        	setCellValue(getStringByDouble(bo.getJfje()));
        	setCellValue(getSkrName(bo.getJfskr()));
        	setCellValue(formatDateToyyMMdd(bo.getJfrq2()));
        	setCellValue(getStringByDouble(bo.getJfje2()));
        	setCellValue(getSkrName(bo.getJfskr2()));
        	setCellValue(getStringByDouble(bo.getJfze()));
        	setCellValue(getStringByDouble(bo.getYjje()));
        	setCellValue(bo.getCwbz());
        }
	}
	
	private void setCellValue(String value) {
		if(Tools.isEmpty(value)) value = "";
    	HSSFCell cell = row.createCell(++cellnum);
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
