package org.basejava.collectiontest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestCollections t = new TestCollections();
		 t.testbinarySearch(2);
	}
	
	public void testbinarySearch(int str){
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(31);
		list.add(12);
		list.add(36);
		list.add(2);
		list.add(6);
		//Collections.f
		System.out.println(Collections.binarySearch(list, str));
	}
		

}
