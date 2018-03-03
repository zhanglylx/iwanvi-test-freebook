package 字节流;
//自动导包快捷键:ctrl+shift+o
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 文件工具类
 * @author Administrator
 *
 */
public class IOUtils {
	
	/**
	 * 将文件写入src
	 * @param src
	 * @param data
	 * @throws IOException
	 */
	public static void saveBytes(File src,byte[] data)throws IOException{
		if(data==null){
			throw new IllegalArgumentException("data内容为空");
		}
		if(src == null){
			throw new IllegalArgumentException("文件为空！");
		}
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(src);
		fos.write(data);
		}catch(IOException e){
			throw e;
		}finally {
			if(fos!=null)fos.close();
		}
	}
	/**
	 * 将src复制到des
	 * @param src
	 * @param des
	 * @throws IOException
	 */
	public static void copyFile(File src,File des)throws IOException{
		if(src == null) throw new IllegalArgumentException("源文件不存在！");
		if(!src.exists())throw new  IllegalArgumentException("文件不存在");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
		 fis = new FileInputStream(src);
		byte[] data = new byte[fis.available()];
		fis.read(data);
		 fos = new FileOutputStream(des);
		fos.write(data);
		}catch (IOException e){
			throw e;
		}
		finally{
			if(fis!=null)fis.close();
			if(fos!=null)fos.close();		
		}
	}
	/**
	 * 使用缓冲流进行文件拷贝
	 * @param src
	 * @param des
	 * @throws IOException
	 */
	public static void copyFileBuffered(File src,File des)
										throws IOException{
		if(src == null){
			throw new IllegalArgumentException("源文件为空");
		}
		if(!src.exists()){
			throw new IllegalArgumentException("源文件不存在");
		}
		/**
		 * 创建缓冲流
		 * 
		 */
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(des));
			int data = -1;
			while((data = bis.read())!=-1){
				bos.write(data);
			}
			/*
			 * flush的作用是将缓冲区中未写出的数据一次性写出
			 */
			bos.flush();//数据都写完后应该flush
		}catch(IOException e){
			throw e;
		}finally {
			/**
			 * 通常情况下，我们只需要关闭最外成的流
			 */
			if(bis!=null)bis.close();
			if(bos!=null)bos.close();
		}
	}
	/**
	 * 使用缓冲字符输入输出流完成文本文件拷贝
	 * 缓冲字符输入流使用BufferedReader
	 * 缓冲字符输出流使用BufferedWriter或PrintWriter
	 * @param src
	 * @param des
	 */
	public static void copyFileTxt(File src,File des)throws IOException{
		if(src == null){
			throw new IllegalArgumentException("src为null");
		}
		if(!src.exists()){
			throw new IllegalArgumentException(src+"文件不存在");
		}
		BufferedReader br = null;
		BufferedWriter pw = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
			pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(des)));
			String msg = null;
			while((msg = br.readLine())!=null){		
				pw.write(msg);		
				pw.newLine();
			
			}			
			pw.flush();	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br != null) br.close();
			if(pw != null) pw.close();
		}
	}
	/**
	 * 读取给定的文件，并将数据已字节数组的形式返回
	 */
	public static byte[] loadBytes(File src)
								throws IOException{
		if(src == null) throw new IllegalArgumentException("文件为空！");
		if(!src.exists())throw new IllegalArgumentException(src+"不存在！");
		FileInputStream fis = null;//创建文件输入流
		try{
			fis = new FileInputStream(src);
//			byte[] data = new byte[(int)src.length()];
			/**
			 * FileInputStream的available()方法；
			 * 返回当前字节输入流可读取的总字节数
			 */
			byte[] data = new byte[fis.available()];
			fis.read(data);
			return data;
		
		
		}catch(IOException e){
			throw e;//读取出错误将异常抛给调用者解决
		}finally {
			if(fis!=null){
			fis.close();
			}
		}
									
	}
	/**
	 * 向给定的输出流中写字符串
	 * @param info
	 * @param in
	 * @throws IOException
	 */
	public static void saveString(String info,OutputStream in)
								throws IOException{
		if(info==null){
			throw new IllegalArgumentException("info为空");
		}
		if(in == null){
			throw new IllegalArgumentException("in为空");
		}
		/**
		 * 步骤：
		 * 1.创建DataOutputStream并处理参数out这个输出流
		 * 2.通过DOS直接将一个字符串写出
		 * 3:清空DOS的缓冲区，确保所有字符都写出
		 */
		//1 java.io.DataOutputStream
		DataOutputStream dos = new DataOutputStream(in);
		//2
		dos.writeUTF(info);//将字符串写出
		//3
		dos.flush();//将缓冲区中的数据写出
		
	}
	/**
	 * 从输入流中读取字符串
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static String loadString(InputStream in)
										throws IOException{
		if(in == null){
			throw new IllegalArgumentException("InputStream为空");
		} 
		DataInputStream dis = new  DataInputStream(in);
		
		return dis.readUTF();
	}
	
	
}
