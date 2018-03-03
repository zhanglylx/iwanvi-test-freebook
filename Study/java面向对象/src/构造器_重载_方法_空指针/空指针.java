package 构造器_重载_方法_空指针;
/**
 * null 与 空指针异常
 * 引用变量不是对象，变量在运行期间动态绑定到对象
 * 当变量的值是null时候，调用了变量的属性
 * 或者方法，出出现空指针异常
 * 
 *
 */
public class 空指针 {

	public static void main(String[] args) {
		String s1;
		//System.out.println(s1);//编译错误！变量没有初始化！
		s1 = null;//引用类型变量可以赋值为null
		//null:空，就是没有
		//s1 = null 表示有s1 没有引用任何字符串对象！
		//s1.charAt(0);//运行异常，空指针异常
		test("Hi");
		test(s1);
	}
	public static void test(String s){
		//s变量不是字符串对象，在运行期间动态绑定到对象
		System.out.println(s.charAt(0));//在s的值是null的时候异常
	}
}
