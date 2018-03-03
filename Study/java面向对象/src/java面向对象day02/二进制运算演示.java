package java面向对象day02;
/*
 * 二进制运算演示
 * 业务 : 将b1,b2,b3,b4 拼接为一个IP地址
 *
 * 
 * 
 */
public class 二进制运算演示 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int b1 = 192;
		int b2 = 168;
		int b3 = 1;
		int b4 = 10;
		//b1 = 00000000	00000000 00000000 11000000
		//b2 = 00000000	00000000 00000000 10101000
		//b3 = 00000000	00000000 00000000 00000001
		//b4 = 00000000	00000000 00000000 00001010
		//ip = 1100000000 10101000 00000001 00001010
		int ip = (b1 << 24)+(b2<<16)+(b3<<8)+b4;
		System.out.println(Integer.toBinaryString(b1 << 24));
		System.out.println(Integer.toBinaryString(b2<<16));
		System.out.println(Integer.toBinaryString(b3<<8));
		System.out.println(Integer.toBinaryString(b4));
		System.out.println(Integer.toBinaryString(ip));
		ip = (b1 << 24)|(b2<<16)|(b3<<8)|b4;// |逻辑或
		System.out.println(Integer.toBinaryString(ip));
		//将16进制的计算机颜色拆分为  red green blue 三色值
		int color = 0xD87455;
		int b =color & 0xff;
		System.out.println(b);
		int g = (color >>> 8) & 0xff;
		System.out.println(g);
		int r = (color >>> 16) & 0xff;
		System.out.println(r);
	}

}
