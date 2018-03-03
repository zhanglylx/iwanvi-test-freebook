package xuexi2;
import java.util.Scanner;
public class xuexi {
	public static void main(String[]args){
	Scanner scan=new Scanner(System.in);
	System.out.println("请输入一个数字");
    try {
		int a=scan.nextInt();
		boolean b=(a%2)==0;
		if (b==true){
			System.out.println("您输入的是偶数");
		}else {
			System.out.println("您输入的是奇数");
		}
			
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("您输入的不是整数，程序关闭");
	}
   
	
	
	}
}
