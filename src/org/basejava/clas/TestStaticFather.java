package org.basejava.clas;

public class TestStaticFather {
   
	public static int one = 1;
	public static final int two = 2;
	
	static{
		System.out.println("Father");
	}
	
	protected int method1(int a, int b) { 
		return 0; 
    }
	
	
	
}
