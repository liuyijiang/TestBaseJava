package org.basejava.nio.httpserver;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 阻塞式http服务器
 * @author jim.liu
 *
 */
public class SimpleHttpServerBlock {
    
	private int port = 8080;
	private ServerSocketChannel ssc = null;
	private ExecutorService es = null;
	private static final int POOL = 4;
	
	public SimpleHttpServerBlock()throws Exception{
		es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * POOL);
		ssc = ServerSocketChannel.open();
		ssc.socket().setReuseAddress(true);
		ssc.socket().bind(new InetSocketAddress("192.168.56.1",port));
		System.out.println("start");
	}
	
	public void service(){
		while(true){
			SocketChannel sc = null;
			try{
				sc = ssc.accept();
				es.execute(new Handler(sc));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		SimpleHttpServerBlock s = new SimpleHttpServerBlock();
		s.service();
	}

}
