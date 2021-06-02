
package com.vnnews.common.rest.request;

import com.vnnews.common.rest.base.BaseRequest;



public class FavoriteRequest extends BaseRequest {

	
	private static final long serialVersionUID = -1799541936558627258L;
	
	public FavoriteRequest() {
		
	}
	// so dien thoai
	private String msisdn;
	// cate List
	private String cateList;

	public String getMsisdn() {
		return msisdn;
	}
	public String getCateList() {
		return cateList;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public void setCateList(String cateList) {
		this.cateList = cateList;
	}
	
}
