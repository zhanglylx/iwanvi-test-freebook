package Methods_summarize;

public class ceshi {

	public static void main(String[] args) {
		String chines = "阿迪达斯";
		String ch = "ad";
		System.out.println(cnToUnicode(chines));
		System.out.println(cnToUnicode(ch));
        if(cnToUnicode(chines).contains(ch)){
        	System.out.println(true);
        }
	}
	private static String unicodeToCn(String unicode) {
	    /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
	    String[] strs = unicode.split("\\\\u");
	    String returnStr = "";
	    // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
	    for (int i = 1; i < strs.length; i++) {
	      returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
	    }
	    return returnStr;
	}
	private static String cnToUnicode(String cn) {
	    char[] chars = cn.toCharArray();
	    String returnStr = "";
	    for (int i = 0; i < chars.length; i++) {
	      returnStr += "\\u" + Integer.toString(chars[i], 16);
	    }
	    return returnStr;
	}
}
