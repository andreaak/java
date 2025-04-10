package com.database._02_hibernate.annotation.dto._02_embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.database._02_hibernate.annotation.dto.UserDetailsBase;

@Entity 
@Table (name="USER_DETAILS_EMBEDDED")
public class UserDetailsEmbedded extends UserDetailsBase {
	
	//  Use @EmbeddedId if primary keys is object
	//  @EmbeddedId
	//  private LoginName userId;
	//  or
	//	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	//	@Column (name="USER_ID")
	//	private int userId;
	
	@Embedded
	//Override Address column name
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")), 
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),  
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),  
		@AttributeOverride(name="pincode", column=@Column(name="HOME_PIN_CODE")),  
	})
	private Address homeAddress;
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	@Embedded
	private Address2 officeAddress;
	public Address2 getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address2 officeAddress) {
		this.officeAddress = officeAddress;
	}
}
