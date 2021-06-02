package com.vnnews.common.rest.dto;


public class CategoryDTO {
	
	private String name;
	private Long cateId;
	private String img;
	
	public String getName() {
		return name;
	}
	public Long getCateId() {
		return cateId;
	}
	public String getImg() {
		return img;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
