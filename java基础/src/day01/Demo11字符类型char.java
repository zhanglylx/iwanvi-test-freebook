package day01;

/**
 * 字符类型  char 类型
 * 16位整数！ 方位 0 ~65535  没有负数
 * 可以按照整数计算
 * 数值是unicode编码值
 *
 */
public class Demo11字符类型char {
	public static void main(String[] args){
		char c='A';//'A'字符直接量
		System.out.println((int)c);  // 65
		System.out.println((int)'B'); //66
		char ch='\''; //字符转义  一个单引号字符
		System.out.println(ch);//单引号字符
		System.out.println((int)ch);//单引号的编码
		// \n换行   \r 回车  \t tab字符  \" 双引号  \\标示一个\
		ch = '\u4e2d';
		System.out.println(ch);//中
		ch = 'A'+1;
		System.out.println(ch);//B
		String ch1=Integer.toHexString('国');//将中文的unicode编码转为16进制
		System.out.println(ch1);
		// ch = 65536；//编译错误，不能超出范围赋值
		// 超过本地字符集的字不能显示
		ch = 65535;
		System.out.println(ch);
		//不是所有字符都可以显示，只能本地字符(中文20000+)
	}
}
