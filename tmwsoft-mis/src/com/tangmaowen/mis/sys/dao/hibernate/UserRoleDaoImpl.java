package com.tangmaowen.mis.sys.dao.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangmaowen.mis.sys.dao.UserRoleDao;
import com.tangmaowen.mis.sys.dao.hibernate.maps.RolePO;
import com.tangmaowen.mis.sys.dao.hibernate.maps.UserPO;
import com.tangmaowen.mis.sys.dao.hibernate.maps.UserRoleId;
import com.tangmaowen.mis.sys.dao.hibernate.maps.UserRolePO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-11-23 下午08:37:45
 *
 */
public class UserRoleDaoImpl extends HibernateDaoSupport implements UserRoleDao {
	@SuppressWarnings("unchecked")
	@Override
	public String getUserRole(Integer id) {
		List<UserRolePO> poList = getHibernateTemplate().find("from UserRolePO a where a.id.users.userid=?", id);
		if(Tools.isEmpty(poList)) return null;
		StringBuilder userRoleStr = new StringBuilder();
		userRoleStr.append(",");
		for (int i = 0; i < poList.size(); i++) {
			userRoleStr.append(poList.get(i).getId().getRole().getRoleid() + ",");
		}
		return userRoleStr.toString();
	}

	@Override
	public void updateUserRole(Integer userid, String roleids) {
		if(Tools.isEmpty(userid)) return;
		UserPO user = (UserPO)getHibernateTemplate().get(UserPO.class, userid);
		Set<UserRolePO> oldUserRoleSet = user.getUserRoles();
		Set<UserRolePO> newUserRoleSet = null;
		String[] roleidArray = roleids.split(",");
		if(!Tools.isEmpty(roleidArray)) {
			newUserRoleSet = new HashSet<UserRolePO>();
			for(int i = 0; i < roleidArray.length; i++) {
				if(Tools.isEmpty(roleidArray[i])) continue;
				boolean exist = false;
				Iterator<UserRolePO> oldUserRoleIter = oldUserRoleSet.iterator();
				while(!Tools.isEmpty(oldUserRoleSet) && oldUserRoleIter.hasNext()) {
					UserRolePO po = oldUserRoleIter.next();
					if(roleidArray[i].equals(po.getId().getRole().getRoleid().toString())) {
						oldUserRoleSet.remove(po);
						exist = true;
						break;
					}
				}
				if(!exist) {
					UserRoleId id = new UserRoleId();
					Integer roleid = Integer.valueOf(roleidArray[i]);
					RolePO role = (RolePO)getHibernateTemplate().get(RolePO.class, roleid);
					id.setUsers(user);
					id.setRole(role);
					UserRolePO userRole = new UserRolePO();
					userRole.setId(id);
					newUserRoleSet.add(userRole);
				}
			}
		}
		if(!Tools.isEmpty(oldUserRoleSet)) getHibernateTemplate().deleteAll(oldUserRoleSet);
		if(!Tools.isEmpty(newUserRoleSet)) getHibernateTemplate().saveOrUpdateAll(newUserRoleSet);
	}

}
