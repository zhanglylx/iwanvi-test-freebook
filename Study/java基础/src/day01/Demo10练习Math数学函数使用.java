package day01;

import java.util.Scanner; 

public class Demo10练习Math数学函数使用 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
	//	//Math:数学，Math类中提供了常见数学函数
	//	double d = Math.sqrt(2);
		//System.out.println(d);
		System.out.println("输入位移:");
		double s = console.nextDouble();
		double t;
		double g=9.8;
		double n=2*s/g;
		t=Math.sqrt(n);
		System.out.println(t);
	}

}
