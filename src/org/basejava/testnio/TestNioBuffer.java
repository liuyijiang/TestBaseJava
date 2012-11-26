package org.basejava.testnio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
/**
 * capacity() ：表明缓冲区的容量大小, 一旦确定了大小, 将不能再改变;
   limit() ：告诉您到目前为止已经往缓冲区填了多少字节，或者让您用 :limit(int newLimit) 来改变这个限制
    position() ：告诉您当前的位置，以执行下一个读／写操作
    mark() ：为了稍后用 reset() 进行重新设置而记住某个位置
   flip() ：交换限制指针和位置指针，然后将位置置为 0，并废弃已经做的mark标记
 * @author jim.liu
 *
 */
public class TestNioBuffer {
   
	public void testbytebuffer(){
//		ByteBuffer bb = ByteBuffer.allocate(100);
//		bb.put("liuyijiang".getBytes());
//		bb.flip();
//		System.out.println(bb);
		//bb.p
		
		CharBuffer c = CharBuffer.allocate(100);
		System.out.println(c.position());
		c.put("liuyijiang");
		System.out.println(c.position());
		//c.flip();
		System.out.println(c.toString());
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNioBuffer t = new TestNioBuffer();
		t.testbytebuffer();
	}

}
