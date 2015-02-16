package com.hibernate.annotation.dto._05_inheritance._01_discriminator;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue("Car")
public class FourWheeler20Discriminator extends Vehicle20Discriminator {
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
}
