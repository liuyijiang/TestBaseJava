package org.basejava.nio.base.thread;

import java.util.concurrent.Callable;

public class BaseCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Integer id = 0;
		try{
		  id = (int)(Math.random() * 5000);
		  Thread.sleep(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
  
	
	

}
