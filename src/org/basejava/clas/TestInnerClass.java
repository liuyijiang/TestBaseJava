package org.basejava.clas;
//
public class TestInnerClass {
   
	public void someOuterMethod() {
		new Inner();
	}
	
	public class Inner{}
	
	public static void main(String[] args) {
		TestInnerClass tr = new TestInnerClass();
		tr.new Inner();
		//new TestInnerClass().new Inner();
	}
	
	
}
