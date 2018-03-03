package 内部类;
/**
 * 匿名内部类 == 匿名类
 * new Uoo(){} 就在匿名内部类！ 是继承与Uoo类的子类，并且
 * 同时创建了子类型实例，其中{}是子类的类体
 *{}是类体,可以写任何类中的成员
 *匿名内部类没有子类类名
 */
public class 匿名内部类 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Uoo u = new Uoo();//创建Uoo实例
		Uoo u1 = new Uoo(){};//创建匿名内部类实例
		Uoo u2 = new Uoo(){
			public void test(){//方法的重写
				System.out.println("u2.test");
			}
		};
		u2.test();
		// new Doo();编译错误，不能创建接口实例
		Doo doo = new Doo(){//实现接口，创建匿名内部类实例
			public void test(){//实现接口中声明的抽象方法
				System.out.println("实现test");
			}
		};
		doo.test();//调用方法
	}
}
interface Doo{
	void test();
}
class Uoo{
	public void test(){}
}