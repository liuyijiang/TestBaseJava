package org.basejava.thread.study1;

public class SimpleThread extends Thread{

	@Override
	public void run() {
		try{
			for (int i=0;i<5;i++) {
				Thread.sleep(1000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
