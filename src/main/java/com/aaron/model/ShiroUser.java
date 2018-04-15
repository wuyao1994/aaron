package com.aaron.model;

import java.io.Serializable;
import java.util.List;

public class ShiroUser implements Serializable {
	private String					accountId;
	private String					loginName;
	private String					name;
	private boolean					isAdmin;
	private transient List<String>	roleIdList;
	private transient List<Menu>	menus;
	private transient List<String>	roles;
	private transient List<String>	permissions;



	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public String getLoginName() {
		return loginName;
	}



	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public boolean isAdmin() {
		return isAdmin;
	}



	public void setAdmin(boolean pAdmin) {
		isAdmin = pAdmin;
	}



	public List<String> getRoleIdList() {
		return roleIdList;
	}



	public void setRoleIdList(List<String> roleIdList) {
		this.roleIdList = roleIdList;
	}



	public List<Menu> getMenus() {
		return menus;
	}



	public void setMenus(List<Menu> menus) {
		this.menus = menus;
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
