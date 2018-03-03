package MB;
import java.util.Scanner;
public class calc {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		//82137751
		//34098833
		int a=1;
		int i=0;
		int b=0;
		while(true){			
			 b =console.nextInt();
			 i = i+b;
			 System.out.println("结果为:"+i);
			System.out.println("第:"+a+"遍");
			a++;
			if(i==0){
				break;
			}
		}

	}

}
