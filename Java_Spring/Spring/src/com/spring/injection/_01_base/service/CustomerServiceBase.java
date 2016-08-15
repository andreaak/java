package com.spring.injection._01_base.service;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceBase {
	
	protected List<LoggingInfo> listAll = new ArrayList<LoggingInfo>();
	
	public String getDescription() {
		return getDescription(listAll);
	}
	
	protected String getIndex() {
		return "";
	}
	
	protected LoggingInfo getMethodDescription(String desc) {
		LoggingInfo info =  new LoggingInfo();
		info.desc = desc;
		info.index = getIndex();
		info.hashCode = hashCode();
		listAll.add(info);
		return info;
	}
	
	protected String getDescription(List<LoggingInfo> list) {
		
		StringBuffer sb = new StringBuffer();
		int hash = 0;
		for(LoggingInfo id : list) {
			if(sb.length() != 0) {
				sb.append(" + ");
			} else {
				hash = id.hashCode;
			}
			sb.append(id.toShortString());
		};
		sb.append(" Hash: " + hash);
		return sb.toString();
	}
}
