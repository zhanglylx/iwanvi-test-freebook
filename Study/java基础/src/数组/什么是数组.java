package 数组;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 什么是数组：相同数据类型的元素组成的集合
 * 声明数组
 * 创建数组
 *
 */
public class 什么是数组 {

	public static void main(String[] args) {
		//声明和创建数组
		Scanner console = new Scanner(System.in);
		String[] aa=new String[1];
		aa[0] = console.nextLine();
		System.out.println(aa[0]);
		int[] ary;//声明数组变量ary
		ary = new int[3];//创建数组对象，简称创建数组
		//ary=数组对象：表示ary的值引用了数组对象
		//ary 是引用变量，引用了一个数组对象new int[10]
		//旺财是代词引用了一个狗东西，旺财是狗的专有代词
		int[] ary2 = ary;//是引用的赋值，赋值结果ary2 和 ary
		//引用了用一个数组对象
		//邻居叫我的旺财是畜生，畜生=旺财:结果畜生和旺财引用了同一个狗东西
		ary[0]=3;
		System.out.println(ary2[0]);//3
		//数组元素的自动初始化：创建数组时候数组元素是自动初始化的
		//初始化为0值 0 0.0 false \u0000 编码为0的字符，是控制字符
		int[] ary3 = new int[3];//元素自动初始化为0
		System.out.println(ary3[0]);
		
		double[] ary4 = new double[3];
		System.out.println(ary4[0]);
		
		boolean[] ary5 = new boolean[3];
		System.out.println(ary5[0]);
		
		char[] ary6 = new char[3];
		System.out.println(ary6[0]); //控制字符\u0000 显示无效果
		System.out.println((int)ary6[0]);//0
		
		String[] ary7=new String[3];
		System.out.println(ary7[0]);
		
	    //创建数组时候直接初始化元素
		int[] ary8 = new int[]{2,4,4,};
		System.out.println(ary7[0]);//2
		//简化版初始化数组元素只能用在声明变量的时候
		int[] ary9 = {2,3,4};
		//ary8 = {4,5,6}//编译错误
		ary9 = new int[]{4,5,6};
		//{0,0,0} ,new int[]{0,0,0}和 new int[3]
		//如上3中数组是，没有任何差别的！
		//根据实际业务需要，那种方面用哪个
		//如：创建10000个元素的数组，用new int[10000]
		//如果已经知道有具体元素了，用{3,4,5}或者new int[]{3,4,5}
	}

}
