package org.basejava.nio.httpserver;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  io h
 * @author jim.liu
 *
 */
public class HttpServerIO {
    
	private ServerSocket ss = null;
	public static final String PATH =System.getProperty("user.dir") + File.separator + "webRoot" + File.separator;
	public void server(){
		System.out.println("start http");
		try{
			ss = new ServerSocket(8080);
			while(true){
			   Socket s = ss.accept();
			   InputStream in = s.getInputStream();
			   byte[] b = new byte[10240];
			   StringBuffer sb = new StringBuffer();
			   in.read(b);
			   sb.append(new String(b));
			   String url = sb.substring(0,sb.indexOf("\r\n"));//第一行
			   String method = url.substring(0,url.indexOf(" "));//第一个空格
			   System.out.println(method);
			   String rellUrl = url.substring(url.indexOf(" "),url.lastIndexOf(" "));
			   String file = rellUrl.substring(rellUrl.lastIndexOf("/")+1,rellUrl.length());
			System.out.println(rellUrl);
			   System.out.println(file);
				FileInputStream fis = new FileInputStream(new File(PATH+file));
				//FileOutputStream dos = new FileOutputStream(file2);
				byte[] buffer = new byte[1024];
				int len;//读取到的实际字节数
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				while((len = fis.read(buffer)) != -1 ){//-1到尾
					//System.out.println(len);
					//dos.write(buffer);
					s.getOutputStream().write(buffer);
				}
				//pw.write(new String(buffer));
				String str = new String(buffer);
				//s.getOutputStream().write(buffer);
				pw.write(str.trim());
				System.out.print(str);
			   
			   
			
			//pw.write("404 page not find");
//			pw.flush();
//			pw.close();
				s.close();
			   //in.close();
			// System.out.println(sb.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void copypny() throws Exception{
		File file = new File(PATH+File.separator+"bug.png");
		FileInputStream fis = new FileInputStream(file);
		File file2 = new File(PATH+File.separator+"bug1.png");
		FileOutputStream dos = new FileOutputStream(file2);
		byte[] buffer = new byte[1024];
		int len;//读取到的实际字节数
		while((len = fis.read(buffer)) != -1 ){//-1到尾
			//System.out.println(len);
			dos.write(buffer);
		}
		System.out.print("ok");
	}
	
	
	public static void main(String[] args) {
		HttpServerIO h = new HttpServerIO();
		h.server();
	}
	
}
