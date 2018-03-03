/**
 * 格式化字符串主要包括：日期格式化，时间格式化，日期/时间组合的格式化和常规类型格式化。
 * @author 张连宇   第156页
 * 日期和时间的格式化方法：format()方法通过给定的特殊转换符作为参数
 *两种重载形式：
 *1.str.format(StringText format,Object....args)
 *该方法使用指定的格式字符串和参数，格式化后的新字符串使用本地默认的语言环境，返回格式化的字符串
 *format：格式化转换符
 *args：格式化字符串中的格式说明符引用的参数。如果还有格式说明符以外的参数，则忽略这些额外的参数。此参数的数目是可变的，可以为0
 *
 *2.str.format(Local l,StringText format,Object...args)
 *该方法使用指定的格式字符串和参数，格式化后的新字符串使用参数所规定的语言环境
 *l:格式化过程中要应用的语言环境。如果l为null，则不进行本地化.
 *
 *                     日期格式化
 *常用日期格式化转换符： 
 *%te   一个月中的某一天       6                     
 *%tb   指定语言环境的月份简称     Feb(英文)、二月(中文)
 *%tB   指定语言环境的月份全称     February(英文)、二月(中文) 
 *%ta   指定语言环境的星期几全称  Monday（英文）、星期一（中文）
 *%ta	指定语言环境的星期几简称  Mon（英文）、星期一（中文）
 *%tc   包括全部日期和时间信息    星期二 三月 25 13:37:22 CST 2008
 *%tY   4位年份                          2008
 *%tj   一年中的第几天（001~366）   085   
 *%tm   月份				   03
 *%td   一个月中的第几天（01~31）   02
 *%ty   2位年份                           08
 *                                      
 */
import java.util.Date;     //导入日期
import java.util.Locale;
public class 格式化字符串 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
    Date today=new Date();
    String a= StringText.format(Locale.CHINA,"%te",today);  //当月的今天
    String b= StringText.format(Locale.US, "%tb", today);   //当月的英文简称
    String c= StringText.format(Locale.US, "%tB", today);   //当月的英文全称
    String d= StringText.format("%ta", today);  //格式化为星期简称
    String e= StringText.format("%tc", today);
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(today);
    System.out.println(e);
    
	}

}
