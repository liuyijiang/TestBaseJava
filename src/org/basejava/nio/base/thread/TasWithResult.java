package org.basejava.nio.base.thread;

import java.util.Random;
import java.util.concurrent.Callable;
/**
 * Callable
 * @author jim.liu
 *
 */
public class TasWithResult implements Callable<String>{
   
	private int id;  
	  
    public TasWithResult(int id) {  
        this.id = id;  
    }  
  
    /** 
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。 
     *  
     * @return 
     * @throws Exception 
     */  
    public String call() throws Exception {  
        System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());  
        if (new Random().nextBoolean())  {
        	throw new Exception("Meet error in task");
        }
        // 一个模拟耗时的操作  
        for (int i = 999999999; i > 0; i--);  
        return "call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName();  
    }  
	
}
