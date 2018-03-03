package SimpleDateFormat日期转换类;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期转换类SimpleDateFormat
 * 这里我们在字符串与日期类间相互转换需要一些约束的
 * "2012-02-02"这个字符串如何转换为Date对象
 * 
 * SimpleDateFormat用来描述日期的格式
 * yyyy-MM-dd  2012-02-02
 * yy-MM-dd    12-02-02
 * yyyy-MM-dd hh:mm:ss 2012-02-02 03:20:53
 * 大写M代表月  小写mm代表分
 * @author Administrator
 *
 */
public class MyDateFormat {

	public static void main(String[] args) throws ParseException {
		/**
		 * 创建一个SimpleDateFormat并且告知它要读取
		 * 字符串的格式
		 */
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		//创建一个日期格式的字符串
		String dateFormat = "2012-02-02";
		//将一个字符串转换为相应的Date对象
		Date date = sdf.parse(dateFormat);
		System.out.println(date);
		
		/**
		 * 反向操作,我们也可以将一个Date对象转换为它所描述的
		 * 日期的字符串。同意，转换出来的字符串格式是
		 * SimpleDateFormat创建的时候设置的格式
		 */
		Date now = new Date();//创建用于描述当前系统时间的Date
		String nowStr = sdf.format(now);
		System.out.println(nowStr);
		
		/**
		 *  将当前系统时间转换为2012/05/14 17:06:22
		 *  
		 */
		SimpleDateFormat format2 = 
				new SimpleDateFormat("yyyy/MM/dd hh-mm-ss");
		nowStr = format2.format(now);
		System.out.println(nowStr);
	
	
	
	}

}
