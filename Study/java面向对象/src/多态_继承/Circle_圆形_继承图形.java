package 多态_继承;
/**
 * 圆继承了图形，表示圆是一个图形
 * 圆会自动继承父类型的属性和方法
 * 其中: Shape称为父类型(Super class)
 *  	Circle称为子类型(Sub class)
 *
 */
public class Circle_圆形_继承图形 extends  Shape_图形{
	int r;
	public Circle_圆形_继承图形(int x,int y,int r){
		this.x=x;//this.x从父类继承的属性
		this.y=y;
		this.r=r;
	}	
	/** 计算当前圆对象的面积 */
	public double area(){
		return Math.PI * this.r * this.r;
	}
	/** 重写(覆盖)了父类的方法*/
	public boolean contains(int x ,int y){
		int a = this.x - x;int b =this.y - y;
		double c = Math.sqrt(a*a + b*b);
		return c<=r;
	}
}
