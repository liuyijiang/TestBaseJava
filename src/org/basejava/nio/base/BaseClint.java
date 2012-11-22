package org.basejava.nio.base;

import java.net.Socket;

public class BaseClint {
  
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try{
    	   Socket s = new Socket("localhost",3430);
       }catch(Exception e){
    	   e.printStackTrace();
       }
	}

}
