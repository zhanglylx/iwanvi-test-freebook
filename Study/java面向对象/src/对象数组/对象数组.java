package 对象数组;

import java.util.Arrays;

/**
 * 对象数组:元素是对象(元素是对象的引用)的数组
 */
public class 对象数组 {

	public static void main(String[] args) {
		Point[] ary;//声明了数组变量ary
		ary = new Point[3];//创建了数组对象new Point[3]
		//new Point[3]实际情况:{null,null,null}
		//数组元素自动初始化为null，并不创建元素对象！
		System.out.println(ary[1]);//null
		ary[0] = new Point(3,4);
		ary[1] = new Point(5,6);
		ary[2] = new Point(1,2);
		System.out.println(ary[1]);//调用了对象的toString()
		System.out.println(ary[1].toString());
		System.out.println(Arrays.toString(ary));
		//另一种写法
		ary = new Point[]{new Point(1,2),new Point(6,7)};
		//静态初始化
		Point[] ary2 = {new Point(1,2),new Point(6,7)};
		System.out.println(Arrays.toString(ary));
		System.out.println(Arrays.toString(ary2));
	}

}
