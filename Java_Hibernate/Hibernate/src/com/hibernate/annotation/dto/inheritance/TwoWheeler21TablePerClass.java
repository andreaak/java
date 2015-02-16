package com.hibernate.annotation.dto.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="TWO_WHEELER_21_TABLE_PER_CLASS")
public class TwoWheeler21TablePerClass extends Vehicle21TablePerClass {
	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
}
