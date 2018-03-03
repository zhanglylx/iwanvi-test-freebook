package 字符流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class 文件字符输入流FileReader {

	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("filewriter.txt");
//		int c = -1;
//		//以字符为单位读取文件
//		while((c = reader.read())!=-1){
//			System.out.println((char)c);
//		}
		//将文件字符输入流转换为缓冲字符输入流便可以以行为单位读取
		BufferedReader br = new BufferedReader(reader);
		String msg = null;
		while((msg = br.readLine())!=null){
			System.out.println(msg);
		}
		br.close();
	}

}
