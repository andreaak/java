package com.hibernate.annotation.dto._04_mapping._03_mappedBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table (name="VEHICLE_12_MAPPED_BY")
public class Vehicle12MappedBy {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	@ManyToOne
	//@JoinColumn(name="USER_ID")
	@JoinColumn(name="USER_ID_FK"/*, referencedColumnName = "CUSTOMER_NR" - Foreign key referencing nonprimary keys*/)
	@NotFound(action=NotFoundAction.IGNORE)
	private UserDetails12MappedBy user;
	
	
	public UserDetails12MappedBy getUser() {
		return user;
	}
	public void setUser(UserDetails12MappedBy user) {
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
