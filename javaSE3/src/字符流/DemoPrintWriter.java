package 字符流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 缓冲字符输出流
 * @author Administrator
 *
 */
public class DemoPrintWriter {

	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter("printwriter.txt");
		//向文件写入一个字符串
		writer.println("你好！");
		writer.println("你好！");//自动加换行符
		/**
		 * 我们要在确定做写操作的时候调用flush()方法
		 * 否则数据可能在输出流的缓冲区中，没有做真实写操作！
		 */
		writer.flush();
		writer.close();
		缓冲字符输出流.selectedFile();
	}

}
