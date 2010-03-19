package com.tangmaowen.mis.xhzy.sms.domain.logic;

import java.util.List;
import java.util.Map;

import com.tangmaowen.mis.common.domain.logic.MisFacade;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentFeesBO;

/**
 * @author 唐懋文
 * @since 2009-10-20 上午01:41:41
 *
 */
public interface MisXhzySmsFacade extends MisFacade {

	//---------------students_baseinfo---------------------------
	public StudentBaseInfoBO getStudentBaseInfo(Integer id);

	public String insertStudentBaseInfo(StudentBaseInfoBO bo);

	public String updateStudentBaseInfo(StudentBaseInfoBO bo);
	
	public String deleteStudentBaseInfo(Integer id);

	public Map<String, Object> getStudentBaseInfoList(PageingBO bo);
	
	public void insertStudentInfoByExcel(List<StudentBaseInfoBO> list);

	//-------------------fees------------------------
	public StudentFeesBO getStudentFees(Integer id);
	
	public StudentFeesBO insertStudentFees(StudentFeesBO bo);

	public StudentFeesBO updateStudentFees(StudentFeesBO bo);
	
	public void deleteStudentFees(StudentFeesBO bo);
	
	public Map<String, Object> getStudentFeesList(PageingBO bo);
	
}
