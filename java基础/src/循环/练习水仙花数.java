package 循环;
import java.util.Scanner;
/**
 * 业务问题定义
 * 输出 某个范围内的所有水仙花数
 * 1.如何将一个数拆开为 个位数
 *  如： 2365 -> 2,3,6,5
 * 2.计算判断是否为水仙花数
 *  2365 == 2*2*2 + 3*3*3 + 6*6*6 + 5*5*5
 * 3.判断一个范围内那几个数是水仙花数
 * 
 *
 */
public class 练习水仙花数 {

	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		for(int i=1;i<10000;i++){
		//System.out.println("请输入一个数字:");	
		int num =i;
		int sum =0;
		/*d = num%10;//5
		num/=10;//num=236
		d = num%10;//6
		num/=10;//num=23
		d = num%10;//3
		num/=10;//num=2
		d = num%10;//2
		num/=10;//num=0 //循环结束条件！
		*/
		
		while(true){
		    int	d=num%10;//获取num的最后一位数
			num/=10;
			sum+=d*d*d; //累加3次方的和到sum
			if(num==0){//如果去除最后一位以后为0，就结束循环
				break;
			}
			
		}
		if(i==sum){
			System.out.println("是水仙花数:"+i);
			
		}
		
		}
	}

}
