package 多态_继承;
/**
 * Shape_Circle 与 Shape 和 Circle 在同一个包中
 * Circle 可以 从Shape中继承属性和方法
 * x属性和up方法定义在Shape类中，被子类Circle继承了。
 *
 */
public class Shape_Circle_Rect {

	public static void main(String[] args) {
		Circle_圆形_继承图形 c = new Circle_圆形_继承图形(3,4,5);
		c.up();//Circle 从Shape中继承了方法up
		System.out.println(c.x);//Circle 继承了Shape中的x
		System.out.println(c.y);
		Rect_矩形_继承图形 r = new Rect_矩形_继承图形(1,4,2,2);
		System.out.println(r.area());
	}

}
