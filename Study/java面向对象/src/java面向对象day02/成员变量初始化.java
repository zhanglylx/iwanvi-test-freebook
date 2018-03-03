package java面向对象day02;
/**
 * 对象的属性是自动初始化的
 * 
 */

public class 成员变量初始化 {
	public static void main(String [] args){
		Foo f = new Foo();
		System.out.println(f.a);
		System.out.println(f.b);
		System.out.println(f.f);
		System.out.println((int )f.c);
		System.out.println(f.s);
		int a;//局部变量: main方法中声明的局部变量
		//局部变量在栈中分配
	}
}
class Foo{
	int a;//是类中声明的实例变量，成员变量，自动初始化
	double b;//实例变量，对象属性:在堆中对象中分配
	boolean f;//每个对象都有自己的实例变量，属性
	char c;
	String s;
}