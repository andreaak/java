package com.hibernate.annotation.dto.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table (name="USER_DETAILS_09_ONE_TO_ONE")
public class UserDetails09OneToOneMapping {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	// can be set for getter
	@Column (name="USER_NAME")
	private String userName;	
	
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle09 vehicle;
	
	public Vehicle09 getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle09 vehicle) {
		this.vehicle = vehicle;
	}
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
}
