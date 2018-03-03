package 构造器_重载_方法_空指针;

public class 重载和重写的区别 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Goo w = new Goo();
		Super s = new Sub();
		w.g(s);//重载的方法调用由参数s类型Super决定，与对象Sub无关
	}

}
class Goo{
	public void g(Super obj){
		System.out.println("g(Super)");
		obj.f();//重写的方法调用由对象的引用Sub决定
	}
	public void g(Sub obj){
		System.out.println("G(Sub)");
		obj.f();
	}
}
class Super{
	public void f(){
		System.out.println("f(Super)");
	}
}
class Sub extends Super{
	public void f(){
		System.out.println("f(Sub)");
	}
}