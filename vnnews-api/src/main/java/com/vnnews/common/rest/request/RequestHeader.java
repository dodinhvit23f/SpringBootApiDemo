package com.vnnews.common.rest.request;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.vnnews.common.rest.Utility;
import com.vnnews.common.rest.interfaces.ComunicationHeader;

import io.swagger.annotations.ApiModelProperty;

@Type(value = RequestHeader.class, name = "RequestHeader") 
public class RequestHeader extends ComunicationHeader {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2935215757836522570L;
	
	@ApiModelProperty("Chuỗi xác thực")
	private String authorization;
	
	@ApiModelProperty("Mã giao dịch")
	private long requestTime;

	public String getAuthorization() {
		return authorization;
	}

	public long getRequestTime() {
		return requestTime;
	}

	public void setAuthorization(long authorization) throws NoSuchAlgorithmException, UnsupportedEncodingException {	
		this.authorization = Utility.getSHA_256(Utility.encodeBase64(String.valueOf(authorization)));
	}

	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}

}
