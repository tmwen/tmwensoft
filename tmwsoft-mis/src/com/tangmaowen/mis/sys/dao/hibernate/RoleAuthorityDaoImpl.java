package com.tangmaowen.mis.sys.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangmaowen.mis.sys.dao.RoleAuthorityDao;
import com.tangmaowen.mis.sys.dao.hibernate.maps.AuthorityPO;
import com.tangmaowen.mis.sys.dao.hibernate.maps.RoleAuthorityId;
import com.tangmaowen.mis.sys.dao.hibernate.maps.RoleAuthorityPO;
import com.tangmaowen.mis.sys.dao.hibernate.maps.RolePO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-23 下午04:07:47
 *
 */
public class RoleAuthorityDaoImpl extends HibernateDaoSupport implements RoleAuthorityDao {

	@SuppressWarnings("unchecked")
	@Override
	public String getRoleAuth(Integer id) {
		List<RoleAuthorityPO> poList = getHibernateTemplate().find("from RoleAuthorityPO a where a.id.role.roleid=?", id);
		if(Tools.isEmpty(poList)) return null;
		StringBuilder roleAuthStr = new StringBuilder();
		roleAuthStr.append(",");
		for (int i = 0; i < poList.size(); i++) {
			roleAuthStr.append(poList.get(i).getId().getAuthority().getAuthid() + ",");
		}
		return roleAuthStr.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateRoleAuth(Integer roleid, String authids) {
		if(Tools.isEmpty(roleid)) return;
		String[] authidArray = authids.split(",");
		List<RoleAuthorityPO> newRoleAuthList = null;
		List<RoleAuthorityPO> oldRoleauthList = getHibernateTemplate().find("from RoleAuthorityPO a where a.id.role.roleid=?", roleid);
		if(!Tools.isEmpty(authidArray)) {
			newRoleAuthList = new ArrayList<RoleAuthorityPO>();
			RolePO role = (RolePO)getHibernateTemplate().get(RolePO.class, roleid);
			for(int i = 0; i < authidArray.length; i++) {
				if(Tools.isEmpty(authidArray[i])) continue;
				boolean exist = false;
				for(int m = 0; !Tools.isEmpty(oldRoleauthList) && m < oldRoleauthList.size(); m++) {
					if(authidArray[i].equals(oldRoleauthList.get(m).getId().getAuthority().getAuthid())) {
						oldRoleauthList.remove(m);
						exist = true;
						break;
					}
				}
				if(!exist) {
					RoleAuthorityId id = new RoleAuthorityId();
					AuthorityPO auth = (AuthorityPO)getHibernateTemplate().get(AuthorityPO.class, authidArray[i]);
					id.setRole(role);
					id.setAuthority(auth);
					RoleAuthorityPO roleAuth = new RoleAuthorityPO();
					roleAuth.setId(id);
					newRoleAuthList.add(roleAuth);
				}
			}
		}
		if(!Tools.isEmpty(oldRoleauthList)) getHibernateTemplate().deleteAll(oldRoleauthList);
		if(!Tools.isEmpty(newRoleAuthList)) getHibernateTemplate().saveOrUpdateAll(newRoleAuthList);
	}
}
