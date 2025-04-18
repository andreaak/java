package com.database._02_hibernate.annotation.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class UserDetails01 {
	@Id
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
