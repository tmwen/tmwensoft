package com.tangmaowen.mis.xhzy.sms.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangmaowen.mis.common.dao.hibernate.HibernatePageingSupport;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.dao.StudentFeesDao;
import com.tangmaowen.mis.xhzy.sms.dao.hibernate.maps.StudentFeesPO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentFeesBO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-4 上午12:05:25
 *
 */
public class StudentFeesDaoImpl extends HibernateDaoSupport implements StudentFeesDao {

	@Override
	public StudentFeesBO getStudentFees(Integer id) {
		StudentFeesPO po = (StudentFeesPO)getHibernateTemplate().get(StudentFeesPO.class, id);
		if(po == null) return null;
		StudentFeesBO bo = new StudentFeesBO();
		BeanUtils.copyProperties(po, bo);
		return bo;
	}
	
	@Override
	public StudentFeesBO insertStudentFees(StudentFeesBO bo) {
		StudentFeesPO po = new StudentFeesPO();
		BeanUtils.copyProperties(bo, po);
		Integer feeid = (Integer)getHibernateTemplate().save(po);
		return getStudentFees(feeid);
	}
	
	@Override
	public StudentFeesBO updateStudentFees(StudentFeesBO bo) {
		StudentFeesPO po = (StudentFeesPO)getHibernateTemplate().get(StudentFeesPO.class, bo.getFeeid());
		BeanUtils.copyProperties(bo, po);
		getHibernateTemplate().update(po);
		return getStudentFees(po.getFeeid());
	}

	@Override
	public void deleteStudentFees(Integer id) {
		StudentFeesPO po = (StudentFeesPO)getHibernateTemplate().get(StudentFeesPO.class, id);
		getHibernateTemplate().delete(po);
	}
	
	@Override
	public Map<String, Object> getStudentFeesList(PageingBO bo) {
		return HibernatePageingSupport.getPageing(bo, StudentFeesPO.class, StudentFeesBO.class, this.getSession());
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkStuNotFees(Integer id) {
		List<StudentFeesPO> fees = getHibernateTemplate().find("from StudentFeesPO a where a.stuid=?", id);
		if(Tools.isEmpty(fees)) {
			return true;
		}
		return false;
	}
}
