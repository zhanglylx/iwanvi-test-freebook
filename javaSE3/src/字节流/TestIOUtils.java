package 字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestIOUtils {

	public static void main(String[] args) {
			File file = new File("filewriter.txt");
			try {
//				//将文件数据读取出来
//				byte[] data = IOUtils.loadBytes(file);
//				
//				//输出文件内容
//				System.out.println(Arrays.toString(data));
//			
//				File des = new File("abc.dat");//该文件在磁盘上不存在
//				IOUtils.saveBytes(des, data);
//				FileOutputStream out = new FileOutputStream("o.txt");
//				IOUtils.saveString(" 大家好\r\n你好", out);
//				out.close();
//				FileInputStream fis = new FileInputStream("o.txt");
//				System.out.println(IOUtils.loadString(fis));
				IOUtils.copyFileTxt(file, new File("copyAppium.txt"));				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
