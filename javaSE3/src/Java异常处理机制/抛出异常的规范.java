package Java异常处理机制;

import java.text.ParseException;
import java.util.Date;

public class 抛出异常的规范 {

	public static void main(String[] args) {
		Date date = stringToDate(null);

	}
	
	public static Date stringToDate(String str){
		if(str == null){
			/**
			 * 我们在方法中主动抛出异常，应该在方法声明时声明该
			 * 异常的抛出
			 */
			/**
			 * NullPointerException是非检查异常(RuntimeException子类)
			 * 所以我们抛出该类异常实例时，方法声明处无需添加throws
			 * 来列举该类异常的抛出。编译器在编译该类时也忽略对这类异常
			 * 抛出的检查(编译时不看他是不是在throws中被列举)
			 */
			//throw new NullPointerException("有错误");
			/**
			 * 抛出非RuntimeExecption异常，这类异常称为检查异常
			 * 编译器在编译该类时若发现方法中抛出了此类异常，那么
			 * 一定会检查方法声明出是否含有throws这类异常的声明，
			 * 若没有就判定为语法错误。编译不通过！
			 */
			//throw new ParseException("",0);
		}
		return null;
		
		
		
		
	}
}
