package MB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.omg.CORBA.portable.InputStream;

public class zip {
	      
	    @SuppressWarnings( { })  
	    public static void main(String[] args) {  
	    	String zippath = "E:\\eclipse\\adb\\src\\MB\\bin.zip";
	    	String outfilepath = "D:\\zipfile\\ffmpeg\\bin\\";
	    	ZipContraMultiFile(zippath, outfilepath);
	    	/**
	    	zippath = "E:\\eclipse\\adb\\src\\MB\\examples.zip";
	    	 outfilepath = "D:\\zipfile\\ffmpeg\\doc\\examples";
	    	ZipContraMultiFile(zippath, outfilepath);
	    	 zippath = "E:\\eclipse\\adb\\src\\MB\\doc.zip";
	    	 outfilepath = "D:\\zipfile\ffmpeg\\doc";
	    	ZipContraMultiFile(zippath, outfilepath);
	    	 zippath = "E:\\eclipse\\adb\\src\\MB\\licenses.zip";
	    	 outfilepath = "D:\\zipfile\\ffmpeg\\licenses";
	    	ZipContraMultiFile(zippath, outfilepath); 	    	
	    	zippath = "E:\\eclipse\\adb\\src\\MB\\presets.zip";
	    	 outfilepath = "D:/zipfile\\ffmpeg\\presets";
	    	ZipContraMultiFile(zippath, outfilepath);
	    	zippath = "E:\\eclipse\\adb\\src\\MB\\ff.zip";
	    	 outfilepath = "D:\\zipfile\\ffmpeg";
	    	ZipContraMultiFile(zippath, outfilepath);
	    	**/
	    	}

	    	public static void ZipContraMultiFile(String zippath ,String outzippath){
	    		ZipInputStream zipInput = null;
	    		ZipFile zipFile = null;
	    		java.io.InputStream input = null;
	    		OutputStream output = null;
	    		try {
	    		File file = new File(zippath);
	    		File outFile = null;
	    		zipFile = new ZipFile(file);
	    		zipInput = new ZipInputStream(new FileInputStream(file));
	    		ZipEntry entry = null;
	    		while((entry = zipInput.getNextEntry()) != null){
	    		System.out.println("解压缩" + entry.getName() + "文件");
	    		outFile = new File(outzippath + File.separator + entry.getName());
	    		if(!outFile.getParentFile().exists()){
	    		outFile.getParentFile().mkdir();
	    		}
	    		if(!outFile.exists()){
	    		outFile.createNewFile();
	    		}
	    		input =  zipFile.getInputStream(entry);
	    		output = new FileOutputStream(outFile);
	    		int temp = 0;
	    		while((temp = input.read()) != -1){
	    		output.write(temp);
	    		}
	    		}
	    		} catch (Exception e) {
	    		e.printStackTrace();
	    		}finally{
	    		try {
	    		input.close();
	    		output.close();
	    		zipInput.close();
	    		zipFile.close();
	    		} catch (IOException e) {
	    		e.printStackTrace();
	    		}
	    		}
	    		}
	    		}
	    	
	    	

	     
	
	  

