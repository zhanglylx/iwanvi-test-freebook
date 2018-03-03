package Methods_summarize;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 打印系统时间 {
	public static void main(String[] args){
		Date dt = new Date();
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		System.out.println("a5:"+matter1.format(dt));	
		System.out.println(dt);
	}
}
