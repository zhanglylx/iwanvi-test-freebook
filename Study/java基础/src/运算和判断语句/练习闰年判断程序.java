package 运算和判断语句;
import java.util.Scanner;
/**
 * 闰年判断公式：
 *1.年份能被4整除，且不能被100整除的是闰年
 *年份能被400整除的是闰年
 * 
 * @author Administrator
 *
 */
public class 练习闰年判断程序 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("请输入一个年份");
		Scanner scan=new Scanner(System.in);
		int year=scan.nextInt();
		System.out.println(((( year%4==0) && !(year %100 ==0))|| (year % 400 == 0)) ?year+"是闰年":year+"不是闰年");
		
	}

}
