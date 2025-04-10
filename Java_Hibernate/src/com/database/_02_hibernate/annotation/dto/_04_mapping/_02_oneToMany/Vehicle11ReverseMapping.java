package com.database._02_hibernate.annotation.dto._04_mapping._02_oneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name="VEHICLE_11_ONE_TO_MANY_REVERSE")
public class Vehicle11ReverseMapping {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;

	@ManyToOne( targetEntity = UserDetails11OneToManyMappingReverse.class)
	@JoinTable(
        name = "USER_VEHICLE_AUX_11",
        joinColumns = {@JoinColumn(name = "VEHICLE_ID")},
        inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
    )
	private UserDetails11OneToManyMappingReverse user;
	
	
	public UserDetails11OneToManyMappingReverse getUser() {
		return user;
	}
	public void setUser(UserDetails11OneToManyMappingReverse user) {
		this.user = user;
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
