package 构造器_重载_方法_空指针;
/**
 * 默认构造器
 * new 运算调用的是构造器！
 * 
 * 1）类一定有构造器
 * A.如果类没有声明(定义)任何的构造器，Java编译器会自动插入
 * 	 默认构造器！
 * B.如果类声明了构造器，Java编译器将不再提供默认构造器
 * 默认构造器是无参数，方法体是空的构造器
 *
 */
public class 默认构造器 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Foo foo = new Foo();//调用了java自动添加的默认构造器！
	  //Koo koo = new Koo();//编译错误，没有Koo()构造器
		Koo koo = new Koo(8);
	}

}
class Foo{}//Foo有构造器，有无参数的默认构造器
class Koo{
	public Koo(int a){//声明了有参数构造器
		System.out.println("call Koo(int)");
	}
}