package java面向对象day02;
/**
 * 方法参数传递原理与this关键字
 * 
 *
 */
public class 方法参数传递院里与this关键字 {

	public static void main(String[] args) {
		Point2 p1 = new Point2();
		p1.x = 10; p1.y = 15;
		p1.up(5);// up(p1,5);方法调用时候当前对象引用p1隐含传递给this
		System.out.println(p1.y);
		Point2 p2 = new Point2();
		p2.up(3);//up(p2,3)
		System.out.println(p2.y);
	}

}
class Point2{
	int x;
	int y;
	public void up(/* Point2 this */int dy){
		//this 是方法中对当前对象的引用，本质是方法的隐藏参数
		this.y = this.y - dy;
	}
}
