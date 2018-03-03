package MB;
import java.util.Arrays;
import java.util.Scanner;
public class url1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner console = new Scanner(System.in);
		int a=0;
		int b =0;
		int e=1;
		while(true){
			a=console.nextInt();
			if(a>100000){
				System.out.println("输入的数错了");
				continue;
			}
			b=a+b;
			System.out.println("结果为:"+b);
			System.out.println("第:"+e);
			e++;
		}
		/*
		 * 48364     
		 * 60826
		 * 55857
		 * 55380
		 * 57256
		 * 56669
		 * 57420
		 * 51308
		 * 50529
		 * 51308
		 * 56180
		 * 59476
		 * 60276
		 * 60356
		 * 61191
		 * 61562
		 * 61300
		 * 61227
		 * 59991
		 * 57587
		 * 58360
		 * 58288
		 * 53150
		 * 53398
		 * 50092
		 * 58887
		 * 57528
		 * 50970
		 * 59603
		 * 50529
		 */		
	}

}
