package org.basejava.clas;

public class TestStaticChild extends TestStaticFather{
   
	public static int one = 11;
	public static final int two = 21;
	
	static{
		System.out.println("Child");
	}
	
}
