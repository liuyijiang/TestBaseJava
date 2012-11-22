package org.basejava.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * int占4个字节，byte是1个字节，每个字节8位。所以2进制的话，int最多可以表示正负一共2的32次方个数，byte则是2的8次方。
 * @author jim.liu
 *
 */
public class TestIo {

	//System.getProperty("user.dir")  File.separator
	public static final String PATH =System.getProperty("user.dir") + File.separator + "data";
	
	public void testFileInput() throws Exception{
		File file = new File(PATH+File.separator+"data.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int len;//读取到的实际字节数
		while((len = fis.read(buffer)) != -1 ){//-1到尾
			System.out.println(len);
		}
		System.out.print(new String(buffer));
//		for(int i=0;i<buffer.length;i++){
//			System.out.print(buffer[i]);
//		}
		
	}
	
	public void  testFileReaeder(){
		
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
	
	
	public void testDataInput() throws Exception{
		File file = new File(PATH+File.separator+"data.txt");
		FileInputStream fis = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fis);
		String str = null;
		StringBuffer sb = new StringBuffer();
//		while((str = dis.readLine()) != null){
//			sb.append(str);
//		}
		while((str = dis.readUTF()) != null){
			sb.append(str);
		}
		System.out.println(sb.toString());
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//String path = 
		//System.out.println( System.getProperty("user.dir"));
		//System.out.println(PATH);
		TestIo t = new TestIo();
		t.copypny();
		//String str = "程";
//		String str = "一";
//		System.out.println(str.getBytes().length);
		

	}

}
