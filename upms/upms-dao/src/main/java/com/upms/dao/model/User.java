package com.upms.dao.model;


import java.util.List;

public class User {
	private String			name;
	private String			accountId;
	private boolean			isAdmin;
	private List<String> roles;
	private List<String>	permissions;




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
