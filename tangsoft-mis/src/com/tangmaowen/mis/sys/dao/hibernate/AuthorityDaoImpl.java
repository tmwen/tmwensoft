/**
 * @author 唐懋文
 * @since 2009-11-24下午03:56:14
 */
package com.tangmaowen.mis.sys.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangmaowen.mis.sys.dao.AuthorityDao;
import com.tangmaowen.mis.sys.dao.hibernate.maps.AuthorityPO;
import com.tangmaowen.mis.sys.domain.AuthorityBO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-24 下午03:56:14
 *
 */
public class AuthorityDaoImpl extends HibernateDaoSupport implements AuthorityDao {

	@Override
	public List<AuthorityBO> getAllAuth() {
		return getAuth(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthorityBO> getAuth(String authtype) {
		List<AuthorityPO> auths = null;
		if(Tools.isNull(authtype)) {
			auths = getHibernateTemplate().find("from AuthorityPO");
		} else {
			auths = getHibernateTemplate().find("from AuthorityPO a where a.authtype=?", authtype);
		}
		if(Tools.isEmpty(auths)) return null;
		List<AuthorityBO> boList = new ArrayList<AuthorityBO>();
		for (int i = 0; i < auths.size(); i++) {
			AuthorityBO bo = new AuthorityBO();
			BeanUtils.copyProperties(auths.get(i), bo);
			boList.add(bo);
		}
		return boList;
	}

}
