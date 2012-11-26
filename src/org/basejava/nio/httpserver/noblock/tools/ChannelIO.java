package org.basejava.nio.httpserver.noblock.tools;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class ChannelIO {
   
	protected SocketChannel sc = null;
	protected ByteBuffer rebf = null;
	private static int reb = 4096;
	
	public ChannelIO(SocketChannel sc,boolean blocking) throws Exception{
		this.sc = sc;
		sc.configureBlocking(blocking);
		rebf = ByteBuffer.allocate(reb);
	}
	
	public SocketChannel getSocketChannel(){
		return sc;
	}
	
	/**
	 * 如果缓冲区剩余容量不多，就创建一个新的缓冲区 是原来的2倍
	 */
	protected void resizeRequestBuffer(int remaining){
		if(rebf.remaining() < remaining){//remaining what?
			ByteBuffer bb = ByteBuffer.allocate(rebf.capacity() * 2);
			rebf.flip();
			bb.put(rebf);
			rebf = bb;
		}
	}
	
	public int read()throws Exception{
		resizeRequestBuffer(reb/20);
		return sc.read(rebf);
	}
	
	public ByteBuffer getReadBuffer(){
		return rebf;
	}
	
	public int write(ByteBuffer src)throws Exception {
		return sc.write(src);
	}
	
	public long transferTO(FileChannel fc,long pos,long len)throws Exception{
		return fc.transferTo(pos, len, fc);
	}
	
	public void close()throws Exception{
		sc.close();
	}
	
}
