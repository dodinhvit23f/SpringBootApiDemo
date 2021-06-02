package com.vnnews.common.rest.dto;

import java.io.Serializable;
import java.util.Date;

public class NewsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3313202337565687835L;
	
	private String description;
	private String title;
	private String cateName;
	private String groupName;
	private String sourceName;
	private String img1;
	private String img2;
	private String content;
	
	private Long commentCount;
	private Long likeCount;
	private Long shareCount;
	private Long newsId;
	private Long viewCount;
	private Long contentType;
	
	private Date createTime;
	
	public NewsDTO() {
		
	}
	
	public NewsDTO(String description, String title, String cateName, String groupName, String sourceName, String img1,
			String img2, Long commentCount, Long likeCount, Long shareCount, Long newsId, Long viewCount,
			Long contentType, Date createTime) {
		this.description = description;
		this.title = title;
		this.cateName = cateName;
		this.groupName = groupName;
		this.sourceName = sourceName;
		this.img1 = img1;
		this.img2 = img2;
		this.commentCount = commentCount;
		this.likeCount = likeCount;
		this.shareCount = shareCount;
		this.newsId = newsId;
		this.viewCount = viewCount;
		this.contentType = contentType;
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

	public String getCateName() {
		return cateName;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getImg1() {
		return img1;
	}

	public String getImg2() {
		return img2;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public Long getLikeCount() {
		return likeCount;
	}

	public Long getShareCount() {
		return shareCount;
	}

	public Long getNewsId() {
		return newsId;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public Long getContentType() {
		return contentType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public void setLikeCount(Long likeCount) {
		this.likeCount = likeCount;
	}

	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public void setContentType(Long contentType) {
		this.contentType = contentType;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
