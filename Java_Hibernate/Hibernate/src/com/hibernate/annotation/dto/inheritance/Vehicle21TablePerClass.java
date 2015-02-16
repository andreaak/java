package com.hibernate.annotation.dto.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table (name="VEHICLE_21_TABLE_PER_CLASS")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //each class fields in separate tables
public class Vehicle21TablePerClass {
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	private String vehicleName;
	@Column(name="LICENSE_NUMBER")
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
