package org.basejava.reflect;

public class ReflectBase extends ReflectFather{

	public String name;
	private int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void testadd(int a,int b){
		System.out.println(a + b);
	}
	
	
	public void testp(){
		System.out.println("public method");
	}
	
	private void testpr(){
		System.out.println("private method");
	}
	
	protected void testpro(){
		System.out.println("protected method");
	}
	
	
}
