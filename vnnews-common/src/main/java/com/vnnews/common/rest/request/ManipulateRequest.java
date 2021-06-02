package com.vnnews.common.rest.request;

import com.vnnews.common.rest.base.BaseRequest;

public class ManipulateRequest extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 379088296990143799L;

	private Long id;
	private String msidn;
	private Long newId;

	public Long getId() {
		return id;
	}

	public String getMsidn() {
		return msidn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMsidn(String msidn) {
		this.msidn = msidn;
	}

	public Long getNewId() {
		return newId;
	}

	public void setNewId(Long newId) {
		this.newId = newId;
	}
	
}
