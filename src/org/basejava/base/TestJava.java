package org.basejava.base;

public class TestJava {
   
	
	public static boolean foo(char c){
		System.out.print(c);
		return  true;
	}
	
	public static void test(String str){
		str = "wwwwwww";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        String str = "222222";
//        test(str);
//        System.out.print(str);
		//for 循环
		int i=0;
		for(foo('A');foo('B')&&(i < 2);foo('C')){
			i++;
			foo('D');
		}
		
//		for(int a=0;a<10;foo('B')){
//			a++;
//			System.out.println(a);
//		}
		for(;true;foo('B')){
			System.out.println("sss");
		}
		
	}

}
