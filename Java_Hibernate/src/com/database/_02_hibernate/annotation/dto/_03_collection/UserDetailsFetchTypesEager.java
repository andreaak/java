package com.database._02_hibernate.annotation.dto._03_collection;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.database._02_hibernate.annotation.dto.UserDetailsBase;

@Entity 
@Table (name="USER_DETAILS_FETCH_TYPES_EAGER")
public class UserDetailsFetchTypesEager extends UserDetailsBase {
	
	//@ElementCollection //Default - Lazy
	@ElementCollection(fetch=FetchType.EAGER)//Use Lazy for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_08_FETCH_TYPES", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilogen", type = @Type(type = "long"))
	private Collection<Address> collectionOfAdresses = new ArrayList<Address>();
	public Collection<Address> getCollectionOfAdresses() {
		return collectionOfAdresses;
	}
	public void setCollectionOfAdresses(Collection<Address> collectionOfAdresses) {
		this.collectionOfAdresses = collectionOfAdresses;
	}
}
