package com.sapo.ex7_RestfullAPI_Spring.dto;

import java.util.Date;

public class BaseDto {
     private int id;
     private Date createdDate;
     private Date modifiedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
     
     
}
