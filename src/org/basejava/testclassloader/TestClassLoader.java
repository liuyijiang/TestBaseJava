package org.basejava.testclassloader;

import java.net.URL;

import sun.misc.Launcher;

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

}
