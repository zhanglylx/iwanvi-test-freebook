package Methods_summarize;

import java.math.BigDecimal;

public class 处理double方法 {
	//方法一
	public void nf(){
	   java.text.NumberFormat nf = java.text.NumberFormat.getInstance();   //禁止显示为科学技术法
	   nf.setGroupingUsed(false);  
	  String s = nf.format(1.1231E7);
	}
	//方法二
	public void bd(){
	 BigDecimal bd = new BigDecimal(1.1231E7); 
	  String s = bd.toPlainString();
	}
	{
		//double相加方法
	BigDecimal a2 = new BigDecimal(10.12); 
	BigDecimal b2 = new BigDecimal(10.12);
	double sum =a2.add(b2).doubleValue(); //cpu相加
	}
	
	
}
