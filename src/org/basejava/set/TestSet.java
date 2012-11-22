package org.basejava.set;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Set<String> set = new TreeSet<String>();
//        set.add("kkks");
//        set.add("kkks");
//        set.add("kkks2");
//        Iterator<String> it = set.iterator();
//        while(it.hasNext()){
//        	System.out.println(it.next());
//        }
		
		BigDecimal a  = new BigDecimal(0);
		BigDecimal b  = new BigDecimal(0.0);
		System.out.println(a.equals(b));
      // BigDecimal b = new BigDecimal(12.34567777888443);
       //BigDecimal b2 = new BigDecimal(b.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP);
       
       String str  = "123456788889~A111223234345";
       String st = str.substring(0,str.indexOf("~"));
       String ed = str.substring(str.indexOf("~")+1,str.length());
       System.out.println(st);
       System.out.println(ed);
      // System.out.println(b2);
//       b.set
//       b.setScale(2, BigDecimal.ROUND_HALF_UP);
//       //BigDecimal bs  = new BigDecimal(b);
//       System.out.println(b.doubleValue());
//       
//       BigDecimal mData = new BigDecimal("9.655").setScale(2, BigDecimal.ROUND_HALF_UP);
//       System.out.println("mData=" + mData);//mData=9.66
	}

}
