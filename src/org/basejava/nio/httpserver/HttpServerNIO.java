package org.basejava.nio.httpserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;


public class HttpServerNIO {
   
	private ServerSocketChannel ssc = null;
	private Selector sel = null;
	private InetSocketAddress socketAddress = new InetSocketAddress("192.168.56.1",8080);
	private Charset charset = Charset.forName("GBK");
	public static final String PATH =System.getProperty("user.dir") + File.separator + "webRoot" + File.separator ;
	
	public HttpServerNIO() throws Exception{
		sel = Selector.open();
		ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.socket().setReuseAddress(true);//
		ssc.socket().bind(socketAddress);
	}
	
	public void server() throws Exception{
		ssc.register(sel, SelectionKey.OP_ACCEPT);
		while(sel.select() > 0){
			Iterator<SelectionKey> it = sel.selectedKeys().iterator();
			while(it.hasNext()){
				SelectionKey key = it.next();
				it.remove();
				if(key.isAcceptable()){
					ByteBuffer bb = ByteBuffer.allocate(1024);
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					sc.register(sel, SelectionKey.OP_READ|SelectionKey.OP_WRITE,bb);
				}
				if(key.isReadable()){
					SocketChannel sc = (SocketChannel)key.channel();
					ByteBuffer b = (ByteBuffer)key.attachment();
					ByteBuffer bs = ByteBuffer.allocate(100);
					sc.read(bs);
					bs.flip();//
					b.limit(b.capacity());//
					b.put(bs);
				}
				if(key.isWritable()){
					SocketChannel sc = (SocketChannel)key.channel();
					ByteBuffer b = (ByteBuffer)key.attachment();
					b.flip();
					CharBuffer cb = charset.decode(b);
					String str = cb.toString();
					if(str.indexOf("\r\n")!=-1){
						System.out.println(str);
						String head = str.substring(0,str.indexOf("\r\n"));
						String url = head.substring(head.indexOf(" "), head.lastIndexOf(" "));
						String file = url.substring(url.lastIndexOf("/")+1,url.length());
						 FileInputStream fin = new FileInputStream(new File(PATH+file));
						 FileOutputStream fout = new FileOutputStream(new File(PATH+"c1_"+file));  
					        // 获取输入输出通道  
					        FileChannel fcin = fin.getChannel();  
					       // FileChannel fcout = fout.getChannel();  
					        // 创建缓冲区  
					        ByteBuffer bu = ByteBuffer.allocate(1024);  
					        ByteBuffer pps = ByteBuffer.allocate(1024);  
					        while (true) {  
					            // clear方法重设缓冲区，使它可以接受读入的数据  
					            bu.clear();  
					            // 从输入通道中将数据读到缓冲区  
					            int r = fcin.read(bu);  
					            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1  
					            
					            // flip方法让缓冲区可以将新读入的数据写入另一个通道  
					            bu.flip();  
					            String strsss = charset.decode(bu).toString();
					            System.out.println(strsss);
					            pps.limit(pps.capacity());
					            pps.put(bu);
					            // 从输出通道中将数据写入缓冲区  
					            //fcout.write(buffer);  
					            //sc.write(buffer);
					            if (r == -1) {  
					                break;  
					            }  
					        }  
//						FileChannel fc = fos.getChannel();
//						ByteBuffer rb = ByteBuffer.allocate(1024); 
//						//fc.
//						while(true){
//							rb.clear();
//							if((fc.read(rb)) == -1){
//								break;
//							}
//							rb.flip();
//							String strs = charset.decode(rb).toString();
//							System.out.println(strs);
//							sc.write(rb);
//						}
					        String strs = charset.decode(pps).toString();
							System.out.println(strs);   
					     sc.write(pps);
					    //sc.write(charset.encode("ok1"));
						key.cancel();
						sc.close();
					}
				}
				
				
			}
			
		}
	}
	
	
	//public
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HttpServerNIO h;
		try {
			h = new HttpServerNIO();
			h.server();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
