package 封装_static_final关键字;

public class 代码块与静态代码块 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 new Goo();
		 new Goo();
	}

}
class Goo{
	{//代码块，在创建对象时候执行！类似于构造器的作用
		System.out.println("HI");
	}
	static{//静态代码块,在类的加载期间执行，只执行一次
		System.out.println("loading Goo.class");
	}
}