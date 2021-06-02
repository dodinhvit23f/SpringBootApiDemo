
package com.vnnews.common.rest.response;

import java.util.List;

import com.vnnews.common.object.PageInfo;
import com.vnnews.common.rest.base.BaseRespone;
import com.vnnews.common.rest.dto.CategoryDTO;

public class CategoryListResponse extends BaseRespone {

	
	private static final long serialVersionUID = -1799541936558627258L;
	private PageInfo pageInfo;
	private List<CategoryDTO> data;
	
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public List<CategoryDTO> getData() {
		return data;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public void setData(List<CategoryDTO> data) {
		this.data = data;
	}
	
	
}
