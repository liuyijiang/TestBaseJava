package org.basejava.nio.httpserver;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;


/**
 * 一个基于nio 非阻塞socket的http servlet
 * @author jim.liu
 *
 */
public class HttpServer {
  
	private static final int POINT = 8080;
	private static final String IP = "192.168.56.1";
	
	private Charset charset = Charset.forName("GBK");
	private ServerSocketChannel ssc = null;//
	private Selector sel = null;//
	
	/**
	 * 
	 */
	public HttpServer() throws Exception{
			sel = Selector.open();//
		    ssc = ServerSocketChannel.open();//
		    ssc.configureBlocking(false);//
		    ssc.socket().bind(new InetSocketAddress(IP,POINT));//
	}
	
	/**
	 * 
	 */
	public void start() throws Exception{
		ssc.register(sel, SelectionKey.OP_ACCEPT);//
		System.out.println("http server 启动");
		while(sel.select() > 0){
			Set<SelectionKey> set = sel.selectedKeys();//
			Iterator<SelectionKey> it = set.iterator();
			while(it.hasNext()){
				SelectionKey key = it.next();
				it.remove();
				if(key.isAcceptable()){//
					accept(key);
				}else if(key.isReadable()){
					read(key);
				}else if(key.isWritable()){
					writer(key);
				}
				
			}
			
		}
		
	}
	
	/**
	 * 
	 * @param key
	 */
	private void accept(SelectionKey key) throws Exception{
		ServerSocketChannel ssc = (ServerSocketChannel)key.channel();//
		SocketChannel sc = (SocketChannel)ssc.accept();//
		System.out.println("客户端IP链接上："+sc.socket().getInetAddress());
		ByteBuffer bf = ByteBuffer.allocate(1024);//
		sc.configureBlocking(false);
		sc.register(sel, SelectionKey.OP_READ|SelectionKey.OP_WRITE, bf);
	}
	
	/**
	 * 
	 * @param key
	 */
	private void read(SelectionKey key) throws Exception{
		ByteBuffer bf  = (ByteBuffer)key.attachment();//返回保存的bytebuffer缓冲
		SocketChannel sc = (SocketChannel)key.channel();
		ByteBuffer readBuff = ByteBuffer.allocate(32);//生成新的一个buffer
		sc.read(readBuff);//读
		readBuff.flip();
		
		bf.limit(bf.capacity());//为啥要把极限设为容量
		bf.put(readBuff);
	}
	
	//bytetostring
	public String decode(ByteBuffer buffer){
		CharBuffer cb = charset.decode(buffer);
		return cb.toString();
	}
	
	public ByteBuffer encode(String str){
		return charset.encode(str);
	}
	
	
	/**
	 * 
	 */
	private void writer(SelectionKey key)throws Exception{
		ByteBuffer bf  = (ByteBuffer)key.attachment();
		SocketChannel sc = (SocketChannel)ssc.accept();//
		bf.flip();
		String url = decode(bf);
		System.out.println(url);
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			HttpServer h = new HttpServer();
			h.start();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
