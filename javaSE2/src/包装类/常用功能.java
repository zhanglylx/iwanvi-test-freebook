package 包装类;
/**
 * 包装类常用功能
 * @author Administrator
 *
 */
public class 常用功能 {

	public static void main(String[] args) {
		/**
		 * 包装类可以将描述该类型数据的字符串转换为对应的数据类型
		 */
		String numStr = "123";
		/**
		 * 包装类都可以将字符串转换为其类型
		 * 方法是:parseXXX    XXX代表其类型
		 * 特别注意：一定要 保证待转换的字符串描述的确实是或者
		 * 兼容要转换的数据类型！否则会抛异常。
		 */
		//将字符串类型的整形转换为int
		int s = Integer.parseInt(numStr);
		long longNum = Long.parseLong(numStr);
		double doubleNum = Double.parseDouble(numStr);
		
		/**
		 * Integer为我们提供了几个唯有的方法
		 * 将一个整数转换为16进制的形式并以字符串返回
		 * 将一个整数转换为2进制的形式并以字符串返回
		 */
		String bStr = Integer.toBinaryString(s);//转换为2进制
		String hStr = Integer.toHexString(s);//转换为16进制
		System.out.println(bStr);
		System.out.println(hStr);
		
		
		/**
		 * 所有包装类具有几个共通的常量
		 */
		int max = Integer.MAX_VALUE;//获取int最大值
		int min = Integer.MIN_VALUE;//获取int最小值
		long longMax = Long.MAX_VALUE;
		double doubleMax = Double.MAX_VALUE;
		System.out.println(max);
		System.out.println(min);
		System.out.println(longMax);
		System.out.println(doubleMax);
	}

}
