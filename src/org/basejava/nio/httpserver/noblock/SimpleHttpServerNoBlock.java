package org.basejava.nio.httpserver.noblock;

import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;

public class SimpleHttpServerNoBlock {
   
	private Selector sel = null;
	private ServerSocketChannel ssc = null;
	private int port = 8080;
	private Charset charset = Charset.forName("GBK");
	
	public SimpleHttpServerNoBlock() throws Exception{
		sel = Selector.open();
		ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.socket().setReuseAddress(true);
		ssc.socket().bind(new InetSocketAddress("192.168.56.1",port));
		System.out.println("start");	
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
