package 循环;
/**
 * PI = 4*((1/1 -1/3)+(1/5 - 1/7)+(1/9 - 1/11)...)
 * 
 * int i
 * i = 1 5 9 9+4
 * sum += 1.0/i - 1.0/(i+2)
 * @author Administrator
 *
 */
public class for练习求π {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		double sum =0;
		for (long i=1;i<10000000000000l;i+=4){
		
			sum+=(1.0/i) -( 1.0/(i+2));
			
		}
		double pi=4*sum;
		System.out.println(pi);
	}

}
