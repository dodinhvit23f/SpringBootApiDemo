package com.vnnews.common.rest.respone;


import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.vnnews.common.rest.interfaces.ComunicationHeader;

@Type(value = ResponseHeader.class, name = "ResponseHeader") 
public class ResponseHeader extends  ComunicationHeader {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2935215757836522570L;
	
	private final String content_Type = "application/json;charset=utf-8";

	public String getContent_Type() {
		return content_Type;
	}

		
}
