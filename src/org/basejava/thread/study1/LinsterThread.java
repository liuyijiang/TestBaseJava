package org.basejava.thread.study1;

public class LinsterThread extends Thread{
	
	private SimpleThread thread;
	
	public LinsterThread(SimpleThread thread){
		this.thread = thread;
	}
	
	@Override
	public void run() {
		try{
			while(true){
				if(thread.isAlive()){
					System.out.println("SimpleThread is alive");
				}else{
					System.out.println("SimpleThread is dead");
				}
				Thread.sleep(500);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
