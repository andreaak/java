package com.spring.injection._01_base.service;

public class LoggingInfo {
	public String desc;
	public String index;
	public int hashCode;

	public String toString(){
		return String.format("%1$s %2$s Hash:%3$d", desc, index, hashCode);
	}
	
	public String toShortString(){
		return String.format("%1$s %2$s", desc, index);
	}
}