package org.basejava.pooldemo;


public class MyThread extends Thread{

	private MyTask task;
	private boolean hasTask;
	private String name;
	
	public MyThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		synchronized (this) {
		try{
			System.out.println(name+"start");
			System.out.println(name+"wait");
			while(true){
				if(hasTask){
					System.out.println(name+":work");
					task.exe(name);
					hasTask = false;
				}else {
					this.wait();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	}

	public  void setTask(MyTask task) {
		synchronized(this){
		this.task = task;
		hasTask = true;
		this.notifyAll();
		}
	}

	public boolean isHasTask() {
		return hasTask;
	}


	
}

