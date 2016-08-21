package com.hibernate.annotation.dto._06_queries;

import java.util.Date;







import javax.persistence.Basic;
import javax.persistence.Column;
//import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "UserDetails.byId", query="from UserDetails where userId = ?"),
@NamedQuery(name = "UserDetails.byName", query="from UserDetails where userName like ?")
})
@NamedNativeQuery(name = "UserDetails.byNameNat", query="select * from USER_DETAILS_30_QUERIES where USER_NAME like ?", //use *  or list of all column
resultClass = UserDetails.class)
@Table (name="USER_DETAILS_30_QUERIES")
public class UserDetails {
	
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
	private String address;
	//@Lob //use Clob or Blob field in DB
	private String description;
	
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
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSureName() {
		return sureName;
	}
	public void setSureName(String sureName) {
		this.sureName = sureName;
	}
}
