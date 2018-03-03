package 封装_static_final关键字;
import 封装_sub.fengzhuang;
public class public_protected_private_ {
	public static void main(String[] args) {
		Yoo y = new Yoo();	
		System.out.println(y.a);
		System.out.println(y.b);
		System.out.println(y.c);
		//System.out.println(y.d);//编译错误:有d但是不可见
		System.out.println(y.getD());
		fengzhuang xoo = new fengzhuang();
		System.out.println(xoo.a);
		//System.out.println(xoo.b);//编译错误，不可见
		//System.out.println(xoo.c);//编译错误，不可见
		//System.out.println(xoo.d);//编译错误
		System.out.println(xoo.getD());
		Too t = new Too();
		t.test();
	}

}
class Too extends fengzhuang{
	public int getD(){
		return 1;
	}
	public void test(){
		System.out.println(super.a);
		System.out.println(super.b);//保护的，子类中可见
		//System.out.println(super.c);//不可见，默认范围:包中可见
		//System.out.println(super.d);//私有的，不可见
		System.out.println(super.getD());
	}
}
class Yoo{
	public int a = 5;//公用的
	protected int b = 6;//保护的
	int c = 7;//默认的
	private int d = 8;//私有的
	public int getD(){return this.d;}
}
