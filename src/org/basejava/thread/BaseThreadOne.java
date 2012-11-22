package org.basejava.thread;

public class BaseThreadOne implements Runnable {
    
	@Override
	public void run() {
		while(true){
			System.out.println("------run------");
			try{
			   Thread.sleep(2000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}
