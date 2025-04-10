package com.database._02_hibernate.annotation.dto._04_mapping._04_manyToMany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity 
@Table (name="USER_DETAILS_13_MANY_TO_MANY")
public class UserDetails13ManyToMany {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	// can be set for getter
	@Column (name="USER_NAME")
	private String userName;	
	
	@ManyToMany
	@JoinTable(name="USER_VEHICLE_AUX_13", joinColumns=@JoinColumn(name="USER_ID"), //mapping through auxiliary table
	inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle13ManyToMany> vehicles = new ArrayList<Vehicle13ManyToMany>();
	

	public Collection<Vehicle13ManyToMany> getVehicles() {
		return vehicles;
	}
	public void setVehicle(Collection<Vehicle13ManyToMany> vehicles) {
		this.vehicles = vehicles;
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
