package 封装_static_final关键字;
/**
 * final 修饰的变量
 * final的变量只能初始化(赋值一次)，不能再修改！
 * 
 *
 */
public class final修饰的变量 {

	public static void main(String[] args) {
		//final 修饰的局部变量
		final int a;
		a = 5;//初始化
		//a = 8;//编译错误
		int b = 5;
		b = 100;
		final修饰的变量.test(5,6);
	}
	public static void test(final int a,int b){
		//a++;//编译错误，不能再修改
		System.out.println(a);
		System.out.println(b);
		b++;
		System.out.println(b);
	}

}
