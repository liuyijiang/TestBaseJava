package org.basejava.testnio;

import java.nio.CharBuffer;

public class TestBuffer {
    
	
	public void testCharByte(){
		CharBuffer c = CharBuffer.allocate(100);
		System.out.println(c.position());
		System.out.println(c.limit());
		System.out.println(c.capacity());
		c.put("liuyijiang");
		System.out.println(c.position());
		System.out.println(c.limit());
		System.out.println(c.capacity());
		
		System.out.println(c.toString());
		c.flip();
		System.out.println(c.toString());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBuffer t = new TestBuffer();
		t.testCharByte();
	}

}
