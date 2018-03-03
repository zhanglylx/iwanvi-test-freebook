package 构造器_重载_方法_空指针;
/**
 * 构造方法 == 构造器
 * 构造器语法：在类中定义，方法名与类名一样！包括大小写
 *      不能定义返回值
 * 构造器的作用：用于创建对象，初始化对象属性
 * 构造器的参数l一般是初始化对象的前提条件。
 * 
 * 
 * 区别于方法：方法是功能，是操作算法，使用对象调用方法
 *    构造器是用来创建对象，是初始化方法，使用new运算调用
 */
public class 构造器and方法 {

	public static void main(String[] args) {
		Point p1 = new Point(1,3);//new 运算调用构造器，返回对象
		p1.up(2);//使用引用调用对象的方法，实现移动的功能
		System.out.println(p1.y);
		Point p2 = new Point();
		p2.up(4);
		System.out.println(p2.y);
	}

}
class Point{
	int x;int y = 8;
	public Point(int x,int y){//构造器
		System.out.println(this.x);
		this.x = x; this.y = y;
		
	}
	public Point() {
		// TODO 自动生成的构造函数存根
	}
	public void up(int dy){//方法
		this.y -=dy;
	}
}