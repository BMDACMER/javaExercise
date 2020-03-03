package com.csdn.base02.coll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Demo01 {
	static void testMap1() {
//		HashMap<String, String> map = new HashMap<String, String>();
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("ccc","tom");
		map.put("aaa", "20");
		map.put("bbb", "tom@gmail.com");
		
		System.out.println(map.get("ccc"));    // tom
		map.remove("ccc");
		for (String key: map.keySet()) {
			System.out.println(key + "," + map.get(key));
		}   // aaa,20    bbb,tom@gmail.com
		
		System.out.println(map);  // {aaa=20, bbb=tom@gmail.com}
		
	}
	
	static void testSet2() {
		TreeSet<String> set = new TreeSet<String>();
		set.add("aaa");
		set.add("aaa");
		set.add("ccc");
		set.add("bbb");
		
		System.out.println(set);
	}
	
	static void testSet1() {
		HashSet<String> set = new HashSet<String>();
		set.add("aaa");
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		
		set.remove("bbb");
		
		for(String string : set) {
			System.out.println(string);
		}
		System.out.println(set);
	}
	
	static void testList2() {
		LinkedList<String> c = new LinkedList<String>();
		c.add("tom");
		c.add("kite");
		c.add("rose");
		
		c.addFirst("first");
		c.addLast("last");
		
		c.remove("kite");
		
		c.set(1, "big tom");
		
		for (String string : c) {
			System.out.println(string);
		}

		
		System.out.println(c);
		
	}

	static void testList() {
		ArrayList<String> c = new ArrayList<String>();
		
		c.add("tom");
		c.add("kite");
		c.add("rose");
		
		System.out.println(c);
		
		c.remove(1);
		
		System.out.println(c);
		
		c.set(0, "big tom");
		System.out.println(c);
		
		for (String item : c) {
			System.out.println(item);
		}
		
	}
	
	public static void main(String[] args) {
		testList2();
//		testSet2();
//		testMap1();
	}
}


class Person{
	String pid;
	int age;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		return true;
	}
	
}