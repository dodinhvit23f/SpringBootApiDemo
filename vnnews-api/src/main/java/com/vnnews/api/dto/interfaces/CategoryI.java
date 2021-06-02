package com.vnnews.api.dto.interfaces;

import java.util.Date;

public interface CategoryI {

	public Long getId();

	public String getName();

	public String getImage();

	public Long getIdParent();

	public Long getIdUser();

	public Date getCreateTime();

	public Long getOrderview();

	public Long getStatus();

	public String getDescription();

	public Long getCpId();

	public Long getSyncStatus();

}
