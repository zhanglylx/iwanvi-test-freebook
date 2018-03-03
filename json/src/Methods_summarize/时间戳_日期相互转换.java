package Methods_summarize;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class 时间戳_日期相互转换 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//时间戳转化为Sting或Date  
//	    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//	    Long time=new Long(445555555);  
//	    StringText d = format.format(time);
//	    Date date= format.parse(d);  
//	    System.out.println("Format To StringText(Date):"+d);
//	    System.out.println("Format To Date:"+date);  
	    
	  //Date或者String转化为时间戳  
	    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String time="1970-01-06 11:45:55";  
	    Date date = format.parse(time);  
	    System.out.print("Format To times:"+date.getTime());  
	}

}
