package Date;

import java.util.Date;

/**
 * java中日期类 Date
 * @author Administrator
 *
 */
public class MyFirstDate {

	public static void main(String[] args) {
		//创建一个Date实例，默认的构造方法创建的日期代表当前系统时间
		Date date = new Date();
		/**
		 * 输出date对象
		 * GMT:格林威治时间  世界上计时流行的标准
		 * 中国所属时区为+8区，所以要对时间上的小时+8
		 */
		System.out.println(date);
		System.out.println(date.toGMTString());
		/**
		 * 查看date内部的毫秒值
		 */
		long time = date.getTime();
		System.out.println(time);
		
		/**
		 * 可以设置一个时间让Date、表示该日期
		 * 一天后的当前时间
		 */
		date.setTime(time + 1000*60*60*24);
		System.out.println(date);
		/**
		 * 千年虫问题
		 */
		
		int year = date.getYear();
	}

}
