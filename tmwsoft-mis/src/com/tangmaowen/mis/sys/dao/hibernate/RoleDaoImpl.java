package com.tangmaowen.mis.sys.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangmaowen.mis.sys.dao.RoleDao;
import com.tangmaowen.mis.sys.dao.hibernate.maps.RolePO;
import com.tangmaowen.mis.sys.domain.RoleBO;

/**
 * @author 唐懋文
 * @since 2009-11-16 上午10:49:50
 *
 */
public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleBO> getAllRole() {
		List<RolePO> roles = getHibernateTemplate().find("from RolePO");
		if(roles == null || roles.size() < 1) {
			return null;
		}
		List<RoleBO> bolist = new ArrayList<RoleBO>();
		for (int i = 0; i < roles.size(); i++) {
			RoleBO bo = new RoleBO();
			BeanUtils.copyProperties(roles.get(i), bo);
			bolist.add(bo);
		}
		return bolist;
	}

	@Override
	public RoleBO deleteRole(Integer id) {
		RolePO po = (RolePO)getHibernateTemplate().get(RolePO.class, id);
		RoleBO bo = new RoleBO();
		BeanUtils.copyProperties(bo, po);
		getHibernateTemplate().delete(po);
		return bo;
	}

	@Override
	public RoleBO getRole(Integer id) {
		RolePO po = (RolePO)getHibernateTemplate().get(RolePO.class, id);
		RoleBO bo = new RoleBO();
		BeanUtils.copyProperties(po, bo);
		return bo;
	}

	@Override
	public RoleBO insertRole(RoleBO bo) {
		RolePO po = new RolePO();
		BeanUtils.copyProperties(bo, po);
		Integer id = (Integer)getHibernateTemplate().save(po);
		return getRole(id);
	}

	@Override
	public RoleBO updateRole(RoleBO bo) {
		RolePO po = (RolePO)getHibernateTemplate().get(RolePO.class, bo.getRoleid());
		BeanUtils.copyProperties(bo, po);
		getHibernateTemplate().update(po);
		return getRole(bo.getRoleid());
	}

}
