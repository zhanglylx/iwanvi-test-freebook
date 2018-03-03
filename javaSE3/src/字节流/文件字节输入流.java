package 字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
		 * 文件字节输入流
		 * FileInputStream:用于读取文件内容的流
		 * @author Administrator
		 *
		 */
public class 文件字节输入流 {

	public static void main(String[] args) throws IOException {
		File file = new File("demo.dat");
		/**
		 * 根据文件创建用于读取其数据的文件输入流
		 */
		try {
			FileInputStream fis = 
					new FileInputStream(file);
			int b = 0;
			while((b = fis.read())!= -1){
				System.out.println(Integer.toHexString(b)+" ");
			}				
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
