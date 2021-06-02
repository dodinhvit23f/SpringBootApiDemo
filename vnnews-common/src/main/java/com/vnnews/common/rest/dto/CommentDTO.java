package com.vnnews.common.rest.dto;

import java.util.Date;

public class CommentDTO {
	private Long id;
	private String msisdn;
	private String content;
	private Date createTime;
	private String source;
	private Long newsId;
	private Long parentId;
	private Long likeNum;
	
	public Long getId() {
		return id;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public String getContent() {
		return content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public String getSource() {
		return source;
	}
	public Long getNewsId() {
		return newsId;
	}
	public Long getParentId() {
		return parentId;
	}
	public Long getLikeNum() {
		return likeNum;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public void setLikeNum(Long likeNum) {
		this.likeNum = likeNum;
	}
	
}
