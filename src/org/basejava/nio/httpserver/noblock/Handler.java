package org.basejava.nio.httpserver.noblock;

import java.nio.channels.SelectionKey;

public interface Handler {
   
	public void handle(SelectionKey key) throws Exception;
	
}
