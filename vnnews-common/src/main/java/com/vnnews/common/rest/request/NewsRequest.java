
package com.vnnews.common.rest.request;

import com.vnnews.common.rest.base.BaseRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (
	    value       = "CategoryListRequest",
	    description = "Trả về danh sách các Category"
	)
public class NewsRequest extends BaseRequest {

	
	private static final long serialVersionUID = -1799541936558627258L;
	
	public NewsRequest() {
		page = 1;
		pageSize = 10;
	}
	@ApiModelProperty("Category Id")
	private int cateId;
	@ApiModelProperty("Số điện thoại")
	private String msisdn;
	@ApiModelProperty("Số trang")
	private int page;
	@ApiModelProperty("Số bản ghi trong một trang")
	private int pageSize;

	public int getCateId() {
		return cateId;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
