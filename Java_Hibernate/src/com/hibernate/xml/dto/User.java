package com.hibernate.xml.dto;

public class User {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private int total;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	private int goal;
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
}
