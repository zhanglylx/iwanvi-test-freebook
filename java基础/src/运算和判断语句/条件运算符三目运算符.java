package 运算和判断语句;
import java.util.Scanner;
/**
 * 3元运算
 * @author Administrator
 *
 */
public class 条件运算符三目运算符 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner console = new Scanner(System.in);
		System.out.println("输入用空格隔开的3个数:");
		int a =console.nextInt();
		int b =console.nextInt();
		//计算了ab中最大值
		//int max = a>b ? a : b;    //第一种写法
		int c =console.nextInt();
		//max = max > c ? max : c;  //第一种写法 
		int max =(a > b ? a : b)>c?(a>b?a:b):c;//第二种写法
		System.out.println("最大值是:"+max);
	}

}
