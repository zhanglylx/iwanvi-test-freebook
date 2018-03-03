package 循环;
import java.util.Scanner;
public class do_while循环输入规则检验 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		char c;
		String str;
		do{
			System.out.println("输入一个数：");
			str = console.nextLine();
			c = str.charAt(0);
			System.out.println(c);
		}while(c<'0' || c>'9');
		System.out.println(c);
		//int n = Integer.parseInt(str);//将'56'转换为 int 56

	}

}
