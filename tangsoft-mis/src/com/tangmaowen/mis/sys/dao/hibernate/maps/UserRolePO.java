package com.tangmaowen.mis.sys.dao.hibernate.maps;

/**
 * @author 唐懋文
 * @since 2009-11-13 下午04:40:02
 *
 */
public class UserRolePO implements java.io.Serializable {

	private UserRoleId id;

	public UserRolePO() {
	}

	public UserRolePO(UserRoleId id) {
		this.id = id;
	}

	public UserRoleId getId() {
		return this.id;
	}

	public void setId(UserRoleId id) {
		this.id = id;
	}

}