package com.java._07_Collections;

import java.util.*;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _03_HashMap {
	
	@Test
    public void TestMap1PutInMap() {
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
			System.out.println(pair.getValue());
		}

		/*
		1
		[1, 2, 3]
		 */
    }

	@Test
	public void TestMap2(){
		Map<String, Fruit> fruitMap = new HashMap<>();
		Fruit mango = new Fruit("mango", 50, true);
		Fruit apple = new Fruit("apple", 15, false);
		Fruit banana = new Fruit("banana", 35, true);
		Fruit orange = new Fruit("orange", 24, true);
		fruitMap.put(mango.getName(), mango);
		fruitMap.put(apple.getName(), apple);
		fruitMap.put(banana.getName(), banana);
		fruitMap.put(orange.getName(), orange);
		fruitMap.put("orange", new Fruit("orange", 80, false));

		System.out.println(fruitMap);
		/*
		{banana=Fruit{name='banana', cost=35, isRipe=true},
		orange=Fruit{name='orange', cost=80, isRipe=false},
		apple=Fruit{name='apple', cost=15, isRipe=false},
		mango=Fruit{name='mango', cost=50, isRipe=true}}
 		*/

		Fruit fruit = fruitMap.get("banana");
		System.out.println(fruit);
		System.out.println(fruitMap.get("mango11"));

		Set<String> strings = fruitMap.keySet();
		System.out.println(strings);
		/*
		Fruit{name='banana', cost=35, isRipe=true}
		null
		[banana, orange, apple, mango]
		 */

		Collection<Fruit> fruits = fruitMap.values();
		System.out.println(fruits);

		/*
		[Fruit{name='banana', cost=35, isRipe=true}, Fruit{name='orange', cost=80, isRipe=false},
		Fruit{name='apple', cost=15, isRipe=false}, Fruit{name='mango', cost=50, isRipe=true}]
		 */

		for (Map.Entry<String, Fruit> fruitEntry : fruitMap.entrySet()) {
			String key = fruitEntry.getKey();
			Fruit fruit2 = fruitEntry.getValue();
			System.out.println("Key: "+ key + " Value: "+ fruit2);
		}
		/*
		Key: banana Value: Fruit{name='banana', cost=35, isRipe=true}
		Key: orange Value: Fruit{name='orange', cost=80, isRipe=false}
		Key: apple Value: Fruit{name='apple', cost=15, isRipe=false}
		Key: mango Value: Fruit{name='mango', cost=50, isRipe=true}
		 */
	}

	@Test
	public void TestMap3HashTable() {
		Hashtable<String, List<String>> map = new Hashtable<String, List<String>>();
		List<String> list =  new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		map.put("1", list);

		for(Entry<String, List<String>> pair : map.entrySet()) {
			System.out.println(pair.getKey());
			System.out.println(pair.getValue());
		}

		/*
		1
		[1, 2, 3]
		 */
	}

	@Test
	public void TestMap4TreeMap(){
		Map<String, Fruit> fruitMap = new TreeMap<>();
		Fruit mango = new Fruit("mango", 50, true);
		Fruit apple = new Fruit("apple", 15, false);
		Fruit banana = new Fruit("banana", 35, true);
		Fruit orange = new Fruit("orange", 24, true);
		fruitMap.put(mango.getName(), mango);
		fruitMap.put(apple.getName(), apple);
		fruitMap.put(banana.getName(), banana);
		fruitMap.put(orange.getName(), orange);
		fruitMap.put("orange", new Fruit("orange", 80, false));

		System.out.println(fruitMap);

		/*
		{apple=Fruit{name='apple', cost=15, isRipe=false},
		banana=Fruit{name='banana', cost=35, isRipe=true},
		mango=Fruit{name='mango', cost=50, isRipe=true},
		orange=Fruit{name='orange', cost=80, isRipe=false}}
		 */
	}
}
