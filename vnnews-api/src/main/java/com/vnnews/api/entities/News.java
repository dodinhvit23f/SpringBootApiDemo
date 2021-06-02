package com.vnnews.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */

@Entity
@Table(name = "TBL_NEWS")
@XmlRootElement

public class News implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "CATE_ID")
    private Long cateId;
    
    @Column(name = "IMAGE1")
    private String image1;
    
    @Column(name = "IMAGE2")
    private String image2;
    
    @Column(name = "KEYWORD")
    private String keyword;
    
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    
    @Column(name = "VIEW_COUNT")
    private Long viewCount;
    
    @Column(name = "STATUS")
    private Long status;
    
    @Column(name = "TAG")
    private String tag;
    
    @Column(name = "CREATOR_ID")
    private Long creatorId;
    
    @Column(name = "TYPE_ID")
    private Long typeId;
    
    @Column(name = "ISFREE")
    private Long isfree;
    
    @Column(name = "NEWS_TYPE")
    private Long newsType;
    
    @Column(name = "NUMLIKE")
    private Long numlike;
    
    @Column(name = "TITLE_LINK")
    private String titleLink;
    
    @Column(name = "SHARE_COUNT")
    private Long shareCount;
    
    @Column(name = "COMMENT_COUNT")
    private Long commentCount;
    
    @Column(name = "PROV_ID")
    private String provId;
    @Lob
    @Column(name = "CONTENT")
    private String content;
    @Lob
    @Column(name = "CONTENT_READ")
    private String contentRead;
    @Column(name = "VIEW_COUNT_1")
    private Long viewCount1;
    @Column(name = "NEWS_RECOMMENT_ID")
    private String newsRecommentId;
    @Column(name = "VMOVIE")
    private String vmovie;
    @Column(name = "VCLIP")
    private String vclip;
    @Column(name = "SOURCE_ID")
    private Long sourceId;
    @Column(name = "SYNC_STATUS")
    private Long syncStatus;
    @Column(name = "SOURCE_URL")
    private String sourceUrl;
    @Column(name = "CRAW_KEY")
    private String crawKey;
    @Column(name = "BASE_ID")
    private String baseId;
    @Column(name = "VERTICAL")
    private Short vertical;
    
    public News() {
    }

    public News(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getIsfree() {
        return isfree;
    }

    public void setIsfree(Long isfree) {
        this.isfree = isfree;
    }

    public Long getNewsType() {
        return newsType;
    }

    public void setNewsType(Long newsType) {
        this.newsType = newsType;
    }

    public Long getNumlike() {
        return numlike;
    }

    public void setNumlike(Long numlike) {
        this.numlike = numlike;
    }

    public String getTitleLink() {
        return titleLink;
    }

    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentRead() {
        return contentRead;
    }

    public void setContentRead(String contentRead) {
        this.contentRead = contentRead;
    }

    public Long getViewCount1() {
        return viewCount1;
    }

    public void setViewCount1(Long viewCount1) {
        this.viewCount1 = viewCount1;
    }

    public String getNewsRecommentId() {
        return newsRecommentId;
    }

    public void setNewsRecommentId(String newsRecommentId) {
        this.newsRecommentId = newsRecommentId;
    }

    public String getVmovie() {
        return vmovie;
    }

    public void setVmovie(String vmovie) {
        this.vmovie = vmovie;
    }

    public String getVclip() {
        return vclip;
    }

    public void setVclip(String vclip) {
        this.vclip = vclip;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(Long syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getCrawKey() {
        return crawKey;
    }

    public void setCrawKey(String crawKey) {
        this.crawKey = crawKey;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public Short getVertical() {
        return vertical;
    }

    public void setVertical(Short vertical) {
        this.vertical = vertical;
    }
    
}
