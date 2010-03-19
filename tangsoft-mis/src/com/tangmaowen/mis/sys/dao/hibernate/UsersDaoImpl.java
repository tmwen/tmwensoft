package com.tangmaowen.mis.sys.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.common.dao.hibernate.HibernatePageingSupport;
import com.tangmaowen.mis.sys.dao.UsersDao;
import com.tangmaowen.mis.sys.dao.hibernate.maps.AuthorityPO;
import com.tangmaowen.mis.sys.dao.hibernate.maps.RoleAuthorityPO;
import com.tangmaowen.mis.sys.dao.hibernate.maps.UserPO;
import com.tangmaowen.mis.sys.dao.hibernate.maps.UserRolePO;
import com.tangmaowen.mis.sys.domain.AuthorityBO;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.sys.domain.UserBO;
import com.tangmaowen.utils.MD5;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-25 下午12:13:05
 *
 */
public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {

	@Override
	public UserBO getUserInfo(Integer id) {
		UserPO po = (UserPO)getHibernateTemplate().get(UserPO.class, id);
		UserBO bo = new UserBO();
		BeanUtils.copyProperties(po, bo);
		return bo;
	}

	@Override
	public void insertUserInfo(UserBO bo) {
		UserPO po = new UserPO();
		BeanUtils.copyProperties(bo, po);
		// 新建用户缺省密码为000000
		po.setPassword(MD5.crypt(Constants.USERINITPASSWORD));
		getHibernateTemplate().save(po);
	}

	@Override
	public void updateUserInfo(UserBO bo) {
		UserPO po = (UserPO)getHibernateTemplate().get(UserPO.class, bo.getUserid());
		BeanUtils.copyProperties(bo, po);
		getHibernateTemplate().update(po);
	}

	@Override
	public Map<String, Object> getUsersList(PageingBO bo) {
		return HibernatePageingSupport.getPageing(bo, UserPO.class, UserBO.class, this.getSession());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBO> getUserIDNameList(Integer id) {
		List<UserPO> users = getHibernateTemplate().find("from UserPO a where a.userid!=" + Constants.ADMIN);
		if(Tools.isEmpty(users)) {
			return null;
		}
		List<UserBO> tempList = new ArrayList<UserBO>();
		List<UserBO> boList = new ArrayList<UserBO>();
		for (int i = 0; i < users.size(); i++) {
			UserBO bo = new UserBO();
			BeanUtils.copyProperties(users.get(i), bo);
			if(bo.getUserid().equals(id)) {
				boList.add(bo);
				continue;
			}
			tempList.add(bo);
		}
		boList.addAll(tempList);
		return boList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserBO login(String loginid, String password) {
		Object[] params = new Object[] {Integer.valueOf(loginid), password};
		List<UserPO> users = getHibernateTemplate().find("from UserPO a where a.userid=? and a.password=?", params);
		if(users == null || users.size() != 1) {
			return null;
		}
		UserBO bo = new UserBO();
		BeanUtils.copyProperties(users.get(0), bo);
		return bo;
	}

	@Override
	public List<AuthorityBO> getUserAuthority(Integer id) {
		UserPO user = (UserPO)getHibernateTemplate().get(UserPO.class, id);
		if(user == null) return null;
		Iterator<UserRolePO> userRoleIter = user.getUserRoles().iterator();
		if(!userRoleIter.hasNext()) return null;
		List<AuthorityBO> boList = new ArrayList<AuthorityBO>();
		do {
			UserRolePO userRole = userRoleIter.next();
			Set<RoleAuthorityPO> roleAuthSet = userRole.getId().getRole().getRoleAuthorities();
			Iterator<RoleAuthorityPO> roleAuthIter = roleAuthSet.iterator();
			while(roleAuthIter.hasNext()) {
				RoleAuthorityPO roleAuth = roleAuthIter.next();
				AuthorityBO bo = new AuthorityBO();
				AuthorityPO po = roleAuth.getId().getAuthority();
				BeanUtils.copyProperties(po, bo);
				boList.add(bo);
			}
		} while(userRoleIter.hasNext());
		return boList;
	}

	@Override
	public boolean verifyPassword(Integer id, String password) {
		UserPO po = (UserPO)getHibernateTemplate().get(UserPO.class, id);
		if(po != null && po.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void passwordAlter(Integer id, String newpass) {
		UserPO po = (UserPO)getHibernateTemplate().get(UserPO.class, id);
		po.setPassword(newpass);
		getHibernateTemplate().save(po);
	}

}
