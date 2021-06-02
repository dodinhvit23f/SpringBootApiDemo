package com.vnnews.common.rest.base;

import java.io.Serializable;

public class BaseRespone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BaseRespone() {
		status = 0;
		
	}
	
	private int status;
	private String mesage;
	
	public int getStatus() {
		return status;
	}
	public String getMesage() {
		return mesage;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
}
