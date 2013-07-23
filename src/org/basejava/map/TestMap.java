package org.basejava.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

//import org.junit.Ignore;
//import org.junit.Test;

public class TestMap {
   
//	@Test
//	@Ignore
	public void testMap(){
		SortedMap<Integer,String> sm = new TreeMap<Integer, String>();//treemap 是有序的
	       // Map<Integer,String> mp = new TreeMap<Integer, String>();
        sm.put(new Integer(2), "Two");
        sm.put(new Integer(1), "One");
        sm.put(new Integer(4), "Four");
        sm.put(new Integer(3), "Three");
        sm.put(new Integer(5), "Five");
        
        sm.put(new Integer(2), "Two");
        
        //sm.
        //sm.t
        
        Set set = sm.entrySet();
        
        Iterator i=set.iterator();
        while(i.hasNext()){
        	System.out.println(i.next().toString());
        }
	}
	
	//测试遍历map
//	@Test 
	public void testIterMap(){
		//SortedMap<Integer,String> sm = new TreeMap<Integer, String>();//treemap 是有序的
	     Map<Integer,String> sm = new HashMap<Integer, String>();
	     sm.put(new Integer(2), "Two");
	     sm.put(new Integer(6), "6");
	     sm.put(new Integer(1), "One");
	     sm.put(new Integer(4), "Four");
	     sm.put(new Integer(3), "Three");
	     sm.put(new Integer(5), "Five");
	     
	     Iterator i= sm.entrySet().iterator();
	     while(i.hasNext()){
	    	 Map.Entry<Integer,String> e = (Map.Entry<Integer,String>) i.next();
	    	 System.out.println(e);
	     }
	     
	}
	
	
	//public void LinkedHashMap//
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "p22@xt.com";
		String host = str.substring(str.indexOf("@")+1,str.lastIndexOf("."));
		System.out.println(host);

	}

}
