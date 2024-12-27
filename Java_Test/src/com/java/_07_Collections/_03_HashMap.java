package com.java._07_Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _03_HashMap {
	
	@Test
    public void Test1PutInMap() {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> list =  new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		map.put("1", list);
		
		@SuppressWarnings("unchecked")
		HashMap<String, List<String>> map2 = (HashMap<String, List<String>>)map.clone();
		for(Entry<String, List<String>> pair : map2.entrySet()) {
			System.out.println(pair.getKey());
		}
    }
}
