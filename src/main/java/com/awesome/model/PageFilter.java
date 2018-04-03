package com.awesome.model;

public class PageFilter {
	private Integer	page		= 1;
	private Integer	pageSize	= 10;



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer pPage) {
		page = pPage;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pPageSize) {
		pageSize = pPageSize;
	}
}
