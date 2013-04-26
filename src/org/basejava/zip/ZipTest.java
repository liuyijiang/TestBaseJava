package org.basejava.zip;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;


public class ZipTest {
	
	private File zipFile;  
	  
    public ZipTest(String pathName) {  
        zipFile = new File(pathName);  
    }  
      
    public static void main(String[] args) {  
    	ZipTest zc = new  ZipTest("E:\\test.pdf");  
        zc.compress("E:\\test.zip");  
    }  
    
    public void compress(String srcPathName) {  
        File srcdir = new File(srcPathName);  
        if (!srcdir.exists())  
            throw new RuntimeException(srcPathName + "不存在！");  
          
        Project prj = new Project();  
        Zip zip = new Zip();  
        zip.setProject(prj);  
        zip.setDestFile(zipFile);  
        FileSet fileSet = new FileSet();  
        fileSet.setProject(prj);  
        fileSet.setDir(srcdir);  
        //fileSet.setIncludes("**/*.java"); 包括哪些文件或文件夹 eg:zip.setIncludes("*.java");  
        //fileSet.setExcludes(...); 排除哪些文件或文件夹  
        zip.addFileset(fileSet);  
          
        zip.execute();  
    }  
	
}
