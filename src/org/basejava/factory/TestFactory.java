package org.basejava.factory;

import java.lang.reflect.InvocationTargetException;


public class TestFactory {

	public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Object obj = new TestService();
		obj.getClass().getMethod("test",String.class).invoke(obj, "liuyijing");
	}
	
}
