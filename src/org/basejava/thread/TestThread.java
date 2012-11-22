package org.basejava.thread;

public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
//		int i = (int)(Math.random() * 100);
//		System.out.println(i);
		BaseThreadOne b = new BaseThreadOne();
		Thread t = new Thread(b);
		t.setPriority(Thread.MAX_PRIORITY);
		//t.is
		t.start();
		System.out.println("thread : " + t.isAlive());
        while(true){
        	int i = (int)(Math.random() * 100);
        	System.out.println(i);
        	if(i > 50){
        		t.join();
        		System.out.println("t thread is joined : " + t.isAlive());
        	}
        	
        }
	}

}
