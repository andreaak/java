package com.hibernate.annotation.dto.collection;

import java.util.ArrayList;
import java.util.Collection;

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

@Entity 
@Table (name="USER_DETAILS_08_FETCH_TYPES")
public class UserDetails08FetchTypes {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="USER_ID")
	private int userId;
	// can be set for getter
	@Column (name="USER_NAME")
	private String userName;	
	//@ElementCollection //Default - Lazy
	@ElementCollection(fetch=FetchType.LAZY)//Use Lazy for Lazy Load and EAGER  for instant load.
	@JoinTable(name="USER_ADDRESS_08_FETCH_TYPES", 
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilogen", strategy="increment")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilogen", type = @Type(type = "long"))
	private Collection<Address07> listOfAdresses = new ArrayList<Address07>();
	
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
