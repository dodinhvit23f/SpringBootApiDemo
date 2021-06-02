package com.vnnews.common.rest.response;

import java.util.List;

import com.vnnews.common.object.PageInfo;
import com.vnnews.common.rest.base.BaseRespone;
import com.vnnews.common.rest.dto.NewsDTO;

public class NewsListResponse extends BaseRespone{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6787163539555007141L;
	
	private PageInfo pageInfo;
	private List<NewsDTO> data;
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public List<NewsDTO> getData() {
		return data;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public void setData(List<NewsDTO> data) {
		this.data = data;
	}
	
}
