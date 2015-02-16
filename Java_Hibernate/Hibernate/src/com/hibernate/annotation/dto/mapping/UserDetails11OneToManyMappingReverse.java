package com.hibernate.annotation.dto.mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity 
@Table (name="USER_DETAILS_11_ONE_TO_MANY_REVERSE")
public class UserDetails11OneToManyMappingReverse {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	// can be set for getter
	@Column (name="USER_NAME")
	private String userName;	
	
	@OneToMany(mappedBy = "user")
	@Fetch(FetchMode.SELECT)
	private Collection<Vehicle11ReverseMapping> vehicle = new ArrayList<Vehicle11ReverseMapping>();
	

	public Collection<Vehicle11ReverseMapping> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle11ReverseMapping> vehicle) {
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
