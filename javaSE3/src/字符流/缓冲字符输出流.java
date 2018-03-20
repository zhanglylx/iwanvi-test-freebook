package 字符流;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * 高级流
 * 可以以行为单位写字符
 * @author Administrator
 *
 */
public class 缓冲字符输出流 {

	public static void main(String[] args) throws IOException {
		//创建用户写文件的输出流
		FileOutputStream fos = 
				new FileOutputStream("buffered.txt");
		OutputStreamWriter osw = 
				new OutputStreamWriter(fos,"utf-8");
		/**
		 * BufferedWriter的构造方法中不支持给定一个字节输出流
		 * 只能给定一个字符输出流Writer的子类
		 * Writer:字符输出流的父类
		 */
		BufferedWriter writer = new BufferedWriter(osw);
		
		writer.write("你好呀！");
		writer.newLine();//输出一个换行
		writer.write("我是第二行！");
		writer.newLine();
		writer.write("我是第三行！");
		writer.flush();
		writer.close();
		selectedFile();
	}
	public static void selectedFile(){
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("cmd /c explorer  " + System.getProperty("user.dir"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 打开转换完成目录
	}
}
