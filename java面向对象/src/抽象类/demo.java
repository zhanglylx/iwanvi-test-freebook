package 抽象类;
/**
 * 抽象类可以定义变量，不能实例化
 * 创建对象  == 实例化
 * 对象 == 实例
 * @author Administrator
 *
 */
public class demo {

	public static void main(String[] args) {
		//Shape s1 = new Shape();//编译错误，不能实例化抽象类Shape
		Shape s1;
		
		s1 = new Circle(3,4,5);
		//动态调用子类型的方法,调用的是子类型实现的方法
		//子类型“实现了”父类型的抽象方法，就是方法的重写
		System.out.println(s1.contains(1, 1));
		Circle s2 = new Circle(3,4,5);
		System.out.println(s2.contains(1,1));
	}

}
