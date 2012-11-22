package org.basejava.nio.base;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class Handler implements Runnable {
   
	private SocketChannel socketChannel;
	
	public Handler(SocketChannel socketChannel){
		this.socketChannel = socketChannel;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		handle(socketChannel);
	}
    
	public void handle(SocketChannel socketChannel){
		try{
			Socket socket = socketChannel.socket();
			System.out.println("get clint message from "+socket.getInetAddress()+":"+socket.getPort());
			BufferedReader br = getReader(socket);
			PrintWriter pw = getWriter(socket);
			String msg = null;
			while((msg = br.readLine())!=null){
				System.out.println(msg);
				pw.println("ehco"+msg);
				if(msg.equals("q")){
					break;
				}
			}
			socketChannel.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
	//InputStreamReader
	public BufferedReader getReader(Socket socket) throws Exception{
		InputStream in = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(in));
	}
	
	//PrintWriter
	public PrintWriter getWriter(Socket socket) throws Exception{
		OutputStream out = socket.getOutputStream();
		return new PrintWriter(out,true);
	}
}
