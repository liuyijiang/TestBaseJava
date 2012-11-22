package org.basejava.nio.base.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestExecuto {

	//
	private ExecutorService executorService = null;
	private List<Future<String>> rlist = new ArrayList<Future<String>>();
	
	public void testExecute(){
		executorService = Executors.newFixedThreadPool(5);
		executorService.execute(new BaseThread());
		executorService.execute(new BaseThread());
		executorService.execute(new BaseThread());
		executorService.execute(new BaseThread());
		executorService.execute(new BaseThread());
		executorService.execute(new BaseThread());
	}
	
	public void testSubmit(){
		executorService = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			Future<String> future = executorService.submit(new TasWithResult(i));
			rlist.add(future);
		}
		executorService.shutdown();
		
		for(Future<String> f : rlist){
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
	}
	//
	
	public void testCallable(){
		BaseCallable b = new BaseCallable();
		try {
			Integer i = b.call();
			FutureTask<Integer> ft = new FutureTask<Integer>(b);
			new Thread(ft).start();
			System.out.println("sss");
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestExecuto t = new TestExecuto();
		//t.testExecute();
		t.testCallable();
	}

}
