package 方法;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class 双色球 {
	public static String [] f(int n){
		Random rand = new Random();
		String[] pools = new String[]{"01","02","03","04","05","06","07","08","09","10","11"
				,"12","13","14","15","16","17","18","19","20","21","22","23","24","25","26"
				,"27","28","29","30","31","32","33"};
		boolean[] balls = new boolean[pools.length];
		String[] number = new String[n];
		if(n>pools.length){ //判断输入的需要取的球数大于程序定义的球数时，返回空数组
			number[0]="50";
			return number;
		}
		int i=0;
		while(true){
			int num=rand.nextInt(pools.length); //随机出0到pools数组的位数		
			if (balls[num]==true){continue;}//判断如果pools的下标为true，那么这个数组元素已经被取出，将从新开始循环数组
				balls[num]=true;//将取出来的数组下标记录为true
				number[i++]=pools[num];//将取出来的数组元素赋值给number，并i+1，存储下一次随机出的数组元素
				
			if(i==number.length){break;}//当i的值==number的长度时，代表元素已经取够来了，终止循环					
		}
		return number;//将取出的元素赋值返回给方法f；
	}
	public static int a(){
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		
		return n;
	}
	public static void main(String[] args) {
		
		String [] number=f(a());
		String [] numbera=f(a());
		if("50".equals(number[0]) || "50".equals(numbera[0])){
			System.out.println("您输入的数大了");
		}
//	for(i=0;i<number.length;i++){
	//	System.out.println(number[i]);
	//}
		Arrays.sort(number);
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(numbera));
	}

}
