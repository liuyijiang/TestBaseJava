package org.basejava.nio.httpserver.noblock;

import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.basejava.nio.httpserver.noblock.tools.ChannelIO;

/**
 * 负责接收客户点解 tomcat连接器
 * @author jim.liu
 *
 */
public class AcceptHandler implements Handler{

	@Override
	public void handle(SelectionKey key) throws Exception {
		ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
		SocketChannel sc = (SocketChannel)ssc.accept();
		sc.configureBlocking(false);
		//sc.register(sel, ops)
		ChannelIO cio = new ChannelIO(sc,false);
		
	}

}
