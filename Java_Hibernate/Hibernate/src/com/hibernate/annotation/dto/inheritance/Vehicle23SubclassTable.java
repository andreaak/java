package com.hibernate.annotation.dto.inheritance;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Vehicle23SubclassTable {
	
	private String vehicleName;
	private String licenseNumber;
	
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
