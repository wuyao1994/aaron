package com.aaron.model;

public class Menu {

	private String	id;
	private String	bpid;
	private String	mpid;
	private String	icon;
	private String	name;
	private String	router;
	private Integer	menuLevel;



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBpid() {
		return bpid;
	}



	public void setBpid(String bpid) {
		this.bpid = bpid;
	}



	public String getMpid() {
		return mpid;
	}



	public void setMpid(String mpid) {
		this.mpid = mpid;
	}



	public String getIcon() {
		return icon;
	}



	public void setIcon(String icon) {
		this.icon = icon;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getRouter() {
		return router;
	}



	public void setRouter(String router) {
		this.router = router;
	}



	public Integer getMenuLevel() {
		return menuLevel;
	}



	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
}
