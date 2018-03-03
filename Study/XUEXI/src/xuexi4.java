import java.util.Scanner;
public class xuexi4 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("请输入一个数字");
		Scanner scan=new Scanner(System.in);
		String shuzi1=scan.nextLine();
		int i=0;
		int b=5;
		do{
			if(xuexi4.xuexi(shuzi1)==false){			    
				System.out.println("您输入的不是数字，请再次输人一个数字");
				shuzi1=scan.nextLine();
				 i=1;
			}
			
			int a=Integer.parseInt(shuzi1);
			if (a==b){
				System.out.println("恭喜你猜对了");
				i=1;
			}else if(a>b){
				System.out.println("猜大了");
				i=2;
			}else if(a<b){
				System.out.println("猜小了");
				i=2;
			}
			if(i==2){
				System.out.println("请再次输人一个数字");
				shuzi1=scan.nextLine();
			}
		}while(i==2);

	}
	public static boolean xuexi(String str){
		char[] w=str.toCharArray();
		for (int v=0;v<w.length;v++){
			if (Character.isDigit(w[v])){
				
			}else{
				return false;
			}
		}
		return true;
	}

}
