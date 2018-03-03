package 运算和判断语句;
/**
 * 关系运算
 * @author Administrator
 *
 */
public class 关系运算 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		char c = 'A';
		boolean b = c > 'D';//false
		boolean b1= c <='Z';//true
		
		char ch = 'A';//65    65 >=48      65<= 57  
		boolean isNumber = ch >='0' && ch <='9';
		//判断一个字符是否是数字字符('0'~'9')
		//判断这个字符的编码数值介于(48~57)之间
		//     48 <= N <=57
		System.out.println(isNumber);
	   isNumber = ch >='A' && ch <='Z';
	   System.out.println(isNumber);
	}
	

}
