package com.database._02_hibernate.annotation.dto._04_mapping._03_mappedBy;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table (name="USER_DETAILS_14_CASCADE")
public class UserDetails14Cascade {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	// can be set for getter
	@Column (name="USER_NAME")
	private String userName;	
	
	@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
	private Collection<Vehicle14Cascade> vehicle = new ArrayList<Vehicle14Cascade>();
	

	public Collection<Vehicle14Cascade> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle14Cascade> vehicle) {
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
