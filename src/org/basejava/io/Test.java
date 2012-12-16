package org.basejava.io;

import java.io.File;
import java.io.FileInputStream;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class Test {

	public static final String PATH =System.getProperty("user.dir") + File.separator + "data";
	
	 public static void main(String args[]) throws Exception
	  {
//	  	if (args.length < 2)
//	  	{
//	  		System.out.println("Error: Must have 2 parameters, one is config filename, "
//	  		                 + "the other is the local filename to upload");
//	  		return;
//	  	}
	  	
	  	System.out.println("java.version=" + System.getProperty("java.version"));
	  	String classPath = new File(TestIo.class.getResource("/").getFile()).getCanonicalPath();  
	        String configFilePath = classPath + File.separator + "fdfs_client.conf";   
	  	String conf_filename = configFilePath;
	  	String local_filename = PATH+File.separator+"111.jpg";
	  	
	    File file = new File(local_filename);  
        FileInputStream fis = new FileInputStream(file);  
	    byte[] file_buff = null;  
        if(fis != null){  
            int len = fis.available();  
            file_buff = new byte[len];  
            fis.read(file_buff);  
        }  
	  	
	  	try
	  	{
	  		ClientGlobal.init(conf_filename);
	  		System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
	  		System.out.println("charset=" + ClientGlobal.g_charset);
	 
	        TrackerClient tracker = new TrackerClient();
	        TrackerServer trackerServer = tracker.getConnection();
	        StorageServer storageServer = null;
	        StorageClient1 client = new StorageClient1(trackerServer, storageServer);

	        NameValuePair[] metaList = new NameValuePair[1];
	        metaList[0] = new NameValuePair("fileName", local_filename);
	        String fileId = client.upload_file1(file_buff, "jpg", metaList);
	        System.out.println("upload success. file id is: " + fileId);

	        
	       // client.delete_file1("group1/M00/00/00/wKgBZ1DNxsKF25uAAAA0O5LKyXE250.jpg");
	      //  client.
	        
	  		trackerServer.close();
	  	}
	  	catch(Exception ex)
	  	{
	  		ex.printStackTrace();
	  	}
	  }
	
	
}
