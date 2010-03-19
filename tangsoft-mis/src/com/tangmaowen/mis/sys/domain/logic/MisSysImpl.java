package com.tangmaowen.mis.sys.domain.logic;

import java.util.List;
import java.util.Map;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.dao.AuthorityDao;
import com.tangmaowen.mis.sys.dao.DictionaryDao;
import com.tangmaowen.mis.sys.dao.LogDao;
import com.tangmaowen.mis.sys.dao.RoleAuthorityDao;
import com.tangmaowen.mis.sys.dao.RoleDao;
import com.tangmaowen.mis.sys.dao.UserRoleDao;
import com.tangmaowen.mis.sys.dao.UsersDao;
import com.tangmaowen.mis.sys.domain.AuthorityBO;
import com.tangmaowen.mis.sys.domain.DictionaryBO;
import com.tangmaowen.mis.sys.domain.LogBO;
import com.tangmaowen.mis.sys.domain.PageingBO;
import com.tangmaowen.mis.sys.domain.RoleBO;
import com.tangmaowen.mis.sys.domain.UserBO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午12:36:36
 *
 */
public class MisSysImpl implements MisSysFacade {

	private UsersDao usersDao;
	private DictionaryDao dictionaryDao;
	private LogDao logDao;
	private RoleDao roleDao;
	private AuthorityDao authorityDao;
	private RoleAuthorityDao roleAuthorityDao;
	private UserRoleDao userRoleDao;

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public void setRoleAuthorityDao(RoleAuthorityDao roleAuthorityDao) {
		this.roleAuthorityDao = roleAuthorityDao;
	}

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	
	//---------------users---------------------------
	@Override
	public UserBO getUserInfo(Integer id) {
		return usersDao.getUserInfo(id);
	}

	@Override
	public void insertUserInfo(UserBO bo) {
		usersDao.insertUserInfo(bo);
	}

	@Override
	public void updateUserInfo(UserBO bo) {
		usersDao.updateUserInfo(bo);
	}

	@Override
	public Map<String, Object> getUsersList(PageingBO bo) {
		return usersDao.getUsersList(bo);
	}

	@Override
	public String changeUserActive(Integer id) {
		UserBO bo = usersDao.getUserInfo(id);
		bo.setActive(bo.getActive().equals(Constants.USERUSINGACTION) ? Constants.USERSTOPACTION : Constants.USERUSINGACTION);
		usersDao.updateUserInfo(bo);
		return bo.getActive();
	}
	
	@Override
	public List<RoleBO> getUserRole(Integer id) {
		List<RoleBO> boList = roleDao.getAllRole();
		String userRoleStr = userRoleDao.getUserRole(id);
		if(Tools.isEmpty(boList)) return null;
		if(Tools.isEmpty(userRoleStr)) return boList;
		for(int i = 0; i < boList.size(); i++) {
			String roleid = boList.get(i).getRoleid().toString();
			if(userRoleStr.indexOf(roleid) != -1) {
				boList.get(i).setCheck(true);
			}
		}
		return boList;
	}

	@Override
	public void updateUserRole(Integer userid, String roleids) {
		userRoleDao.updateUserRole(userid, roleids);
	}
	
	//---------------user---------------------------

	public boolean verifyPassword(Integer id, String password) {
		return usersDao.verifyPassword(id, password);
	}
	
	@Override
	public void passwordAlter(Integer id, String newpass) {
		usersDao.passwordAlter(id, newpass);
	}
	
	//---------------log---------------------------
	@Override
	public LogBO getLogInfo(Integer id) {
		return logDao.getLogInfo(id);
	}

	@Override
	public Map<String, Object> getLogList(PageingBO bo) {
		return logDao.getLogList(bo);
	}

	//---------------dics---------------------------
	@Override
	public List<DictionaryBO> getDictionaryList() {
		return dictionaryDao.getDictionaryList();
	}
	
	@Override
	public List<DictionaryBO> getDicRootCodeList() {
		return dictionaryDao.getDicRootCodeList();
	}

	@Override
	public List<DictionaryBO> getEntryList(String parentcode) {
		return dictionaryDao.getEntryList(parentcode);
	}

	@Override
	public DictionaryBO insertEntry(DictionaryBO bo) {
		return dictionaryDao.insertEntry(bo);
	}
	@Override
	public DictionaryBO updateEntry(DictionaryBO bo) {
		return dictionaryDao.updateEntry(bo);
	}

	@Override
	public DictionaryBO deleteEntry(Integer id) {
		return dictionaryDao.deleteEntry(id);
	}

	//---------------authority---------------------------
	@Override
	public List<AuthorityBO> getAllAuth() {
		return authorityDao.getAllAuth();
	}

	@Override
	public List<AuthorityBO> getRoleAuth(Integer id) {
		List<AuthorityBO> boList = authorityDao.getAllAuth();
		String roleAuthStr = roleAuthorityDao.getRoleAuth(id);
		if(Tools.isEmpty(boList)) return null;
		if(Tools.isEmpty(roleAuthStr)) return boList;
		for(int i = 0; i < boList.size(); i++) {
			String authid = boList.get(i).getAuthid();
			if(roleAuthStr.indexOf(authid) != -1) {
				boList.get(i).setCheck(true);
			}
		}
		return boList;
	}
	
	@Override
	public void updateRoleAuth(Integer roleid, String authids) {
		roleAuthorityDao.updateRoleAuth(roleid, authids);
	}
	
	//---------------role---------------------------
	@Override
	public List<RoleBO> getRoleList() {
		return roleDao.getAllRole();
	}

	@Override
	public RoleBO getRole(Integer id) {
		return roleDao.getRole(id);
	}

	@Override
	public RoleBO insertRole(RoleBO bo) {
		return roleDao.insertRole(bo);
	}

	@Override
	public RoleBO updateRole(RoleBO bo) {
		return roleDao.updateRole(bo);
	}

	@Override
	public RoleBO deleteRole(Integer id) {
		String roleAuthority = roleAuthorityDao.getRoleAuth(id);
		if(!Tools.isEmpty(roleAuthority)) return null;
		return roleDao.deleteRole(id);
	}
}
