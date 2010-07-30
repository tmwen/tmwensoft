package com.tangmaowen.mis.xhzy.sms.domain.logic;

import java.util.List;
import java.util.Map;

import com.tangmaowen.mis.common.MisException;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.dao.StudentBaseInfoDao;
import com.tangmaowen.mis.xhzy.sms.dao.StudentFeesDao;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentFeesBO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午12:36:36
 *
 */
public class MisXhzySmsImpl implements MisXhzySmsFacade {

	private StudentBaseInfoDao studentBaseInfoDao;
	private StudentFeesDao studentFeesDao;

	public void setStudentBaseInfoDao(StudentBaseInfoDao studentBaseInfoDao) {
		this.studentBaseInfoDao = studentBaseInfoDao;
	}

	public void setStudentFeesDao(StudentFeesDao studentFeesDao) {
		this.studentFeesDao = studentFeesDao;
	}

	//---------------students_baseinfo---------------------------
	@Override
	public StudentBaseInfoBO getStudentBaseInfo(Integer id) {
		return studentBaseInfoDao.getStudentBaseInfo(id);
	}

	@Override
	public String insertStudentBaseInfo(StudentBaseInfoBO bo) {
		return checkStuBaseInfoUnique(bo);
	}

	@Override
	public String updateStudentBaseInfo(StudentBaseInfoBO bo) {
		return checkStuBaseInfoUnique(bo);
	}
	
	@Override
	public String deleteStudentBaseInfo(Integer id) {
		if(studentFeesDao.checkStuNotFees(id)) {
			StudentBaseInfoBO bo = studentBaseInfoDao.getStudentBaseInfo(id);
			if(bo.getJfze() == null || bo.getJfze() <= 0) {
				studentBaseInfoDao.deleteStudentBaseInfo(id);
				return "";
			}
		}
		return "用户有缴费记录，不能删除";
	}
	
	private String checkStuBaseInfoUnique(StudentBaseInfoBO bo) {
		String result = "";
		if(studentBaseInfoDao.getValueCountByStuBaseInfo(bo.getStuid(), "msbbh", bo.getMsbbh()) != 0) {
			result = "在学生信息中已存在面试表编号:" + bo.getMsbbh();
		} else if(!Tools.isEmpty(bo.getSfzhm()) && studentBaseInfoDao.getValueCountByStuBaseInfo(bo.getStuid(), "sfzhm", bo.getSfzhm()) != 0) {
			result = "在学生信息中已存在身份证号码:" + bo.getSfzhm();
		} else {
			if(bo.getStuid() == null) {
				studentBaseInfoDao.insertStudentBaseInfo(bo);
			} else {
				studentBaseInfoDao.updateStudentBaseInfo(bo);
			}
		}
		return result;
	}

	@Override
	public Map<String, Object> getStudentBaseInfoList(PageingBO bo) {
		return studentBaseInfoDao.getStudentBaseInfoList(bo);
	}

	@Override
	public void insertStudentInfoByExcel(List<StudentBaseInfoBO> list) {
		for(int i = 0; i < list.size(); i++) {
			String insertInfo = "";
			try {
				insertInfo = insertStudentBaseInfo(list.get(i));
				if(!insertInfo.equals("")) throw new Exception(insertInfo);
			} catch(Exception e) {
				// excel表头占3行，数据从第4行开始
				String info = "<br>第" + (i + 4) + "行:面试表编号" + list.get(i).getMsbbh()+ ",姓名" + list.get(i).getXm();
				if(Tools.isNull(insertInfo.equals(""))) {
					info += "<br>提示:" + "有必填项为空,或者插入数据失败";
				} 
				info += "<br>错误信息:" + e.getMessage() + "";
				throw new MisException(info);
			}
		}
	}
	
	//---------------fees---------------------------

	@Override
	public StudentFeesBO getStudentFees(Integer id) {
		return studentFeesDao.getStudentFees(id);
	}

	@Override
	public StudentFeesBO insertStudentFees(StudentFeesBO bo) {
		updateStudentBaseInfoFees(bo);
		StudentFeesBO sfbo = studentFeesDao.insertStudentFees(bo);
		return sfbo;
	}
	
	@Override
	public StudentFeesBO updateStudentFees(StudentFeesBO bo) {
		updateStudentBaseInfoFees(bo);
		StudentFeesBO sfbo = studentFeesDao.updateStudentFees(bo);
		return sfbo;
	}

	@Override
	public void deleteStudentFees(StudentFeesBO bo) {
		bo.setJe(0.0);
		updateStudentBaseInfoFees(bo);
		studentFeesDao.deleteStudentFees(bo.getFeeid());
	}
	
	private void updateStudentBaseInfoFees(StudentFeesBO bo) {
		StudentBaseInfoBO sbbo = studentBaseInfoDao.getStudentBaseInfo(bo.getStuid());
		StudentFeesBO sfbo = null;
		if(bo.getFeeid() != null) sfbo = studentFeesDao.getStudentFees(bo.getFeeid());
		Double oldJe = sfbo == null ? 0.0 : sfbo.getJe();
		Double newJe = bo.getJe();
		String oldJflx = sfbo == null ? bo.getJflx() : sfbo.getJflx();
		String newJflx = bo.getJflx();
		Double tempNewJe = 0.0;
		Double tempOldJe = 0.0;
		if(newJflx.equals("1") || !oldJflx.equals(newJflx)) {
			// 预交费
			tempNewJe = newJe;
			tempOldJe = oldJe;
			if(!oldJflx.equals(newJflx)) {
				tempNewJe = 0.0;
				if(newJflx.equals("1")) tempOldJe = - tempOldJe;
			}
			if(sbbo.getYjfje() == null) sbbo.setYjfje(0.0);
			Double newYjfje = sbbo.getYjfje() + tempNewJe - tempOldJe;
			sbbo.setYjfje(newYjfje == 0.0 ? null : newYjfje);
			sbbo.setYjfrq(newYjfje == 0.0 ? null : bo.getJfrq());
			sbbo.setYjfskr(newYjfje == 0.0 ? null : bo.getSkr());
		}
		if(!newJflx.equals("1") || !oldJflx.equals(newJflx)) {
			// 缴费
			tempNewJe = newJe;
			tempOldJe = oldJe;
			if(!oldJflx.equals(newJflx)) {
				tempNewJe = 0.0;
				if(!newJflx.equals("1")) tempOldJe = - tempOldJe;
			}
			if(sbbo.getJfje() == null) sbbo.setJfje(0.0);
			Double newJfje = sbbo.getJfje() + tempNewJe - tempOldJe;
			sbbo.setJfje(newJfje == 0.0 ? null : newJfje);
			sbbo.setJfrq(newJfje == 0.0 ? null : bo.getJfrq());
			sbbo.setJfskr(newJfje == 0.0 ? null :bo.getSkr());
		}
		if(sbbo.getJfze() == null) sbbo.setJfze(0.0);
		Double newJfze = sbbo.getJfze() + newJe - oldJe;
		sbbo.setJfze(newJfze == 0.0 ? null : newJfze);
		sbbo.setLastupdater(bo.getLastupdater());
		sbbo.setLastupdatertime(bo.getLastupdatertime());
		studentBaseInfoDao.updateStudentBaseInfo(sbbo);
	}

	@Override
	public Map<String, Object> getStudentFeesList(PageingBO bo) {
		return studentFeesDao.getStudentFeesList(bo);
	}
}
