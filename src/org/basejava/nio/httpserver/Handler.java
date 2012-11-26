package org.basejava.nio.httpserver;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Handler implements Runnable{
	
	public static final String PATH =System.getProperty("user.dir") + File.separator + "webRoot" + File.separator ;
	private SocketChannel sc;
	private Charset charset = Charset.forName("GBK");
	
	public Handler(SocketChannel sc){
		this.sc = sc;
	}
	
	public void handle(SocketChannel sc){
		try{
			ByteBuffer bf = ByteBuffer.allocate(1024);
			sc.read(bf);
			bf.flip();
			String request = charset.decode(bf).toString();
			System.out.println(request);
			//
			StringBuffer sb = new  StringBuffer("HTTP/1.1 200 OK \r\n");  //链接操作成功
			sb.append("Content-Type:text/html \r\n\r\n"); //返回类型 html
			sc.write(charset.encode(sb.toString()));
			String url = request.substring(0,request.indexOf("\r\n"));//第一行
			String rellUrl = url.substring(url.indexOf(" "),url.lastIndexOf(" "));
			String file = rellUrl.substring(rellUrl.lastIndexOf("/")+1,rellUrl.length());
			System.out.println(file);
			FileInputStream in = new FileInputStream(new File(PATH+file));
			FileChannel fco = in.getChannel();
			fco.transferTo(0, fco.size(), sc);//
			sc.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		handle(sc);
	}

}
