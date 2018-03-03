package Java异常处理机制;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * throws关键字 声明抛出异常的种类
 * 
 * 作用是通知调用者必须捕获的异常
 * 
 * @author Administrator
 *
 */
public class DemoThrows {
	public static void main(String[] args) {
		try {
			Date tiday = stringToDate("f13-05-20");
			System.out.println(tiday.toString());
			// catch中必须含有有效的捕获stringToDate方法throws的异常
		} catch (ParseException e) {
			/**
			 * 输出这次错误的栈信息
			 * 可以直观的查看方法调用过程和出错我根源
			 */
			e.printStackTrace();
			System.out.println("错误的格式");
		}
	}

	/**
	 * 将一个字符串转换为一个Date对象 java.util.Date
	 * 
	 * @param str
	 *            yyyy-MM-dd形式的日期字符串
	 * @throws ParseException
	 * 
	 *             抛出的异常是字符串格式错误 java.text.ParseException
	 */
	public static Date stringToDate(String str) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		/**
		 * SimpleDateFormat的parse方法在声明的时候就使用了throws
		 * 强制我们调用parse方法时必须捕获ParseException 我们的做法是添加try-catch捕获该异常，或者在我们的方法
		 * 声明出也追加这种异常的抛出。
		 */
		Date date = format.parse(str);
		return date;

	}
}
