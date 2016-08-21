package com.hibernate.annotation.dto;

import java.util.Date;




import javax.persistence.Basic;
import javax.persistence.Column;
//import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table (name="USER_DETAILS_02")
public class UserDetails02Annotation {
	
	@Id
	private int userId;
	@Column (name="USER_NAME")
	private String userName;
	//@Basic ()
	@Transient // Don't add sureName to insert statement
	private String sureName;
	@Temporal(TemporalType.DATE)//Configure DateTime format
	private Date joinedDate;
	@Basic
	private String Address;
	//@Lob //use Clob or Blob field in DB
	private String Description;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getSureName() {
		return sureName;
	}
	public void setSureName(String sureName) {
		this.sureName = sureName;
	}
}
