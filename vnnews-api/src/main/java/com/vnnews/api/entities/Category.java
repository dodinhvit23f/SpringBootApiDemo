/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnnews.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Tiendd
 */
@Entity
@Table(name = "TBL_CATEGORY")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false, precision = 0, scale = -127)
	private Long id;
	@Column(name = "NAME", length = 250)
	private String name;
	@Column(name = "IMAGE", length = 250)
	private String image;
	@Column(name = "ID_PARENT")
	private Long idParent;
	@Column(name = "ID_USER")
	private Long idUser;
	@Column(name = "CREATE_TIME")
	private Date createTime;
	@Column(name = "ORDERVIEW")
	private Long orderview;
	@Column(name = "STATUS")
	private Long status;
	@Column(name = "DESCRIPTION", length = 500)
	private String description;
	@Column(name = "CP_ID")
	private Long cpId;
	@Column(name = "SYNC_STATUS")
	private Long syncStatus;

	
	public Category() {
	}

	public Category(Long id, String name, String image, Long cpId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.cpId = cpId;
	}

	public Category(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getIdParent() {
		return idParent;
	}

	public void setIdParent(Long idParent) {
		this.idParent = idParent;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getOrderview() {
		return orderview;
	}

	public void setOrderview(Long orderview) {
		this.orderview = orderview;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCpId() {
		return cpId;
	}

	public void setCpId(Long cpId) {
		this.cpId = cpId;
	}

	public Long getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Long syncStatus) {
		this.syncStatus = syncStatus;
	}
		
	
}
