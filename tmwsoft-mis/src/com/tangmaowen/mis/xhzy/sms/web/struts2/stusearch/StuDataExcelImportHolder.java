package com.tangmaowen.mis.xhzy.sms.web.struts2.stusearch;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.tangmaowen.mis.common.DictConstants;
import com.tangmaowen.mis.common.MisException;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.web.StudentBaseInfoImportVO;
import com.tangmaowen.utils.Dictionary;
import com.tangmaowen.utils.Tools;

/**
 * 学生基本信息excel导入数据库student_baseinfo表处理类
 * @author 唐懋文
 * @since 2009-11-11 下午05:30:46
 *
 */
public class StuDataExcelImportHolder {

	private StudentBaseInfoImportVO importInfo;
	private HSSFRow sourceRow;
	private String bkxl;
	private boolean allowInsert=false;
	private int notAllowRowsCount = 0;
	private String notAllowRows = "";
	private String returnInfo = "";
	private int cellnum = -1;
	
	public List<StudentBaseInfoBO> analyzeStuBaseData(StudentBaseInfoImportVO importInfo) throws Exception {
		this.importInfo = importInfo;
		FileInputStream fis = new FileInputStream(importInfo.getUpload());
		POIFSFileSystem fs = new POIFSFileSystem(fis);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		List<StudentBaseInfoBO> boList = new ArrayList<StudentBaseInfoBO>();
		for (int sheetCount = 0; sheetCount < wb.getNumberOfSheets(); sheetCount++) {
			HSSFSheet sheet = wb.getSheetAt(sheetCount);
			int rows = sheet.getPhysicalNumberOfRows();
			// 第一行为#字段名
			// 第二行为字段编号
			// 第三行为字段标题，因此内容读取从startRow+3
			for (int rowCount = 3; rowCount < rows; rowCount++) {
				try {
					StudentBaseInfoBO bo = getStuBaseInfoByRow(sheet, rowCount);
					if(allowInsert) {
						boList.add(bo);
					} else {
						notAllowRows += (rowCount + 1) + ",";
						notAllowRowsCount++;
					}
				} catch(Exception e) {
					throw new MisException("<br>第" + (rowCount + 1) + "行:" + e.getMessage());
				}
			}
		}
		returnInfo = "excel总共" + (notAllowRowsCount + boList.size()) + "条数据,程序导入" + boList.size() + "条数据";
		if(notAllowRowsCount == 0) {
			returnInfo = "导入成功" + "<br>" + returnInfo;
		} else {
			returnInfo = "部份数据导入" + "<br>" + returnInfo; 
			returnInfo += "<br>" + "未导入数据有" + notAllowRowsCount + "条";
			returnInfo += "<br>" + "包括" + notAllowRows + "行";
		}
		return boList;
	}

	public String getReturnInfo() {
		return returnInfo;
	}
	
	private StudentBaseInfoBO getStuBaseInfoByRow(HSSFSheet sheet, int rowCount) {
		allowInsert = false;
		bkxl = "";
		sourceRow = sheet.getRow(rowCount);
		int count = sourceRow.getPhysicalNumberOfCells();
		if(count != 42) throw new MisException("数据列数不匹配,实际为"+ count +"列,应该为42列");
		cellnum = -1;
		StudentBaseInfoBO bo = new StudentBaseInfoBO();
		bo.setMsbbh(getCellValue());
		bo.setMsrq(formatDateToyyyyMMdd());
		bo.setJie(Tools.isEmpty(importInfo.getJie()) ? getCellValue() : importInfo.getJie());
		bo.setJj(Tools.isEmpty(importInfo.getJj()) ? getDictKey(DictConstants.JJ) : importInfo.getJj());
		bo.setXm(getCellValue());
		bo.setXb(getDictKey(DictConstants.XB));
		bo.setMz(getDictKey(DictConstants.MZ));
		bo.setSg(getDouble());
		bo.setBkxl(bkxl = getDictKey(DictConstants.BKXL));
		bo.setBdzy(getBdzy());
		bo.setZzmm(getDictKey(DictConstants.ZZMM));
		bo.setCsrq(formatDateToyyyyMMdd());
		bo.setSfzhm(getCellValue());
		bo.setHj(getDictKey(DictConstants.HJ));
		bo.setKslb(getDictKey(DictConstants.KSLB));
		bo.setYklx(getDictKey(DictConstants.YKLX));
		bo.setByz(getDictKey(DictConstants.BYZ));
		bo.setJtxsdz(getCellValue());
		bo.setXslxdh(getCellValue());
		bo.setJzlxdh(getCellValue());
		bo.setByxx(getCellValue());
		bo.setSyd(getCellValue());
		bo.setZsls(getCellValue());
		bo.setZfzr(getUserID());
		bo.setZs(getDictKey(DictConstants.ZS));
		bo.setTj(getDictKey(DictConstants.TJ));
		bo.setLq(getDictKey(DictConstants.LQ));
		bo.setBdk(getDictKey(DictConstants.BDK));
		bo.setXy(getDictKey(DictConstants.XY));
		bo.setBz(getCellValue());
		// 费用
		bo.setYjfrq(formatDateToyyyyMMdd());
		bo.setYjfje(getDouble());
		bo.setYjfskr(getCellValue());
		bo.setJfrq(formatDateToyyyyMMdd());
		bo.setJfje(getDouble());
		bo.setJfskr(getSkrID());
		bo.setJfrq2(formatDateToyyyyMMdd());
		bo.setJfje2(getDouble());
		bo.setJfskr2(getSkrID());
		bo.setJfze(getDouble());
		bo.setYjje(getDouble());
		bo.setCwbz(getCellValue());
		
		String time = Tools.getCurrDefaultDateTime();
		bo.setActive("2");
		bo.setCreater(importInfo.getUserid());
		bo.setCreatetime(time);
		bo.setLastupdater(importInfo.getUserid());
		bo.setLastupdatertime(time);
		return bo;
	}
	
