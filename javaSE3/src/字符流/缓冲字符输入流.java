package 字符流;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class 缓冲字符输入流 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src"+File.separator
				+"字符流"+File.separator+"缓冲字符输入流.java");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String msg = null;
		/**
		 * readLine()读取一行字符并以字符串形式返回
		 * 返回值中不带有换行符
		 * 若返回null,说明读取到了文件末尾
		 * EOF:end of file 文件末尾
		 */
		while((msg = br.readLine())!=null){
			System.out.println(msg);
		}
		br.close();
	}
}
