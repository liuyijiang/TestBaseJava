package org.basejava.nio.base;

import java.net.ServerSocket;

public class BaseServer {
     
	public ServerSocket ss = null;
	
	public void start(){
		try{
			ss = new ServerSocket(3430);
			while(true){
			ss.accept();
			Thread.sleep(5000);
			System.out.println("finish");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseServer bs = new BaseServer();
		bs.start();
	}

}
