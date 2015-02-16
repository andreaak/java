package com.hibernate.annotation.dto._04_mapping._02_oneToMany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity 
@Table (name="USER_DETAILS_10_ONE_TO_MANY")
public class UserDetails10OneToManyMapping {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	// can be set for getter
	@Column (name="USER_NAME")
	private String userName;	
	
	@OneToMany
	@JoinTable(name="USER_VEHICLE_AUX_10", joinColumns=@JoinColumn(name="USER_ID"), //mapping through auxiliary table
	inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	@Fetch(FetchMode.SELECT) // JOIN - EAGER, SELECT - LAZY
	private Collection<Vehicle10> vehicle = new ArrayList<Vehicle10>();
	

	public Collection<Vehicle10> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle10> vehicle) {
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
