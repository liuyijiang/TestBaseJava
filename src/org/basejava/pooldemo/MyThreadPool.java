package org.basejava.pooldemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyThreadPool {

	private static MyThreadPool pool = new MyThreadPool();
	private List<MyThread> list = null;
	private int threadmax = 5;
	//Collections
	private MyThreadPool(){
		list = Collections.synchronizedList(new ArrayList<MyThread>());
		for (int i=0; i < threadmax; i++) {
			MyThread m = new MyThread("thread"+i);
			list.add(m);//加入池对象
		}
	}
	
	public void start(){
		for (MyThread m : list) {
			m.start();
		}
	}
	
	public void addTask(MyTask task){
		for (MyThread m : list) {
			if(!m.isHasTask()){
				m.setTask(task);
				break;
			}
		}
	}
	
	public static MyThreadPool getInstall(){
		return pool;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		MyThreadPool pool = MyThreadPool.getInstall();
		pool.start();
        Thread.sleep(1000);
        MyTask task1 = new MyTask("task1");
        MyTask task2 = new MyTask("task2");
        MyTask task3 = new MyTask("task3");
        pool.addTask(task1);
        pool.addTask(task2);
        pool.addTask(task3);
        Thread.sleep(1000);
        MyTask task4 = new MyTask("task4");
        MyTask task5 = new MyTask("task5");
        MyTask task6 = new MyTask("task6");
        pool.addTask(task5);
        pool.addTask(task4);
        pool.addTask(task6);
        Thread.sleep(1000);
        MyTask task7 = new MyTask("task7");
        MyTask task8 = new MyTask("task8");
        MyTask task9 = new MyTask("task9");
        pool.addTask(task7);
        pool.addTask(task8);
        pool.addTask(task9);
	}
	
}
