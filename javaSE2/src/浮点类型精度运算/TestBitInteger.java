package 浮点类型精度运算;

import java.math.BigInteger;

/**
 * 可以保存更长位数的整数
 * BigInteger
 * java.math.BigInteger
 * @author Administrator
 *
 */
public class TestBitInteger {

	public static void main(String[] args) {
		/**
		 * BigInteger同样支持使用描述更长位数的整数的字符串来
		 * 创建BigInteger
		 */
		BigInteger num = new BigInteger("1");
//		num = new BigInteger(1);
		/**
		 * 这种方式我们可以将一个整数的基本类型转换为BigInteger的实例
		 */
		num = BigInteger.valueOf(1);
		
		/**
		 *  BigInteger同样支持加减乘除方法
		 *  
		 *  200的阶乘
		 */
		for(int i=1;i<201;i++){
			num = num.multiply(BigInteger.valueOf(i));			
		}
		System.out.println(num);
		System.out.println(num.toString().length());
		
		/**
		 * 理论上：BigInteger存放的整数位数只受内存容量影响
		 * 有容乃大。
		 */
		
		
		
		
	}

}
