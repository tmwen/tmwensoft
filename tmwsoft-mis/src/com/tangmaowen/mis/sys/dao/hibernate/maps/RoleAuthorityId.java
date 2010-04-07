package com.tangmaowen.mis.sys.dao.hibernate.maps;

/**
 * @author 唐懋文
 * @since 2009-11-13 下午04:33:41
 *
 */
public class RoleAuthorityId implements java.io.Serializable {

	private RolePO role;

	private AuthorityPO authority;

	public RoleAuthorityId() {
	}
	
	public RoleAuthorityId(RolePO role, AuthorityPO authority) {
		this.role = role;
		this.authority = authority;
	}
	
	public RolePO getRole() {
		return this.role;
	}

	public void setRole(RolePO role) {
		this.role = role;
	}

	public AuthorityPO getAuthority() {
		return this.authority;
	}

	public void setAuthority(AuthorityPO authority) {
		this.authority = authority;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleAuthorityId))
			return false;
		RoleAuthorityId castOther = (RoleAuthorityId) other;

		return ((this.getRole() == castOther.getRole()) || (this.getRole() != null
				&& castOther.getRole() != null && this.getRole().equals(
				castOther.getRole())))
				&& ((this.getAuthority() == castOther.getAuthority()) || (this
						.getAuthority() != null
						&& castOther.getAuthority() != null && this
						.getAuthority().equals(castOther.getAuthority())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRole() == null ? 0 : this.getRole().hashCode());
		result = 37 * result
				+ (getAuthority() == null ? 0 : this.getAuthority().hashCode());
		return result;
	}

}