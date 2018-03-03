package DateFormat是SimpleDateFormat父类;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDateFormat {

	public static void main(String[] args) {
		//创建描述当前系统时间的Date对象
		Date now = new Date();
		//创建用于将Date对象转换为日期格式的字符串的DateFormat
		/**
		 * 创建DateFormat对象的实例使用静态方法
		 * getDateInstance(style,aLocale);
		 * style为输出日期格式的样式:DateFormat有对应的常量
		 * aLocale为输出的地区信息。影响字符串的语言和表现形式
		 * 例如:老美喜欢描述日期为:  月 日 年
		 *      我们喜欢描述日期为:  年 月 日
		 */
		DateFormat format = 
				DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
		System.out.println(format.format(now));
		 format = 
				DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
		System.out.println(format.format(now));
		 format = 
					DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINESE);
			System.out.println(format.format(now));

	}

}
