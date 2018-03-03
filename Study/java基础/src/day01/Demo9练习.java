package day01;

import java.util.Scanner;

/**
 * 计算自由落体运动中，物体的位移。
 *自由落体位移公式：
 *s=1/2*G*T2
 *S---位移(M)
 *t---时间(s)
 *g---重力加速度(9.8m/s);
 *
 */
public class Demo9练习 {
	public static void main (String[] args){
		Scanner console = new Scanner(System.in);
		System.out.println("输入时间：");	
		double t=console.nextDouble();
		double g=9.8;
		double s;
		s=g*(t*t)/2;
		System.out.println(s);
	}
}
