package com.tangmaowen.mis.sys.dao.hibernate;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangmaowen.mis.common.dao.hibernate.HibernatePageingSupport;
import com.tangmaowen.mis.sys.dao.LogDao;
import com.tangmaowen.mis.sys.dao.hibernate.maps.LogPO;
import com.tangmaowen.mis.sys.domain.LogBO;
import com.tangmaowen.mis.sys.domain.PageingBO;

/**
 * @author 唐懋文
 * @since 2009-11-1 上午11:53:52
 *
 */
public class LogDaoImpl extends HibernateDaoSupport implements LogDao {
	
	@Override
	public void insertLog(LogBO bo) {
		LogPO po = new LogPO();
		BeanUtils.copyProperties(bo, po);
		getHibernateTemplate().save(po);
	}

	@Override
	public LogBO getLogInfo(Integer id) {
		LogPO po = (LogPO)getHibernateTemplate().get(LogPO.class, id);
		LogBO bo = new LogBO();
		BeanUtils.copyProperties(po, bo);
		return bo;
	}

	@Override
	public Map<String, Object> getLogList(PageingBO bo) {
		return HibernatePageingSupport.getPageing(bo, LogPO.class, LogBO.class, this.getSession());
	}

}
