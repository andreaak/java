package com.hibernate.annotation.dto.collection;

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.MapKey;


@SuppressWarnings("deprecation")
@Entity 
@Table (name="USER_DETAILS_07_COLLECTION")
public class UserDetails07Collection {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	// can be set for getter
	@Column (name="USER_NAME")
	private String userName;	
	
	//Bag semantic
	//Bag semantic with ID
	//@ElementCollection //Default - Lazy
	@ElementCollection(fetch=FetchType.LAZY)//Use LAZY for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_07_COLLECTION", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilogen", type = @Type(type = "long"))
	@IndexColumn(name="POSITION", base = 1)//ignored
	private Collection<Address07> listOfAdresses = new ArrayList<Address07>();

	//Set semantic
	@ElementCollection(fetch=FetchType.LAZY)//Use Lazy for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_07_SET", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	//@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilogen", type = @Type(type = "long")) not support for set
	private Set<Address07> listOfHomeAdresses = new HashSet<Address07>();	
	
	//Bag semantic
	//Bag semantic with ID
	//List semantic with position
	@ElementCollection(fetch=FetchType.LAZY)//Use Lazy for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_07_LIST", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	//@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilogen", type = @Type(type = "long")) //not support with @IndexColumn
	@IndexColumn(name="POSITION", base = 1)
	private List<Address07> listOfWorkAdresses = new ArrayList<Address07>();	
	
	//Map semantic
	@ElementCollection(fetch=FetchType.LAZY)//Use Lazy for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_07_MAP", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	//@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilogen", type = @Type(type = "long")) //not support for map
	@MapKey(
		     columns = @Column(name="KEY_VALUE")
	)
	private Map<Integer, Address07> mapOfWorkAdresses = new HashMap<Integer, Address07>();
	
	
	public Map<Integer, Address07> getMapOfWorkAdresses() {
		return mapOfWorkAdresses;
	}
	public void setMapOfWorkAdresses(Map<Integer, Address07> mapOfWorkAdresses) {
		this.mapOfWorkAdresses = mapOfWorkAdresses;
	}
	public List<Address07> getListOfWorkAdresses() {
		return listOfWorkAdresses;
	}
	public void setListOfWorkAdresses(List<Address07> listOfWorkAdresses) {
		this.listOfWorkAdresses = listOfWorkAdresses;
	}
	public Set<Address07> getListOfHomeAdresses() {
		return listOfHomeAdresses;
	}
	public void setListOfHomeAdresses(Set<Address07> listOfHomeAdresses) {
		this.listOfHomeAdresses = listOfHomeAdresses;
	}
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
	public Collection<Address07> getListOfAdresses() {
		return listOfAdresses;
	}
	public void setListOfAdresses(Collection<Address07> listOfAdresses) {
		this.listOfAdresses = listOfAdresses;
	}
}
