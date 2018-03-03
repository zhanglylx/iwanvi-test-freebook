package 构造器_重载_方法_空指针;
/*
 * 构造器是可以重载的
 * 重载的目的是为了方便
 * 重载规则与方法重载规则相同
 */

public class 构造器重载 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	Point1 o = new Point1();
	Point1 p1 = new Point1(5);
	Point1 p2 = new Point1(3,4);
	System.out.println(p1.x +""+ p1.y);
	}

}
class Point1{
	int x; int y;
	public Point1(){
		this.x = 0; this.y = y;
	}
	public Point1(int x , int y){
		this.x = x; this.y = y;
		
	}
	public Point1(int x){
		this.x = x ;this.y = x;
	}
}