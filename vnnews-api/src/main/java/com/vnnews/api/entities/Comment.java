package com.vnnews.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tiendd
 */
@Entity
@Table(name = "TBL_COMMENT")
@XmlRootElement
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(unique=true, nullable=false)
	private long id;

	private Long approver;

	@Column(length=2020)
	private String content;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATE_TIME")
	private Date createTime;

	@Column(name="LIKE_NUM")
	private Long likeNum;

	@Column(length=120)
	private String msisdn;

	@Column(name="NEWS_ID")
	private Long newsId;

	@Column(name="PARENT_ID")
	private Long parentId;

	@Column(length=50)
	private String source;

	private Long status;

	@Column(name="UNCENSORED_CONTENT", length=2020)
	private String uncensoredContent;

	public Comment() {
		
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getApprover() {
		return this.approver;
	}

	public void setApprover(Long approver) {
		this.approver = approver;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getLikeNum() {
		return this.likeNum;
	}

	public void setLikeNum(Long likeNum) {
		this.likeNum = likeNum;
	}

	public String getMsisdn() {
		return this.msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Long getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getUncensoredContent() {
		return this.uncensoredContent;
	}

	public void setUncensoredContent(String uncensoredContent) {
		this.uncensoredContent = uncensoredContent;
	}

}
