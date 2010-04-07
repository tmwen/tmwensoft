package com.tangmaowen.mis.xhzy.sms.dao;

import java.util.List;
import java.util.Map;

import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;

/**
 * @author 唐懋文
 * @since 2009-10-20 上午01:32:17
 *
 */
public interface StudentBaseInfoDao {

	public StudentBaseInfoBO getStudentBaseInfo(Integer id);

	public void insertStudentBaseInfo(StudentBaseInfoBO bo);

	public void updateStudentBaseInfo(StudentBaseInfoBO bo);
	
	public void deleteStudentBaseInfo(Integer id);
	
	public Map<String, Object> getStudentBaseInfoList(PageingBO bo);
	
	/**
	 * 统计某列某值出现次数
	 * @param notid 如果不为空将排除该id
	 * @param column 列名
	 * @param value 值
	 * @return value出现次数
	 */
	public int getValueCountByStuBaseInfo(Integer notid, String column, Object value);
	
	/**
	 * 将excel中的学生信息导入基本表
	 * @param list
	 */
	public void insertStudentInfoByExcel(List<StudentBaseInfoBO> list);

}
