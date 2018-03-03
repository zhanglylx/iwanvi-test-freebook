package 方法;

import java.util.Arrays;

/**
 *java 系统API  方法调用
 *Arrays 类，是数组的工具类，包含很多数组有关的工具方法
 *如:
 *  toString ()  连接数组元素为字符串
 *  equals ()比较两个数组序列是否相等 
 *  sort ()对数组排序，从小到大排序
 */
public class java系统API方法调用Arrays类 {
	public static boolean f(char[] a,char[] b){
		boolean f = Arrays.equals(a, b);
		return f;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{4,5,6,7};
		String str = Arrays.toString(arr);
		System.out.println(str);
		
		char[] answer=new char[]{'a','b','c','d'};//标准答案
		char[] one = {'a','b','d'};//学生甲的答案
		char[] other = {'a','b','c','d'};//学生乙的答案
		System.out.println(f(answer,other));
		System.out.println();
		
		arr = new int[]{1,4,5,7,90,0};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
