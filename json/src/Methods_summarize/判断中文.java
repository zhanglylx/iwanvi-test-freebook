package Methods_summarize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 判断中文 {
public static void main(String[] args) {
	 String chinese = "1";      
	 String regex = "[\\u4e00-\\u9fa5]";      
	 Pattern pattern = Pattern.compile(regex);   
	 Matcher matcher = pattern.matcher(chinese);    
	 int count=0;    
	 while (matcher.find()) {   
		 count++;          }       
	 System.out.println(isChinese(chinese));
	 System.out.println("count="+count);
}
public static boolean isChinese(String strName) {  
    char[] ch = strName.toCharArray();  
    for (int i = 0; i < ch.length; i++) {  
        char c = ch[i];  
        if (isChinese(c)) {  
            return true;  
        }  
    }  
    return false;  
}  
private static boolean isChinese(char c) {  
    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
    if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B  
            || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
            || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS  
            || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {  
        return true;  
    }  
    return false;  
}  
}
