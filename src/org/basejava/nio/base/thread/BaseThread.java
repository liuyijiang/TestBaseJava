package org.basejava.nio.base.thread;

public class BaseThread extends Thread{
	
	@Override
	public void run(){
		try{
			System.out.println(Thread.currentThread().getName() + "start");
			Thread.sleep((int)(Math.random() * 5000));
			System.out.println(Thread.currentThread().getName() + "end");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
