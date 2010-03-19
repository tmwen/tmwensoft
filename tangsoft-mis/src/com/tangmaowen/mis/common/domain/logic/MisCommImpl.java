package com.tangmaowen.mis.common.domain.logic;

import java.util.List;

import com.tangmaowen.mis.common.Constants;
import com.tangmaowen.mis.sys.dao.AuthorityDao;
import com.tangmaowen.mis.sys.dao.DictionaryDao;
import com.tangmaowen.mis.sys.dao.LogDao;
import com.tangmaowen.mis.sys.dao.UsersDao;
import com.tangmaowen.mis.sys.domain.AuthorityBO;
import com.tangmaowen.mis.sys.domain.DictionaryBO;
import com.tangmaowen.mis.sys.domain.LogBO;
import com.tangmaowen.mis.sys.domain.UserBO;
import com.tangmaowen.utils.Tools;

/**
 * @author 唐懋文
 * @since 2009-10-25 上午12:36:36
 *
 */
public class MisCommImpl implements MisCommFacade {

	private UsersDao usersDao;
	private AuthorityDao authorityDao;
	private LogDao logDao;
	private DictionaryDao dictionaryDao;

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}
	
	//-------------------login------------------------

	@Override
	public UserBO login(String id, String password) {
		return usersDao.login(id, password);
	}

	@Override
	public List<AuthorityBO> getUserAuthority(Integer id) {
		return usersDao.getUserAuthority(id);
	}

	@Override
	public String getUserAuthorityByStr(Integer id) {
		StringBuilder sb = new StringBuilder();
		List<AuthorityBO> authoritys = usersDao.getUserAuthority(id);
		if(authoritys == null) return "`";
		for(AuthorityBO authority : authoritys) {
			sb.append("`" + authority.getAuthid());
		}
		sb.append("`");
		return sb.toString();
	}

	@Override
	public void updateUserLoginInfo(Integer id) {
		UserBO bo = usersDao.getUserInfo(id);
		bo.setLastvisittime(Tools.getCurrDefaultDateTime());
		bo.setVisitcount(bo.getVisitcount() + 1);
		usersDao.updateUserInfo(bo);
	}
	
	@Override
	public void insertLog(LogBO bo) {
		logDao.insertLog(bo);
	}
	
	@Override
	public List<DictionaryBO> getDictionaryList() {
		return dictionaryDao.getDictionaryList();
	}

	@Override
	public List<AuthorityBO> getAuth(String authtype) {
		return authorityDao.getAuth(authtype);
	}
	//---------------users---------------------------
	@Override
	public String[][] getUserIDNameArray(String system, Integer id) {
		List<UserBO> boList = usersDao.getUserIDNameList(id);
		if(Tools.isEmpty(boList)) return null;
		String[][] userArray = new String[boList.size()][2];
		for(int i = 0; i < boList.size(); i++) {
			if(boList.get(i).getUserid() != Constants.ADMIN) {
				userArray[i][0] = boList.get(i).getUserid()+"";
				userArray[i][1] = boList.get(i).getUsername();
			}
		}
		return userArray;
	}
	
	@Override
	public String getAliveUserIDNameJsArray(String system, Integer id) {
		List<UserBO> boList = usersDao.getUserIDNameList(id);
		if(Tools.isEmpty(boList)) return "[]";
		StringBuilder sb = new StringBuilder();
		//[["1001", "张三"], ["1002", "王五"]]
		sb.append("[");
		for(int i = 0; i < boList.size(); i++) {
			if(!boList.get(i).getActive().equals(Constants.USERUSINGACTION)) continue;
			sb.append("[");
			sb.append("\""+ boList.get(i).getUserid() +"\",");
			sb.append("\""+ boList.get(i).getUsername() +"\"");
			sb.append("],");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
	
	@Override
	public String getUserIDNameJsArray(String system, Integer id) {
		String[][] userArray = getUserIDNameArray(system, id);
		if(Tools.isEmpty(userArray)) return "[]";
		StringBuilder sb = new StringBuilder();
		//[["1001", "张三"], ["1002", "王五"]]
		sb.append("[");
		for(int i = 0; i < userArray.length; i++) {
			sb.append("[");
			sb.append("\""+userArray[i][0]+"\",");
			sb.append("\""+userArray[i][1]+"\"");
			sb.append("],");
		}
		sb.append("[\"" + Constants.ADMIN + "\",\"系统管理员\"]");
		sb.append("]");
		return sb.toString();
	}
}
