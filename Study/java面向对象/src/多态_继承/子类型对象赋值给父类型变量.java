package 多态_继承;
/**
 * 子类型对象可以赋值给父类型变量
 * 变量是代词，父类型代词可以引用子类型东西
 * 变量的类型定义的属性和方法才能访问！
 * 如:Shape s; s只能访问Shape上声明的属性和方法
 */
public class 子类型对象赋值给父类型变量 {

	public static void main(String[] args) {
		Circle_圆形_继承图形 c = new Circle_圆形_继承图形(3,4,5);
		Shape_图形 s = c;//父类型变量s引用了子类型实例
		// s 和 c引用了同一个对象new Circle(3,4,5)
		System.out.println(c.r);
		System.out.println(c.area());
		//System.out.println(s.r);//在Shape上没有定义r属性
		//System.out.println(s.area());//编译错误
	}

}
