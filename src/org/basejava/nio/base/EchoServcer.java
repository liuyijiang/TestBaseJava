package org.basejava.nio.base;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ino 阻塞的server
 * 
 * @author jim.liu
 * 
 */
public class EchoServcer {

	private int port = 8080;
	private ServerSocketChannel serverSocketChannel = null;
	private ExecutorService executorService = null;
	private static final int POOL_MULTIPLE = 4;

	public EchoServcer() throws Exception {
		//创建线程池  ExecutorService Executors
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
				.availableProcessors() * POOL_MULTIPLE);
		//创建serverSocketChannel对象
		serverSocketChannel = ServerSocketChannel.open();
		//使得在同一个主机上关闭了服务器程序，再启动服务器程序时， 可以顺利绑定相同的端口
		serverSocketChannel.socket().setReuseAddress(true);
		//服务器与本地端口绑定
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		System.out.println("start");
	}
    
	public void service(){
		while(true){
			SocketChannel soketChannel = null;
			try{
				soketChannel = serverSocketChannel.accept();
				executorService.execute(new Handler(soketChannel));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
        new EchoServcer().service();
	}

}
