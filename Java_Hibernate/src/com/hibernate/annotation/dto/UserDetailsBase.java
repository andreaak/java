package com.hibernate.annotation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserDetailsBase {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	// can be set for getter
	@Column (name="USER_NAME")
	private String userName;	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
