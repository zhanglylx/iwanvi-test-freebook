package StringText;

public class charAt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 获取指定位置的单个字符
		 */
		String str  = "Think java";
		char ch =str.charAt(6);
		System.out.println(ch);
		
		/**
		 * 使用charAt判断字符串是否为回问
		 */
		String str2 = "上海自来水来自海上";
		/**
		 * 回文：从左或右念是一样的
		 * 思路:
		 * 	字符串中第1个位置的字符和最后一个字符一致
		 *  第二个字符和倒数第二个字符一致以此类推
		 *  若都完全一致就是回文
		 *  步骤:
		 *  	1.进行循环比较，循环次数是有字符串长度除以2决定的
		 *      2.比较正整数位置的字符和对应的倒数位置的字符是否相等
		 */
		boolean tf = true;//定义一个变量，表示是否为回味，默认为是
		for(int i=0;i<str2.length()/2;i++){
			char first = str2.charAt(i);
			char last = str2.charAt(str2.length()-1-i);
			if(first != last){
				tf = false;
				break;
			}
		}
		System.out.println(tf);
		
		
		
		
	}

}
