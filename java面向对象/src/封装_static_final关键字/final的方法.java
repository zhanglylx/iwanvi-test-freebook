package 封装_static_final关键字;

public class final的方法 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
class A{
	public final void test(){
		
	}
}
class B extends A{
	//public void test(){}//编译错误，子类不能重写父类final方法
}