package org.basejava.nio.httpserver.noblock;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

import org.basejava.nio.httpserver.noblock.http.Request;
import org.basejava.nio.httpserver.noblock.tools.ChannelIO;

public class RequestHander implements Handler{

	private ChannelIO cio;
	private ByteBuffer rbf = null;//http缓冲区
	private boolean requestReceived = false;//是否已接收到http所有数据库
	private Request request = null;
	
	
	@Override
	public void handle(SelectionKey key) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
