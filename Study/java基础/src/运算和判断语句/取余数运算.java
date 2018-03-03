package 运算和判断语句;
/**
 * 取余数运算
 * 获取除法结果的余数             
 * 1.负数的余数是负数!
 * 2.num/n n>0 结果范围(0,n),是周期函数                                     
 * @author Administrator
 *
 */
public class 取余数运算 {
	public static void main(String[] args){
		int num=9;
		int x = num%5; // 9/5 得1 余4
		System.out.println(x);
		num =4;
		System.out.println(num%5);
		System.out.println( -1 %5);
		System.out.println(0%5);
		System.out.println(1%5);
		System.out.println(2%5);
		System.out.println(3%5);
		System.out.println(4%5);
		System.out.println(5%5);
		System.out.println(6%5);
	}
	
}
