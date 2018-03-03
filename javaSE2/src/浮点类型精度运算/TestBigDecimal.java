package 浮点类型精度运算;

import java.math.BigDecimal;

/**
 * BigDecimal
 * 表示精度更高的浮点型
 * @author Administrator
 *
 */
public class TestBigDecimal {

	public static void main(String[] args) {
		/**
		 * 创建一个BigDecimal实例，可以使用构造方法
		 * BigDecimal(StringText numberFormatString)
		 * 用字符串描述一个浮点数作为参数传入
		 */
		BigDecimal num1 = new BigDecimal("3.0");
		BigDecimal num2 = new BigDecimal("2.9");
		//减法  运算结构依然为BigDecimal表示的结果
		BigDecimal result = num1.subtract(num2);//num1-num2
		//输出结果
		System.out.println(result);
	
		//类型转换
		/**
		 * 这里需要注意，BigDecimal可以描述比Double还要高的精度
		 * 所以在转换为基本类型时，可能会丢失精度！
		 */
		float f = result.floatValue();
		int i = result.intValue();
		double s = result.doubleValue();
		System.out.println(i);
		/**
		 * BigDecimal可以做加减乘数等运算
		 * 这里要注意除法:
		 *  除法存在结果为无限不循环小数
		 *  所以，对以除法而言，我们要制定取舍模式，否则会一直
		 *  计算，直到报错位置
		 */
		
		/**
		 * 除法
		 * 保留给定精度位数后四舍五入
		 */
		result = num1.divide(num2,9,BigDecimal.ROUND_HALF_UP);
		System.out.println(result);
		
		/**
		 * add:加法
		 * multiply:乘法
		 */
	}

}
