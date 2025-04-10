package com.database._02_hibernate.annotation.dto._05_inheritance._03_join;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="FOUR_WHEELER_22_JOIN")
public class FourWheeler22Join extends Vehicle22Join {
	
	public FourWheeler22Join() {

	}
	
	public FourWheeler22Join(String vehicleName, String steeringWheel) {
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
