package Methods_summarize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("[2-5][0-9]*"); // 使用正则表达式
		Matcher isNum = pattern.matcher("");
		System.out.println(isNum.matches());
		//"[a-zA-Z0-9_\u4e00-\u9fa5]+"// 使用正则表达式至少一个汉字、数字、字母、下划线
		 pattern = Pattern.compile(".*[a-zA-Z0-9_\u4e00-\u9fa5].*"); // 使用正则表达式至少一个汉字、数字、字母、下划线
		 isNum = pattern.matcher("");
		System.out.println(isNum.matches());
		//检查英文
		pattern = Pattern.compile("[0-9]+"); // 使用正则表达式至少一个汉字、数字、字母、下划线
		String a="2 2 ";
		isNum = pattern.matcher(a);
		System.out.println(isNum.matches());
		
		
		
	}

}
