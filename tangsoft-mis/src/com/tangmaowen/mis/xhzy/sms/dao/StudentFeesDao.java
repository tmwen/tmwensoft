package com.tangmaowen.mis.xhzy.sms.dao;

import java.util.Map;

import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentFeesBO;

/**
 * @author 唐懋文
 * @since 2009-11-4 上午12:04:44
 *
 */
public interface StudentFeesDao {

	public StudentFeesBO getStudentFees(Integer id);
	
	public StudentFeesBO insertStudentFees(StudentFeesBO bo);

	public StudentFeesBO updateStudentFees(StudentFeesBO bo);
	
	public void deleteStudentFees(Integer id);
	
	public Map<String, Object> getStudentFeesList(PageingBO bo);
	
	/**
	 * @param id stuid
	 * @return true: 无缴费信息,false: 有缴费信息
	 */
	public boolean checkStuNotFees(Integer id);
}
