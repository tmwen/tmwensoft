package com.tangmaowen.mis.xhzy.sms.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangmaowen.mis.common.dao.hibernate.HibernatePageingSupport;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.xhzy.sms.dao.StudentBaseInfoDao;
import com.tangmaowen.mis.xhzy.sms.dao.hibernate.maps.StudentBaseInfoPO;
import com.tangmaowen.mis.xhzy.sms.domain.StudentBaseInfoBO;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午12:41:15
 *
 */
public class StudentBaseInfoDaoImpl extends HibernateDaoSupport implements StudentBaseInfoDao {
	
	@Override
	public StudentBaseInfoBO getStudentBaseInfo(Integer id) {
		StudentBaseInfoPO po = (StudentBaseInfoPO)getHibernateTemplate().get(StudentBaseInfoPO.class, id);
		StudentBaseInfoBO bo = new StudentBaseInfoBO();
		BeanUtils.copyProperties(po, bo);
		return bo;
	}

	@Override
	public void insertStudentBaseInfo(StudentBaseInfoBO bo) {
		StudentBaseInfoPO po = new StudentBaseInfoPO();
		BeanUtils.copyProperties(bo, po);
		getHibernateTemplate().save(po);
	}

	@Override
	public void updateStudentBaseInfo(StudentBaseInfoBO bo) {
		StudentBaseInfoPO po = (StudentBaseInfoPO)getHibernateTemplate().get(StudentBaseInfoPO.class, bo.getStuid());
		BeanUtils.copyProperties(bo, po);
		getHibernateTemplate().update(po);
	}

	@Override
	public void deleteStudentBaseInfo(Integer id) {
		StudentBaseInfoPO po = (StudentBaseInfoPO)getHibernateTemplate().get(StudentBaseInfoPO.class, id);
		getHibernateTemplate().delete(po);
	}

	@Override
	public Map<String, Object> getStudentBaseInfoList(PageingBO bo) {
		return HibernatePageingSupport.getPageing(bo, StudentBaseInfoPO.class, StudentBaseInfoBO.class, this.getSession());
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getValueCountByStuBaseInfo(Integer notid, String column, Object value) {
		List<Object> obj = null;
		if(notid == null) {
			obj = getHibernateTemplate().find("from StudentBaseInfoPO a where a." + column + "=?", value);
		} else {
			Object[] params = new Object[] {notid, value};
			obj = getHibernateTemplate().find("from StudentBaseInfoPO a where a.stuid!=? and a." + column + "=?", params);
		}
		if(obj == null) {
			return 0;
		}
		return obj.size();
	}

	@Override
	public void insertStudentInfoByExcel(List<StudentBaseInfoBO> list) {
		List<StudentBaseInfoPO> poList = new ArrayList<StudentBaseInfoPO>();
		for(int i = 0; i < list.size(); i++) {
			StudentBaseInfoBO bo = list.get(i);
			StudentBaseInfoPO po = new StudentBaseInfoPO();
			BeanUtils.copyProperties(bo, po);
			poList.add(po);
			getHibernateTemplate().saveOrUpdateAll(poList);
		}
	}

}
