package study1;
import java.util.Scanner;
public class study1{
	public static void main(String[]args){
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个值");
		int a=scan.nextInt();
		if ((a%2)==0){
			System.out.println("这是值是偶数");
		}else {
			System.out.println("这个值是奇数");
			}
		boolean b=(a%2)==0;
		String c=b?"偶数":"奇数";
		System.out.println("这个数是:"+c);
			
		}

		
	}

