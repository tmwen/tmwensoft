package com.tangmaowen.mis.sys.dao.hibernate.maps;

/**
 * @author 唐懋文
 * @since 2009-11-13 下午04:39:08
 *
 */
public class UserRoleId implements java.io.Serializable {

	private UserPO users;

	private RolePO role;

	public UserRoleId() {
	}

	public UserRoleId(UserPO users, RolePO role) {
		this.users = users;
		this.role = role;
	}
	
	public UserPO getUsers() {
		return this.users;
	}

	public void setUsers(UserPO users) {
		this.users = users;
	}

	public RolePO getRole() {
		return this.role;
	}

	public void setRole(RolePO role) {
		this.role = role;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleId))
			return false;
		UserRoleId castOther = (UserRoleId) other;

		return ((this.getUsers() == castOther.getUsers()) || (this.getUsers() != null
				&& castOther.getUsers() != null && this.getUsers().equals(
				castOther.getUsers())))
				&& ((this.getRole() == castOther.getRole()) || (this.getRole() != null
						&& castOther.getRole() != null && this.getRole()
						.equals(castOther.getRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsers() == null ? 0 : this.getUsers().hashCode());
		result = 37 * result
				+ (getRole() == null ? 0 : this.getRole().hashCode());
		return result;
	}

}