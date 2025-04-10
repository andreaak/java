package com.database._02_hibernate.annotation.dto._05_inheritance._01_discriminator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("Bike")
public class TwoWheeler20Discriminator extends Vehicle20Discriminator {
	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
}
