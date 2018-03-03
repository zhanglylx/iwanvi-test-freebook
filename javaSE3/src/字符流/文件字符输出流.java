package 字符流;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class 文件字符输出流 {

	public static void main(String[] args) throws IOException {
		/**
		 * 常用的两个构造方法
		 * FileWriter(File file)
		 * FileWriter(String filePath)
		 * 意思和FileOutputStream的两个同类参数的构造方法一致
		 * FileWriter的效果等同于
		 * FileOutputStream + OutputStreamWriter
		 * 
		 */
		FileWriter writer = new FileWriter("filewriter.txt");
		//第二种写法
		//		File file = new File("filewriter.txt");
		//		FileWriter writer = new FileWriter(file);
		writer.write("hello!FileWriter!");
		writer.flush();
		writer.close();
		缓冲字符输出流.selectedFile();				
		
	}

}
