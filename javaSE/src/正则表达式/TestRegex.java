package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则正则表达式
 * @author Administrator
 *
 */
public class TestRegex {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Pattern的作用是描述正则表达式的格式支持
		 * 使用静态方法compile注册正则表达式生成实例
		 */
		/**
		 * 邮箱格式的正则表达式
		 * zhanglylx@163.com
		 */
		/**
		 * 使用java的字符串去描述正则表达式的时候，会出现一个冲突
		 * 如何描述正则表达式的"."
		 * 起因:
		 * 		在正则表达式中我们想描述一个"."，但"."在正则表达式中有特许的含义。
		 * 		它代表任意字符，所以我们在正则表达式中想描述"."的原意就要写成"\.".
		 * 		但是我们用java的字符串去描述正则表达式的时候，因为"."在java字符串中没有
		 * 		特殊含义，所以java认为我们书写String s = "\."；是有语法错误的，因为
		 * 		"."不需要转义。这就产生了冲突
		 * 目的:
		 * 		我们实际的目的很简单，就是要让java的字符串描述"\."
		 * 		所以，那么在java中"\"是有特殊含义的，代表转义字符
		 * 		我们只需要将"\"转义为单纯的斜杠即可描述"\."了.
		 * 		所以我们用java描述"\."的正确写法是String s = "\\.";
		  
		 */
		//定义正则表达式
		//邮箱正则表达式
		String regStr= "^[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.com|\\.cn|\\.[a-zA-Z0-9])+$";
		Pattern pattern = Pattern.compile(regStr);
		String mailStr = "123@qq.com.cn.a";
		//匹配字符串，返回描述匹配结果的Matcher实例
		Matcher matcher = pattern.matcher(mailStr);
		//调用Matcher的find方法得知是否匹配成功
		System.out.println(matcher.find());
		//手机号
		regStr = "^(\\+86)?1\\d{10}$";
		String phoneStr = "11111111111";
	    pattern = Pattern.compile(regStr);
		matcher = pattern.matcher(phoneStr);
		System.out.println(matcher.find());
		//身份证
		regStr = "^\\d{6}"
				+ "((19\\d{2})|(18[8-9]{2}))"
				+ "(([0][0-9])|([1][1-2]))"
				+ "[0-3]{1}[1-9]{1}"
				+ "((\\d{4})|(\\d{3}\\*))$";
		String userStr = "110226199104291414";
	    pattern = Pattern.compile(regStr);
		matcher = pattern.matcher(userStr);
		System.out.println(matcher.find());
	
	}

}
