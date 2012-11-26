package org.basejava.nio.httpserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class BaiduReaderHttp {

	 private Charset charset = Charset.forName("GBK");// 创建GBK字符集  
	    private SocketChannel channel;  
	    
	    public void readHTMLContent() {  
	        try {  
	            InetSocketAddress socketAddress = new InetSocketAddress(  
	"www.baidu.com", 80);  
	//step1:打开连接  
	            channel = SocketChannel.open(socketAddress);  
	        //step2:发送请求，使用GBK编码  
	            channel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));  
	            //step3:读取数据  
	            ByteBuffer buffer = ByteBuffer.allocate(1024);// 创建1024字节的缓冲  
	            while (channel.read(buffer) != -1) {  
	                buffer.flip();// flip方法在读缓冲区字节操作之前调用。  
	                System.out.println(charset.decode(buffer));  
	                // 使用Charset.decode方法将字节转换为字符串  
	           buffer.clear();// 清空缓冲  
	            }  
	        } catch (IOException e) {  
	            System.err.println(e.toString());  
	        } finally {  
	            if (channel != null) {  
	                try {  
	                    channel.close();  
	                } catch (IOException e) {  
	                }  
	            }  
	        }  
	    }  
	    
	    
	    public void readHTMLContentWithBaseIO() {  
	        try {  
//	            InetSocketAddress socketAddress = new InetSocketAddress(  
//	"www.baidu.com", 80);  
	        	//InetAddress socketAddress =  new InetSocketAddress("www.baidu.com", 80);
	//step1:打开连接  
	            Socket s = new Socket("www.baidu.com",80);
	          
	            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	            //channel = SocketChannel.open(socketAddress);  
	        //step2:发送请求，使用GBK编码  
	            //channel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n")); 
	            dos.writeUTF("GET " + "/ HTTP/1.1" + "\r\n\r\n");
	            dos.flush();
	            DataInputStream dis = new DataInputStream(s.getInputStream());
	            //step3:读取数据  
	            //ByteBuffer buffer = ByteBuffer.allocate(1024);// 创建1024字节的缓冲  
	            byte[] b = new byte[1024];
	            int len = 0;
	            while((len = dis.read(b))!= -1){
	            	System.out.println(String.valueOf(b)); 
	            }
//	            while (channel.read(buffer) != -1) {  
//	                buffer.flip();// flip方法在读缓冲区字节操作之前调用。  
//	                System.out.println(charset.decode(buffer));  
//	                // 使用Charset.decode方法将字节转换为字符串  
//	           buffer.clear();// 清空缓冲  
//	            }  
	        } catch (IOException e) {  
	            System.err.println(e.toString());  
	        } finally {  
	            
	        }  
	    }  
	    
	    
	    
	    
	    public static void main(String[] args) {  
	        new BaiduReaderHttp().readHTMLContentWithBaseIO();  
	    }  

}