	private String getCellValue() {
		String value = null;
		try {
			HSSFCell cell = sourceRow.getCell(++cellnum);
			if(cell==null||cell.getCellType()==HSSFCell.CELL_TYPE_BLANK)  return null;
			if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					value = Tools.formatDateTime(cell.getDateCellValue(), "yyyy-MM-dd");
				} else {
					value = String.valueOf((long) cell.getNumericCellValue());
				}
			} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
				value = cell.getBooleanCellValue() + "";
			} else {
				value = cell.getRichStringCellValue().getString();
			}
			if(Tools.isNull(value)) return null;
			allowInsert = true;
		} catch (Exception e) {
			throw new MisException("第" + (cellnum + 1) + "列:数据有误");
		}
		return value.trim();
	}
	
	private String getDictKey(String code) {
		String value = getCellValue();
		if(Tools.isNull(value)) return null;
		String key = Dictionary.getInstance().dicKeyByValue(code, value);
		if(Tools.isNull(key)) throw new MisException("第" + (cellnum + 1) + "列:值\"" + value + "\"在字典" + code + "中没有对应项");
		return key;
	}
	
	private String formatDateToyyyyMMdd() {
		String date = getCellValue();
		if(Tools.isNull(date)) return null;
		if(date.length() != 6) throw new MisException("第" + (cellnum + 1) + "列:日期\"" + date + "\"格式不对,应为yyMMdd格式");
		return Tools.formatDateTime(date, "yyMMdd", "yyyy-MM-dd");
	}
	
	private Integer getUserID() {
		String userName = getCellValue();
		if(Tools.isNull(userName)) return null;
		Integer id = getUserIDHolder(userName);
		if(id != null) {
			return id;
		}
		throw new MisException("第" + (cellnum + 1) + "列:人员\"" + userName + "\"在系统中没有对应账号");
	}
	
	private String getSkrID() {
		String userName = getCellValue();
		if(Tools.isNull(userName)) return null;
		Integer id = getUserIDHolder(userName);
		if(id != null) {
			return id.toString();
		}
		return userName;
	}
	
	private Integer getUserIDHolder(String userName) {
		if(importInfo.getUserIDNameArray() == null) return null;
		for(int i = 0; i < importInfo.getUserIDNameArray().length; i++) {
			if(importInfo.getUserIDNameArray()[i][1].equals(userName)) {
				return Integer.valueOf(importInfo.getUserIDNameArray()[i][0]);
			}
		}
		return null;
	}
	
	private String getBdzy() {
		String value = "";
		if("1".equals(bkxl)) {
			value = getDictKey(DictConstants.BDZYDZ);
		} else if("2".equals(bkxl)) {
			value = getDictKey(DictConstants.BDZYZZ);
		}
		return value;
	}
	
	private Double getDouble() {
		String value = getCellValue();
		if(Tools.isEmpty(value)) return null;
		Double num = null;
		try {
			num = Double.valueOf(value);
		} catch (Exception e) {
			throw new MisException("第" + (cellnum + 1) + "列:\"" + value + "\"不是浮点数");
		}
		return num;
	}
}
