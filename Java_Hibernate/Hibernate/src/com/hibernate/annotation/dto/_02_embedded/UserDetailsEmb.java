package com.hibernate.annotation.dto._02_embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;;

@Entity 
@Table (name="USER_DETAILS_EMBEDDED")
public class UserDetailsEmb {
	
	//Use @EmbeddedId if primary keys is object
	//@EmbeddedId
	//private LoginName userId;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	// can be set for getter
	@Column (name="USER_NAME")
	private String userName;
	
	@Embedded
	//Override Address column name
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")), 
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),  
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),  
		@AttributeOverride(name="pincode", column=@Column(name="HOME_PIN_CODE")),  
	})
	private Address homeAddress;
	@Embedded
	private Address2 officeAddress;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address2 getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address2 officeAddress) {
		this.officeAddress = officeAddress;
	}
}
