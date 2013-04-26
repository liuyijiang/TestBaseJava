package org.basejava.testclassloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class TestClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//	    System.out.println(System.getProperty("sun.boot.class.path"));  
//	    System.out.println("**************");
//		URL[] urls = Launcher.getBootstrapClassPath().getURLs();  
//		for (int i = 0; i < urls.length; i++) {  
//		    System.out.println(urls[i].toExternalForm());  
//		} 
		
	    ClassLoader loader = TestClassLoader.class.getClassLoader();    //获得加载ClassLoaderTest.class这个类的类加载器  
	    while(loader != null) {  
	        System.out.println(loader);  
	        loader = loader.getParent();    //获得父类加载器的引用  
	    }  
	    System.out.println(loader);  

	}

	
	public void test() throws Exception{
		ClassLoader loder = Thread.currentThread().getContextClassLoader();
		//①通过类装载器获取Car类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.baobaotao.reflect.Car");
		//②获取类的默认构造器对象并通过它实例化Car
		Constructor cons = clazz.getDeclaredConstructor((Class[])null);
		//Car car = (Car)cons.newInstance();
		//③通过反射方法设置属性
		Method setBrand = clazz.getMethod("setBrand",String.class);
		//setBrand.invoke(car,"红旗CA72");
		Method setColor = clazz.getMethod("setColor",String.class);
		//setColor.invoke(car,"黑色");
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed",int.class);
		//setMaxSpeed.invoke(car,200);
		//return car;
	}
	
	public void tesst() throws Exception{
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Class clazz = loader.loadClass("com.baobaotao.reflect.PrivateCar");
			PrivateCar pcar = (PrivateCar)clazz.newInstance();
			Field colorFld = clazz.getDeclaredField("color");
			//①取消Java语言访问检查以访问private变量
			colorFld.setAccessible(true);
			colorFld.set(pcar,"红色");
			Method driveMtd = clazz.getDeclaredMethod("drive",(Class[])null);
			//Method driveMtd = clazz.getDeclaredMethod("drive"); JDK5.0下使用
			//②取消Java语言访问检查以访问protected方法
			driveMtd.setAccessible(true);
			driveMtd.invoke(pcar,(Object[])null);
		
	}
	
	
}
