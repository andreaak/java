package com.hibernate.annotation.dto.mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE_13_MANY_TO_MANY")
public class Vehicle13ManyToMany {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;

	@ManyToMany(mappedBy="vehicles" )
	private Collection<UserDetails13ManyToMany> users = new ArrayList<UserDetails13ManyToMany>();;
	
	
	public Collection<UserDetails13ManyToMany> getUsers() {
		return users;
	}
	public void setUser(Collection<UserDetails13ManyToMany> users) {
		this.users = users;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
