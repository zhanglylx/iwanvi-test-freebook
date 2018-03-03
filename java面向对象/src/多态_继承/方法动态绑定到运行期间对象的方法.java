package 多态_继承;

public class 方法动态绑定到运行期间对象的方法 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Woo n = new Loo();//父类型变量引用了子类对象
		n.test();//父类型Moo上声明的方法，子类型重写的方法
		//动态绑定到Noo对象，执行Noo对象的方法
	}

}
class Woo{
	public void test(){
		System.out.println("Moo test()");
	}
}
class Loo extends Woo {
	public void test(){
		System.out.println("Noo test()");
	}
}