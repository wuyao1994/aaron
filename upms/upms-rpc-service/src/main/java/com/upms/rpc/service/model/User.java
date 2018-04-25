package com.upms.rpc.service.model;

import com.upms.rpc.service.util.Securitys;

import java.util.List;

public class User {
	private String			name;
	private String			accountId;
	private boolean			isAdmin;
	private List<String>	roles;
	private List<String>	permissions;



	public static User buildUser() {
		if (!Securitys.isAuthenticatedOrRemembered()) {
			return null;
		}

		User user = new User();
		user.setName(Securitys.getName());
		user.setAccountId(Securitys.getAccountId());
		user.setAdmin(Securitys.isAdmin());
		return user;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public boolean isAdmin() {
		return isAdmin;
	}



	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}



	public List<String> getRoles() {
		return roles;
	}



	public void setRoles(List<String> roles) {
		this.roles = roles;
	}



	public List<String> getPermissions() {
		return permissions;
	}



	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
}
