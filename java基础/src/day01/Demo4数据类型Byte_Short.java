package day01;
/**
 * 整数的演示
 * 任何数据在内存中都是2进制的数据
 * 内存中没有 10进制 16进制
 * byte范围:-128 ~ 127
 * short范围： -32768 ~ 32767
 */
public class Demo4数据类型Byte_Short {
	public static void main(String[] args){
		byte b;
		b=-128;
		//b=-129;//编译错误！超过范围
		short s=32767;
	}
}
