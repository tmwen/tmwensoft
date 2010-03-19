package com.tangmaowen.mis.sys.dao.hibernate.maps;

/**
 * @author 唐懋文
 * @since 2009-11-13 下午04:35:31
 *
 */
public class RoleAuthorityPO implements java.io.Serializable {
	
	private RoleAuthorityId id;

	public RoleAuthorityPO() {
	}

	public RoleAuthorityPO(RoleAuthorityId id) {
		this.id = id;
	}

	public RoleAuthorityId getId() {
		return this.id;
	}

	public void setId(RoleAuthorityId id) {
		this.id = id;
	}

}