package com.vnnews.common.object;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class PageInfo implements Serializable{

	/**
	 * tiendd
	 */
	private static final long serialVersionUID = -9001412837191230841L;
	
	@ApiModelProperty("Tổng số Trang")
	private int totalPage;
	@ApiModelProperty("Số bản ghi trả về")
	private long totalItem;
	@ApiModelProperty("Trang thứ")
	private int page;
	@ApiModelProperty("Số Bản ghi trong một trang")
	private int pageSize;
	public int getTotalPage() {
		return totalPage;
	}
	public long getTotalItem() {
		return totalItem;
	}
	public int getPage() {
		return page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setTotalItem(long totalItem) {
		this.totalItem = totalItem;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
