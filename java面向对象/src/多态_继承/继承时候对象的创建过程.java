package 多态_继承;


public class 继承时候对象的创建过程 {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Boo b = new Boo();
	}

}
class Foo{
	int a = 1;
	public Foo(){System.out.println("a="+a);a = 5;}
}
class Poo extends Foo{
	int b =2;
	public Poo(){super();System.out.println("a="+a+" b="+b);b = 3;}
}
class Boo extends Poo{
	int c = 6;
	public Boo(){super();System.out.println("a="+a+" b="+b + " c="+c);a =8;b=9;c=10;}
}