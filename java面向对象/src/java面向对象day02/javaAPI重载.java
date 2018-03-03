package java面向对象day02;

import java.util.Arrays;

/*
 * java API 中的重载方式
 */
public class javaAPI重载 {
	public  static void main(String[] args){
		//Arrays.sort() 是重载的方法
		int[] ary = {3,7,1,7,8,9};
		Arrays.sort(ary);//int[]
		String [] names={"aaa","bbb"};
		Arrays.sort(names);//StringText[]
		
		int[] ary1 = {'A','B','C'};
		char [] ary2 = {'A','B','C'};
		System.out.println(ary1);//println(object)
		System.out.println(ary2);//pinrtln(char[])
	}
}
