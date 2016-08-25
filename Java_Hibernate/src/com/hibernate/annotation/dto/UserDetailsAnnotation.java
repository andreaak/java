package com.hibernate.annotation.dto;

import java.util.Date;




import javax.persistence.Basic;
import javax.persistence.Column;
//import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
//import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table (name="USER_DETAILS_ANNOTATED")
public class UserDetailsAnnotation {
	
	@Id
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column (name="USER_NAME")
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//@Basic ()
	@Transient // Don't add sureName to insert statement
	private String sureName;
	public String getSureName() {
		return sureName;
	}
	public void setSureName(String sureName) {
		this.sureName = sureName;
	}
	
	@Temporal(TemporalType.DATE)//Configure DateTime format
	private Date joinedDate;
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	@Basic
	private String Address;
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	@Lob //use Clob or Blob field in DB
	private String Description;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}	
}
