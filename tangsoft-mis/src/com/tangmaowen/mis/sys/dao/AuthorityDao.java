package com.tangmaowen.mis.sys.dao;

import java.util.List;

import com.tangmaowen.mis.sys.domain.AuthorityBO;

/**
 * @author 唐懋文
 * @since 2009-11-20 下午03:10:03
 *
 */
public interface AuthorityDao {
	
	public List<AuthorityBO> getAllAuth();
	
	public List<AuthorityBO> getAuth(String authtype);
}
