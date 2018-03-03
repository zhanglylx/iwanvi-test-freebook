package day01;
/**
 * long 类型数据
 * 范围：-2^63 ~ 2^63-1
 *
 */
public class Demo6数据类型Long {

	public static void main(String[] args) {
		//long L1=10000000000;//编译错误，整数字面量超过int范围
		long L1=1000000000000L;//以L后缀的字面量是long类型
		//current 当前的 Time时间Millis毫秒数
		long now=System.currentTimeMillis();
		//从1970年元旦到现在(软件运行期间的此时此刻)累计的毫秒数
		System.out.println(now);
		long year=now/1000/60/60/24/365+1970;
		System.out.println("公元"+year);
		long max = 0x7fffffffffffffffl;//1个7 15个f 16进制MAX
		System.out.println(max);
		year = max/1000/60/60/24/365+1970;
		System.out.println("公元"+year); //long毫秒数能表示的公元年份
	}

}
