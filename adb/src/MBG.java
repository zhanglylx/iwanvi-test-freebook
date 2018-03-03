/**

import java.io.File;
import java.util.Scanner;    //导入扫描器
public class MBG {

 * 以下代码为输入MB大小。换算MB总和，以G的方式展现
 
	
	public static void main(StringText [] args){     //主方法
		Scanner scan=new Scanner(System.in);    //创建扫描器scan
		System.out.println("请输入MB:");
		
		File file=new File("E:\\eclipse\\MB+B\\ffmpeg\\bin\\aa.gif"); 
		
		System.out.println(file.exists());
		
		
		int a=1;
		int number2 = 0;
		do{
			StringText number=scan.nextLine();
			boolean numberString=MBG.lsNumber(number);
			if (numberString==false){							
				 break;
			}
			int number3=Integer.parseInt(number);
			
			if (a==1){
			    number2=number3;
			
			}else if (a==2) {
				
				number2=number2+number3;
			}else if (a>2){
				number2=number2+number3;
				
			}
			System.out.println("您的总MB为:"+number2);
			
			System.out.println("如果您想要结束，请输入结束");
			a++;
		}while(a>1);
		     System.out.println("程序结束，您的总MB为:"+number2);
	}

	private static boolean lsNumber(StringText scr) {
		char [] c=scr.toCharArray();   //将字符串分割为单个字符数组
		for (int i=0;i<c.length;i++){
			if(Character.isDigit(c[i])){ //Character.isDigit 方法检测字符是否为数字
				
			}else{
				return false;
			}
		// TODO 自动生成的方法存根
		
	}
		return true;
}
}

**/