package com.cris.website.model;

import java.util.Date;

public class BaseModel {
    private Integer pk;
    private Date createTime;
    
    public BaseModel() {
        super();
    }

    public BaseModel(Integer pk,Date createTime) {
        super();
        this.pk = pk;
        this.createTime = createTime;
    }

	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    
}
