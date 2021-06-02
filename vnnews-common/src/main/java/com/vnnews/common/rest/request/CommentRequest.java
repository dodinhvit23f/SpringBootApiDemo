package com.vnnews.common.rest.request;

public class CommentRequest extends ManipulateRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4692845377364195488L;
	
	private String content;
	
	private String src;
	private Long parentId;
	private int page;
	private int pageSize;

	public CommentRequest() {
		page = 1 ;
		pageSize = 1000;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSrc() {
		return src;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
	
		
}
