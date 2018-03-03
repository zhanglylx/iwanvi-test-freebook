package 循环;
/**
 *  sum = 9 + 99 + 999 + 9999 +..
 *  num = 9   99   999   9999
 *   i  = 1    2    3      4
 *  num = 0
 *  num =num*10 + 9
 *  
 *  
 * @author Administrator
 *
 */
public class 练习9加99加999加9999 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int i=1; //index 的缩写
		long num = 0L;
		long sum =0L;
		while(i<16){
			num =num *10 +9;
			i++; //递增表达式，保证循环能够结束
			sum+=num;
		}
		System.out.println(sum);
		i=1;
		num=0;
		sum=0;
		for(;i<20;i++){
			num=num*10 +9;
			sum+=num;
		}
		System.out.println(sum);
	}

}
