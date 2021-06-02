package com.vnnews.common.rest.response;

import java.util.List;

import com.vnnews.common.object.PageInfo;
import com.vnnews.common.rest.base.BaseRespone;
import com.vnnews.common.rest.dto.CommentDTO;

public class CommentListResponse extends BaseRespone {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1923933578573797338L;
	
	private PageInfo pageInfo;
	private List<CommentDTO> data;
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public List<CommentDTO> getData() {
		return data;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public void setData(List<CommentDTO> data) {
		this.data = data;
	}
		
	
}
