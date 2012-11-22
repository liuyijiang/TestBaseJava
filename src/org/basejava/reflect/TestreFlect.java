package org.basejava.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestreFlect {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Class c = Class.forName("org.basejava.reflect.ReflectBase");//反射出一个类
		//ReflectBase
//		ReflectBase r = (ReflectBase)c.newInstance();
//		r.testp();
		
		Method mt = c.getMethod("testadd", new Class[]{int.class,int.class});//得到类中的方法，定义参数
		mt.invoke(c.newInstance(),10,12);//调用这个方法
		
		//
//		 Field[] field = c.getFields();
//		 for(int i=0;i<field.length;i++){
//			 System.out.println(field[i]);
//		 }
//		Method[] method = c.getMethods();
//		for(int i=0;i<method.length;i++){
//			System.out.println(method[i]);
//		}
		
		
		
		
	}

}
