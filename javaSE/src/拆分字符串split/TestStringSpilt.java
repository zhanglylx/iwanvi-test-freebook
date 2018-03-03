package 拆分字符串split;

import java.util.Arrays;

/**
 * 测试拆分字符串
 * @author Administrator
 *
 */
public class TestStringSpilt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String info = "hello!world!java";
		String[] array = info.split("!");
		System.out.println(Arrays.toString(array));
		/**
		 * 对图片名重新定义，要保留图片原来的后缀
		 */
		String name = "me.jpg";
		String[] nameArray = name.split("\\.");
		String newName = "123."+nameArray[1];
		System.out.println(newName);
	}

}
