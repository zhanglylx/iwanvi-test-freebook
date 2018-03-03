package StringText;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class getBytes {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String info = "我爱java";
		/**
		 * 以当前系统默认的字符串编码集转换为字节
		 * windows的默认编码集:GBK
		 * GBK:英文用1个字节描述，汉字用两个字节描述
		 */
		byte[] array = info.getBytes();
		System.out.println(Arrays.toString(array));
		/**
		 * getBytes()的重载方法，用于将字符串以指定的编码集转换字节数组
		 * getBytes(StringText charsetName)
		 * 
		 * 这个重载方法需要捕获异常，这里可能引发没有这个编码集的异常
		 * iso8859-1  欧洲常用的编码集
		 * gbk		国标
		 * gb2312	国标
		 * utf-8 最常用的。
		 * 
		 */
		byte[] utf = null;
		try {
			utf = info.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(utf));
		/**
		 * 编码:将数据已特定格式转换为字节
		 * 解码:将字节以特定格式转换为数据
		 */
		/**
		 * 构造方法，以特定的编码集翻译成特定格式的字符串
		 */
		String infoUTF = new String(utf,"UTF-8");
		System.out.println(infoUTF);
	}

}
