package com.database._02_hibernate.annotation.dto._05_inheritance._03_join;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="TWO_WHEELER_22_JOIN")
@PrimaryKeyJoinColumn(name = "TWO_WHEEL_ID")
public class TwoWheeler22Join extends Vehicle22Join {
	
	
//	@Id @GeneratedValue(strategy=GenerationType.TABLE)
//	private int vehicleId;
	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
}
