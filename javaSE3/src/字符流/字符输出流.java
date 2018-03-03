package 字符流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符输出流 Writer:字符输出流
 * 
 * OutputStreamWriter: 高级流，可以以字符为单位写数据
 * 
 *
 */
public class 字符输出流 {
	public static void main(String[] args) {
		/**
		 * 向文件中写入字符 步骤： 1:创建文件输出流(字节流) 2:创建字符输出流(高级流)，处理文件输出流 目的是我们可以以字节为单位写数据
		 * 3:写入字符 4:写完后关闭流
		 */
		FileOutputStream fos = null;
		OutputStreamWriter writer=null;
		try {
			fos = new FileOutputStream("writer.txt");
//			writer = new OutputStreamWriter(fos);
			//使用UTF-8作为编码集输出字符串
			writer = new OutputStreamWriter(fos,"UTF-8");
			writer.write("a！");
			writer.flush();//清空缓冲区
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(writer !=null){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
