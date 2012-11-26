package org.basejava.nio.httpserver.noblock.http;

import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Request {

	private static Charset chartset = Charset.forName("GBK");
	private static final String GET = "GET"; 
	private String version;
	private String action;
	private URL url;
	
	
	private Request(String action,String version,URL url){
		this.action = action;
		this.version = version;
		this.url = url;
	}
	
	public static boolean isComplete(ByteBuffer bb){
		ByteBuffer temp = bb.asReadOnlyBuffer();//？
		temp.flip();
		String data = chartset.decode(temp).toString();
		if(data.indexOf("\r\n\r\n") != -1){
			return true;
		}
		return false;
	}
	
	/**
	 * delete
	 */
	public static ByteBuffer deleteContent(ByteBuffer bb){
		ByteBuffer temp = bb.asReadOnlyBuffer();//？
		String data = chartset.decode(temp).toString();
		if(data.indexOf("\r\n\r\n") != -1){
			data = data.substring(0,data.indexOf("\r\n\r\n")+4);
			return chartset.encode(data);
		}
		return bb;
	}
	
	public static Request parse(ByteBuffer bb)throws Exception{
		bb = deleteContent(bb);
		CharBuffer cb = chartset.decode(bb);
		String ss = cb.toString();
		//return Request();
		return null;
	}
	
	
}
