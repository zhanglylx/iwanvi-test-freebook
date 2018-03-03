package 运算和判断语句;
/**
 * float long
 * 
 * float 的精度没有long高(尾数短)
 * float 的范围大于long 指数可以很大
 * @author Administrator
 *
 */
public class float精度和long对比 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		long l = 31415926535879932L;
		System.out.println(l);
		float f =l;//精度损失
		f =f*10000000;
		System.out.println(f);
		l=(long)f;//溢出了
		System.out.println(l);
	}

}
