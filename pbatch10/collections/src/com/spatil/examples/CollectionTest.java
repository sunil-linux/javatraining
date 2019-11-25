package com.spatil.examples;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Student {

}

public class CollectionTest {

	public static void main(String[] args) {

		List list = new LinkedList();

		list.add(10);
		list.add(10.5);
		list.add("sunil");
		//list.add(new Student());
		
		System.out.println(list);
		
		list.remove("sunil");
		
		System.out.println(list);
		
		list.add(2, "Ganesh");
		System.out.println(list);
		
		System.out.println(list.contains(10));
		
		//list.clear();  //delete all elements from collection
		//System.out.println(list);

		Object element = list.get(2);
		System.out.println(element);
		
		
		System.out.println(list.indexOf("Satish"));
		
		List newList = list.subList(0, 2);
		System.out.println(newList);
		
		Object[]  arr = list.toArray();
		
		
		List list2 = new LinkedList();
		list2.add("anil");
		list2.add("raju");
		list2.add("arvind");
		
		
		Set set = new HashSet();
		set.add(100);
		set.add(200);
		
		
		//add one collection into another collection
		list.addAll(list2);
		
		list.add(set);
		
		
		System.out.println(list);

		list.removeAll(list2);
		System.out.println(list);

		
		
	}
}
