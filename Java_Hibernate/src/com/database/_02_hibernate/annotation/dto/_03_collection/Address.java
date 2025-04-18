package com.database._02_hibernate.annotation.dto._03_collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name="STREET_NAME", length = 255, nullable = false)
	private String street;
	@Column(name="CITY_NAME", length = 255, nullable = false)
	private String city;
	@Column(name="STATE_NAME")
	private String state;
	@Column(name="PIN_CODE")
	private String pincode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
