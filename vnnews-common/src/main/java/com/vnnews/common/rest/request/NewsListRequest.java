package com.vnnews.common.rest.request;

import com.vnnews.common.rest.base.BaseRequest;

public class NewsListRequest extends BaseRequest {

	private static final long serialVersionUID = -9087387229441242471L;
	// id cua tin tuc
	private Long id;
	// số thuê bao. Để lọc theo sở thích của số thêu bao
	private String msisdn;
	// Lọc theo Cate Id
	private Long cateId;
	// 0: sắp xếp theo mới nhất, 1: sắp xếp theo lượt view
	private int orderType;
	// 12 Tin Mini App 11 Tin home SuperApp 13 Tin Nổi Bật
	private Long groupType;
	// 0: text 1: video 2: image 3: audio
	private Long contentType;
	// 0. Tin trong cate yêu thích 1. Tin yêu thích 2. Tin đã lưu 3. Tin xem
	private int filterType;
	// từ khóa tìm kiếm
	private String txt;
	// Mã địa phương
	private Long provinceId;

	private String tags;
	private String lastUpdateTime;
	private int trending;
	private int page;
	private int pageSize;

	public NewsListRequest() {
		this.page = 1;
		this.pageSize = 100;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public Long getCateId() {
		return cateId;
	}

	public int getOrderType() {
		return orderType;
	}

	public Long getGroupType() {
		return groupType;
	}

	public Long getContentType() {
		return contentType;
	}

	public int getFilterType() {
		return filterType;
	}

	public String getTxt() {
		return txt;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public String getTags() {
		return tags;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public int getTrending() {
		return trending;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public void setGroupType(Long groupType) {
		this.groupType = groupType;
	}

	public void setContentType(Long contentType) {
		this.contentType = contentType;
	}

	public void setFilterType(int filterType) {
		this.filterType = filterType;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public void setTrending(int trending) {
		this.trending = trending;
	}

	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
