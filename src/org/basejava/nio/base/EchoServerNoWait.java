package org.basejava.nio.base;

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
 * 非阻塞的server
 * 
 * @author jim.liu
 * 
 */
public class EchoServerNoWait {

	private int port = 8080;
	private ServerSocketChannel serverSocketChannel = null;
	private Selector selector = null;
    private Charset charset = Charset.forName("GBK");
	
	// private ExecutorService executorService = null;
	// private static final int POOL_MULTIPLE = 4;

	public EchoServerNoWait() {
		try {
			selector = Selector.open();//Selector是用来控制注册事件的 serverSocketChannel
			serverSocketChannel = ServerSocketChannel.open();//
			serverSocketChannel.socket().setReuseAddress(true);//
			// 启动非阻塞模式
			serverSocketChannel.configureBlocking(false);//
			serverSocketChannel.socket().bind(new InetSocketAddress(8080));//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void service() throws Exception {
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//注册accept事件
		while (selector.select() > 0) {//是否有事件触发
			Set<SelectionKey> readyKey = selector.selectedKeys();//有事件了后就遍历事件
			Iterator<SelectionKey> it = readyKey.iterator();
			while (it.hasNext()) {
				SelectionKey key = null; //SelectionKey 用来跟踪注册事件的句柄
				try {
					key = (SelectionKey) it.next();
					it.remove();
					if (key.isAcceptable()) {//判断是什么事件  链接服务器
						ServerSocketChannel ssc = (ServerSocketChannel) key
								.channel();//得到 ServerSocketChannel
						SocketChannel sc = (SocketChannel) ssc.accept();//得到socket
						System.out.println("get clinet message"
								+ sc.socket().getInetAddress() + ":"
								+ sc.socket().getPort());
						sc.configureBlocking(false);//socket设为非阻塞
						ByteBuffer buffer = ByteBuffer.allocate(1024);//设置缓存
						sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE,buffer);//注册可读 可写事件
						
					}
					if (key.isReadable()) {//判断是什么事件 可读
						receive(key);
					}
					if (key.isWritable()) {//判断是什么事件 可写
                        send(key);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
     
	public String decode(ByteBuffer buffer){
		CharBuffer cb = charset.decode(buffer);
		return cb.toString();
	}
	
	public ByteBuffer encode(String str){
		return charset.encode(str);
	}
	
	public void send(SelectionKey key)throws Exception{
		ByteBuffer buffer = (ByteBuffer)key.attachment();
		SocketChannel sc = (SocketChannel)key.channel();//得到SocketChannel
		buffer.flip();
		String data = decode(buffer);
		if(data.indexOf("\r\n")==-1){
			return;
		}
		String outputDatea = data.substring(0,data.indexOf("\n")+1);
		System.out.println(outputDatea);
		ByteBuffer outputBuffer = encode("echo:"+ outputDatea);
		while(outputBuffer.hasRemaining()){
			sc.write(outputBuffer);
		}
		ByteBuffer temp = encode(outputDatea);
		buffer.position(temp.limit());
		buffer.compact();
//		key.cancel();
//		sc.close();
//		System.out.println("colse clinit");
		System.out.println("**********"+outputDatea);
		if("".equals(outputDatea.trim())){
			key.cancel();
			sc.close();
			System.out.println("colse clinit");
		}
	}
	
	public void receive(SelectionKey key)throws Exception{
		ByteBuffer buffer = (ByteBuffer)key.attachment();
		SocketChannel sc = (SocketChannel)key.channel();
		ByteBuffer readBuff = ByteBuffer.allocate(32);
		sc.read(readBuff);
		readBuff.flip();
		System.out.println("1:"+buffer.limit());
		buffer.limit(buffer.capacity());
		System.out.println("2:"+buffer.limit());
		buffer.put(readBuff);
	}
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		EchoServerNoWait e = new EchoServerNoWait();
		e.service();
	}

}
