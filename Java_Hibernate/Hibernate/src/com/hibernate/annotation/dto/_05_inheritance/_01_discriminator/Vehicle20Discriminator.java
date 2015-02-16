package com.hibernate.annotation.dto._05_inheritance._01_discriminator;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE_20_DISCRIMINATOR")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//default - each class fields in one table
@DiscriminatorColumn(name= "VEHICLE_TYPE", discriminatorType=DiscriminatorType.STRING )
@DiscriminatorValue("Vehicle")
public class Vehicle20Discriminator {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	private String licenseNumber;
	
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
	
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

}
