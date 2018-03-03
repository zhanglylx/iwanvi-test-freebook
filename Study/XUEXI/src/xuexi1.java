/*import java.util.Scanner;
public class xuexi1 {
	  static int a=1;
public static void main(String[]args){
   Scanner impo=new Scanner(System.in);
   System.out.println("请输入第一个值");
   int a=impo.nextInt();
   System.out.println("您输入的第一个值是"+(a));
   System.out.println("请输入第二个值");
   int b=impo.nextInt();
   System.out.print("您输入的第二个值是"+b);
   a=a^b;
   b=b^a;
   a=a^b;
   System.out.println("第一个值是："+a+"第二个值是："+b);
}
}*/
import java.util.Scanner;
public class xuexi1{
     static int ba=1;
	public static void main(String[] args){
		int ba=2;
		Scanner shuru=new Scanner(System.in);	
		System.out.println("请输入一个数字");
		float a=shuru.nextFloat();
		//int a1=(int)a;		
		boolean b=(a%2)==0;
		System.out.println(b);
		if (b==true) {
			System.out.println("值为偶数");
		}else{
			System.out.println("值为集束");
				
			
			
			
		}
	}

	private static float Cint(float a) {
		// TODO 自动生成的方法存根
		return 0;
	}
}

