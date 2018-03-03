package 循环;
import java.util.Scanner;
/**
 * 查找一个范围内所有的指数
 * 质数:大于1的数，可以被1整除,可以被自身整除,不能被
 *     被其他数整除
 * 如: 2 3 5 7 11
 * 1.判断一个数是否是质数
 * 	 不能被其他数整除:反之如果能够被一个数整除就不是质数
 *   假设一个数是num: num=100
 *   另外一个数是n  : n的范围:[2，n/2)，如num=100,可以整除100的数一定在[2，50]范围内！
 *   整除:num%n == 0 整除，如果整除就不是质数
 *   如果比较了所有的数，都没有整除，这个数就是质数
 *   整除：num%n==0  整除	 
 * 
 * 2.找出一个范围内所有的指数
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class 练习查找一个范围内的质数 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("请输入第一个数:");
		int numa=console.nextInt();
		System.out.println("请输入第二个数:");
		int numb=console.nextInt();
		if(numa>numb){
			numa=numb+numa;
			numb=numa-numb;
			numa=numa-numb;			
		}
		next:for (;numa<=numb;numa++){
		int a=1;	
		for(int n=2;n<=(numa/2);n++){
			System.out.println("numa:"+numa+" n:"+n);
			if(numa%n==0){
				System.out.println("这个数不是质数");
				a=0;
				continue next;
			}
		}
		
		if (a==1 && a%1==0 && numa%numa==0){
			System.out.println("这个数是质数:"+numa);
				
			}  
		}
		}

	}


