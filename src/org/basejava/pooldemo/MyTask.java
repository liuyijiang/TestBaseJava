package org.basejava.pooldemo;

public class MyTask {

private String name;
	
	public MyTask(String name){
	  this.name = name;	
	}
	
	// ������һ����ʱ��ִ�еķ���
	public void exe(String threadname){
		try{
			System.out.println(threadname + "--->"+name +"-->start");
			Thread.sleep(100);
			System.out.println(threadname + "--->"+name +"-->end");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
