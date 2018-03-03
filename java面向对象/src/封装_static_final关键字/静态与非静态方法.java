package 封装_static_final关键字;
/**
 * 静态方法
 * 静态方法使用类名调用，是属于类的方法
 * 静态方法中没有this变量，不能访问当前对象
 * 静态方法一般用于与当前对象无关工具方法
 * 如:Math.sqrt() Arrays.sort()
 *
 */
public class 静态与非静态方法 {

	public static void main(String[] args) {
		Point p1 = new Point(3,4);
		Point p2 = new Point(6,8);
		//在对象上调用方法，当前对象隐含传递
		System.out.println(p1.distance(p2));
		double d = Point.distance(p1, p2);
		//静态方法调用时候不传递隐含的当前对象参数
		System.out.println(d);
	}

}
class Point{
	int x ; int y ;
	public Point(int x,int y){
		this.x = x; this.y = y;
	}
	//静态方法中没有隐含参数this！在静态方法没有this
	//在静态方法中不能访问this的属性和方法！
	public static double distance(Point p1,Point p2){//静态方法
		int a = p1.x - p2.x;
		int b = p1.x - p2.y;
		return Math.sqrt(a*a + b *b);
	}
	/**计算当前点到另外一个点(other)的距离 */
	public double distance(/*Pont this 隐含参数 */Point other){//对象的方法
		int a = this.x - other.x;
		int b = this.y - other.y;
		return Math.sqrt(a*a + b*b);
	}
}