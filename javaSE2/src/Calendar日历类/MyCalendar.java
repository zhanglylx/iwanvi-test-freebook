package Calendar日历类;

import java.util.Calendar;
import java.util.Date;

/**
 * 日历类
 * @author Administrator
 *
 */
public class MyCalendar {

	public static void main(String[] args) {
	/**
	 * 通过Calendar的静态方法获取一个实例
	 * 该方法会自行决定时区，帮我们创建Calendar实例
	 * 该方法会根据当前系统所在地区来决定时区
	 * 
	 * 这里要注意，实际上根据不同的地区，Calendar有若干个子类实现。
	 * 而Calendar本身是抽象类，不能被实例化！
	 * 我们不需要关系创建的实例具体为哪个子类，我们只需要根据
	 * Calendar规定的方法来使用就可以了。
	 */
		//构造出来表示当前时间的日历类
		Calendar calendar = Calendar.getInstance();
		/**
		 * 日历类所解决的根本问题是简化日期的计算
		 * 要想表示某个日期还应使用Date来描述
		 * Calendar是可以将其描述的时间转换为Date的
		 * 我们只需要调用其getTime()方法就可以获取描述的日期的
		 * Date对象了。
		 */
		Date now = calendar.getTime();//获取日历所描述的日期
		System.out.println(now);
		/**
		 * 通过日历类计算时间
		 */
		/**
		 * 为日历类设置时间
		 * 日历类设置时间使用通过方法set
		 * set(int field,int value);
		 * field为时间分量:Calendar提供了相应的常量值
		 * value:对应的值
		 */
		//设置日历表示2012年
		calendar.set(Calendar.YEAR, 2012);
		System.out.println(calendar.getTime());
		//设置日历表示10月
		//只有月份从0开始,所以0代表1月以此类推
		//也可以使用Calendar常量
		calendar.set(Calendar.MONTH, 9);
		calendar.set(Calendar.MONTH, Calendar.OCTOBER);
		System.out.println(calendar.getTime());
		
		/**
		 * 设置日历表示15号
		 * Calendar.DAY_OF_MONTH 月里边的天----号
		 * DAY_OF_WEEK           星期里的天-----星期几
		 * DAY_OF_YEAR           年里的天
		 */
		calendar.set(Calendar.DAY_OF_YEAR, 135);
		System.out.println(calendar.getTime());
		
		/**
		 * 想得到22天以后是哪天
		 */
		calendar.add(Calendar.DAY_OF_YEAR, 22);
		System.out.println(calendar.getTime());
		
		/**
		 * 想得到5天前是哪天
		 */
		calendar.add(Calendar.DAY_OF_YEAR, -5);
		System.out.println(calendar.getTime());
		
		/**
		 * 得知1个月后是哪天
		 */
		calendar.add(Calendar.MONTH, 1);
		System.out.println(calendar.getTime());
		
		/**
		 * 小练习:
		 * 	设置日期到2012-02-29
		 * 	加上一个年后是哪天？
		 */
		calendar.clear();
		calendar.set(Calendar.YEAR, 2012);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 29);
		calendar.add(Calendar.YEAR, 1);
		//calendar.set(Calendar.DAY_OF_WEEK, 2);
		System.out.println(calendar.getTime());
		
		
		/**
		 * 想获取当前日历表示的日期中的某个时间单位
		 * 可以使用get方法
		 */
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int  week = calendar.get(Calendar.DAY_OF_WEEK);
		//month要处理
		System.out.println(year+"年"+(month+1)+"月"+day+"日"+week+"几");
		calendar = Calendar.getInstance();
		System.out.println(calendar.getTime().toString());
	}

}
