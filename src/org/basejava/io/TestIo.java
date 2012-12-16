package org.basejava.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
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
		t.testFast();
		//String str = "程";
//		String str = "一";
//		System.out.println(str.getBytes().length);
		

	}
	
	
	public void testFast() throws Exception{
		 String classPath = new File(TestIo.class.getResource("/").getFile()).getCanonicalPath();  
	        String configFilePath = classPath + File.separator + "fdfs_client.conf";  
	        System.out.println("配置文件:" + configFilePath);  
	          
	        ClientGlobal.init(configFilePath);  
	          
	       
	          
//	      byte[] file_buff = "F:\\pic.jpg".getBytes(ClientGlobal.g_charset);  
	        File file = new File(PATH+File.separator+"bug.png");  
	        FileInputStream fis = new FileInputStream(file);  
	        byte[] file_buff = null;  
	        if(fis != null){  
	            int len = fis.available();  
	            file_buff = new byte[len];  
	            fis.read(file_buff);  
	        }  
	        System.out.println("file length: " + file_buff.length);  
	          
	        String fileId = "";
	        //建立连接  
	        TrackerClient tracker = new TrackerClient();  
	        TrackerServer trackerServer = tracker.getConnection();  
	        StorageServer storageServer = null;  
	        StorageClient1 client = new StorageClient1(trackerServer, storageServer);  
	      
	      
	        //设置元信息  
	        NameValuePair[] metaList = new NameValuePair[3];  
	        metaList[0] = new NameValuePair("fileName", "ss");  
	        metaList[1] = new NameValuePair("fileExtName", "dsa");  
	        metaList[2] = new NameValuePair("fileLength", String.valueOf("3333"));  
	      
	      
	        //上传文件  
	        try {  
	            fileId = client.upload_file1(file_buff, "sasa", metaList);  
	        } catch (Exception e) {  
	            e.printStackTrace();
	        }  
	        trackerServer.close();  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
