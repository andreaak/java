package com.hibernate.annotation.dto._03_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.hibernate.annotation.dto.UserDetailsBase;

import org.hibernate.annotations.IndexColumn;

@Entity 
@Table (name="USER_DETAILS_COLLECTION")
public class UserDetailsCollection extends UserDetailsBase {
	
	//Bag semantic
	//Bag semantic with ID
	//@ElementCollection //Default - Lazy
	@ElementCollection(fetch=FetchType.LAZY)//Use LAZY for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_COLLECTION", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilogen", type = @Type(type = "long"))
	@IndexColumn(name="POSITION", base = 1)//ignored
	private Collection<Address> collectionOfAdresses = new ArrayList<Address>();
	public Collection<Address> getCollectionOfAdresses() {
		return collectionOfAdresses;
	}
	public void setCollectionOfAdresses(Collection<Address> collectionOfAdresses) {
		this.collectionOfAdresses = collectionOfAdresses;
	}
	
	//Set semantic
	@ElementCollection(fetch=FetchType.LAZY)//Use Lazy for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_SET", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	//@CollectionId //not support for set. Exception occurred
	private Set<Address> setOfAdresses = new HashSet<Address>();	
	public Set<Address> getSetOfAdresses() {
		return setOfAdresses;
	}
	public void setSerOfAdresses(Set<Address> setOfAdresses) {
		this.setOfAdresses = setOfAdresses;
	}
	
	//List semantic with position
	@ElementCollection(fetch=FetchType.LAZY)//Use Lazy for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_LIST", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	//@CollectionId//not support with @IndexColumn. Exception occurred
	@IndexColumn(name="POSITION", base = 1)
	private List<Address> listOfAdresses = new ArrayList<Address>();	
	public List<Address> getListOfAdresses() {
		return listOfAdresses;
	}
	public void setListOfAdresses(List<Address> listOfAdresses) {
		this.listOfAdresses = listOfAdresses;
	}
	
	//Map semantic
	@ElementCollection(fetch=FetchType.LAZY)//Use Lazy for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_MAP", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	//@CollectionId //not support for map. Exception occurred
    @MapKeyColumn(name="KEY_VALUE")
	private Map<Integer, Address> mapOfAdresses = new HashMap<Integer, Address>();
	public Map<Integer, Address> getMapOfAdresses() {
		return mapOfAdresses;
	}
	public void setMapOfAdresses(Map<Integer, Address> mapOfAdresses) {
		this.mapOfAdresses = mapOfAdresses;
	}	
}
