package 继承;
/*
 * 圆继承了图形，表示圆是一个图形
 * 圆会自动继承父类型的属性和方法
 * 其中: Shape称为父类型(Super class)
 * 		Circle 称为子类型(Sub class)
 */

public class Circle_extends_Shape extends Shape{
	int r;
	public Circle_extends_Shape(int x ,int y,int r){
		this.x = x;//this.x从父类继承的属性
		this.y = y;
		this.r = r;
	}
}
