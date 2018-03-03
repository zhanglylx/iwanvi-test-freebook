package 字节流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * FileOutputStream
 * write(int d):写int值的第8位
 * write(byte[] d):将d数组中所有字节写出
 * write(byte[] d,int offset,int length):将d数组中offset位置开始写length个字节
 * @author Administrator
 *
 */
public class 测试文件输出流 {

	public static void main(String[] args) throws IOException {
		File file = new File("out.dat");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		FileOutputStream fos = new FileOutputStream(file);
		/**
		 * FileOutputStream(File file,boolean append)
		 * FileOutputStream(String filePath,boolean append)
		 * append为true:会在当前文件末尾进行写操作
		 */
		FileOutputStream fos = new FileOutputStream(file,true);
		String info = "你好！输出流！";
		byte[] data = info.getBytes("UTF-8");
		fos.write(data);//将字符串转换的字节写出
		byte[] data1 =new byte[]{'\n'};
		fos.write(data1);
		fos.close();
	}

}
