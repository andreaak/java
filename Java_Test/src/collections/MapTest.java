package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MapTest {
	
	
	@Test
    public void putInMap() {
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
	
	@Test
    public void iteratorTest1() {
		ArrayList<String> list =  new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		//Iterator<String> it = list.iterator();
		int i = 0;
		for(Iterator<String> it = list.iterator(); it.hasNext();) {// it.hasNext() doesn't switch to next position
			System.out.println("Index :" + i);
			if(i++ == 1) {
				continue;
			}
			System.out.println(it.next());// it.next() switch to next position
		}
    }
	
	@Test
    public void iteratorTest2() {
		ArrayList<String> list =  new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {// it.hasNext() doesn't switch to next position
			System.out.println(it.next());// it.next() switch to next position
		}
    }
	
	@Test
    public void iteratorTest3() {
		ArrayList<String> list =  new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		//Iterator<String> it = list.iterator();
		int i = 0;
		for(Iterator<String> it = list.iterator(); it.hasNext();) {
			System.out.println(it.next());// it.next() switch to next position
			if(i++ == 1) {
				it.remove();//use it.remove() after it.next()
			}
			//System.out.println(it.next());
		}
    }
}
