package org.basejava.testnio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNIO {
    
	public static final String url = System.getProperty("user.dir") + File.separator + "data" + File.separator;
	
	/**
	 * 基本io
	 */
	public void baseIOCopy(String fileName) throws Exception{
		FileInputStream fis = new FileInputStream(new File(url+fileName));
		FileOutputStream fos = new FileOutputStream(new File(url+"copy1_"+fileName));
		byte[] buffer= new byte[10240];
		int len;
		while((len = fis.read(buffer)) != -1 ){//-1到尾
			fos.write(buffer);
		}
		fos.flush();
		fos.close();
		System.out.println("ok");
	}
	
	
	public void baseNIOCopy(String fileName) throws Exception{
		FileInputStream fis = new FileInputStream(new File(url+fileName));
		FileOutputStream fos = new FileOutputStream(new File(url+"copy1_"+fileName));
		
		
		FileChannel fcin = fis.getChannel(); 
        FileChannel fcout = fos.getChannel();  
        ByteBuffer buffer = ByteBuffer.allocate(1024);  
        while (true) {  
            // clear方法重设缓冲区，使它可以接受读入的数据  
            buffer.clear();  
            // 从输入通道中将数据读到缓冲区  
            int r = fcin.read(buffer);  
            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1  
            if (r == -1) {  
                break;  
            }  
            // flip方法让缓冲区可以将新读入的数据写入另一个通道  
            buffer.flip();  
            // 从输出通道中将数据写入缓冲区  
            fcout.write(buffer);  
        }  
		System.out.println("ok");
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		TestNIO t = new TestNIO();
		t.baseNIOCopy("data.txt");
	}

}
