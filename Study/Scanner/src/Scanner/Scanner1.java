package Scanner;              //声明包
import java.util.Scanner;    //引用扫描器

import org.omg.CORBA.PUBLIC_MEMBER;
public class Scanner1{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);  //创建扫面器scan
		System.out.println("请输入一个年份");
		int year=scan.nextInt();              //创建变量year接收输入的年份
		boolean booleanYear4=(year%4)==0;     //判断年份除以4是否为闰年
		boolean booleanYear100=(year%100)!=0; //判断年份除以100是否为闰年
		boolean booleanYear400=(year%400)==0; //判断年份除以400是否为闰年
		/*
		 * 使用条件判断语句判断是否为闰年
		 */
		
		if (booleanYear4==true & booleanYear100==true ){  
			System.out.println("这个是闰年");
		}else if (booleanYear400==true) {
			System.out.println("这个是闰年400");			
		}else if (booleanYear4==false | booleanYear100==false | booleanYear400==false){
			System.out.println("这个真的不是闰年");
		}
		/*
		 * 使用另一种条件判断语句判断是否为闰年
		 */
		if (((year%4)==0)&((year%100)!=0)|| ((year%400)==0)){
			System.out.println(year+"年是闰年");
		}else{
			System.out.println(year+"年不是闰年");			
		}
	
		/**
		 * 判断大小
		 */
		System.out.println("请输入两个数");
 		int intNum1=scan.nextInt();        //创建扫描器接收第一个数字
 		int intNum2=scan.nextInt();        //创建扫描器接收第二个数字
 		if (intNum1==intNum2){
 			//判断大小
 			System.out.println("这两个值相同");
 		}else{
 			System.out.println((intNum1>intNum2?intNum1+"这个数最大":intNum2
 					+ "这个数最大"));
 		}
 		
 		
	
	}
}