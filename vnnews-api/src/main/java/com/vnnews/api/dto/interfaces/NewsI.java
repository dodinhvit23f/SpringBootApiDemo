package com.vnnews.api.dto.interfaces;

import java.util.Date;



public interface NewsI {
	String getTitle();
	String getDescription();
	String getGroupName();
	String getImage1();
	String getImage2();
	String getCateName();
	Date getCreateTime();
	Long getNewsType();
	Long getViewCount();
	Long getNumlike();
	Long getShareCount();
	Long getCommentCount();
	Long getId();
	CategoryI getCategory();
	
}
