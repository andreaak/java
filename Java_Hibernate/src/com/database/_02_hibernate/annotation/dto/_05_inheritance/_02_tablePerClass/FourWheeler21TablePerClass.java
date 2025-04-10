package com.database._02_hibernate.annotation.dto._05_inheritance._02_tablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="FOUR_WHEELER_21_TABLE_PER_CLASS")
public class FourWheeler21TablePerClass extends Vehicle21TablePerClass {
	
	public FourWheeler21TablePerClass() {

	}
	
	public FourWheeler21TablePerClass(String vehicleName, String steeringWheel) {
		this.setVehicleName(vehicleName);
		this.steeringWheel = steeringWheel;
	}

	public String steeringWheel;
	
//	public String getSteeringWheel() {
//		return steeringWheel;
//	}
//
//	public void setSteeringWheel(String steeringWheel) {
//		this.steeringWheel = steeringWheel;
//	}
}
