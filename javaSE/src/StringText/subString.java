package StringText;

import java.util.Arrays;

public class subString {
	public static void main(String[] args){
		/**
		 * subString(int start,int end)
		 * 作用:
		 * 		截取字符串
		 * 		从start位置开始截取，截取到end位置
		 * 提示:
		 * 	java中很多方法在描述范围时都是包含"start"不包含"end"
		 * 
		 */
		String str = "HelloWorld";
		String sub = str.substring(0, 5);
		System.out.println(sub);
		
		
		/**
		 * subString的重载方法subString(int start)
		 * 从start开始截取到末尾
		 */
		String sub2 = str.substring(5);//等同于上面的截取
		System.out.println(sub2);
		
		/**
		 * 将字符串转换为相应的字节
		 * getBytes()
		 * 将字符串转换为字节数组并返回
		 * 
		 */
	
		
	}
}
