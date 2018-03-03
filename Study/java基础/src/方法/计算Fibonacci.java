package 方法;
/**
 * Fibonacci
 * 计算斐波那契数列的第n项
 * 1,1，2，3，4，8，13
 * 实现方法  fibonacci(n) 参数是序号n，返回时第n项的值
 * 如： fibonacci(1)  返回1
 *     fibonacci(2)  返回1
 *     fibonacci(6)  返回8
 *     fibonacci(7)  返回13
 * 算法:从第一项累加计算出第n项
 *  1.如果 n=1 或n=2  返回1
 *  2.规定 f 代表当前项  从第三项算起
 *    规定 f0 = 1 代表前前项
 *    规定 f1 = 1 代表前一项
 *    计算: i = 3 ~ n
 *    f = f1+ f0
 *  3.计算 f0 = f1; f1 = f 实现 前两项的数字移动
 *     f0=1;
 *     f1=2;
 *     如果计算到第n项就停止
 *  4.返回到(2)
 * @author Administrator
 *
 */
public class 计算Fibonacci {
	public static int fibonacci(int n){
	if (n==1 || n==2){return 1;}
	int f=0;
	int f1=1;
	int f0=1;
	for (int i=3;i<=n;i++){
		f = f1+f0;
		f0=f1;
		f1=f;
	}
	return f;
	}
	public static void main(String[] args){
		System.out.println(fibonacci(7));
	}
}
