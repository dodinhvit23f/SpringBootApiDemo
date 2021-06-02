package com.vnnews.common.rest.interfaces;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Mô tả về dạng dữ liệu trả về và gửi lên api")
public class Communication<BODY> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@ApiModelProperty("Header chứa các thông tin cần xác thực")
	//private ComunicationHeader header;
	@ApiModelProperty("Nội dung Request tới server hoặc Response server trả về, được chuyển sang json rồi mã hóa")
	private BODY params;
	

	public BODY getParams() {
		return params;
	}

	public void setParams(BODY params) {
		this.params = params;
	}

}
