package 继承;

public class Shape_Circle在同一个包中 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Circle_extends_Shape c = new Circle_extends_Shape(3,5,7);
		c.up();//Circle 从Shape中继承了方法up
		System.out.println(c.y);
		System.out.println(c.x);//Circle继承了Shaper中的x
	
	}

}
