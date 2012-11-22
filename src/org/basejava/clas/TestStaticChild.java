package org.basejava.clas;

public class TestStaticChild extends TestStaticFather{
   
	public static int one = 11;
	public static final int two = 21;
	
	static{
		System.out.println("Child");
	}
	
	protected int method1(int a, int b,int d) { 
		return 0; 
    }
//	public int method1(int a, int b) { return 0; }
//	private int method1(int a, int b) { return 0; }
//	private int method1(int a, long b) { return 0; }
//	public short method1(int a, int b) { return 0; }
//	static protected int method1(int a, int b) { return 0; }
}
