package java面向对象day02;

public class 类demo {

	public static void main(String[] args) {
		Point p1;//引用“变量”，是对象的名字
		p1 = new Point();//对象
		p1.x=3;// . 叫取成员运算，可以理解为“的”
		p1.y=4;
		Point p2 = new Point();
		p2.x =5;
		p2.y =5;
		System.out.println(p1.x+","+p1.y);//3,4
		System.out.println(p2.x+","+p2.y);//5,5
	}
}
class Point{//类
	int x;
	int y;

}
class Result{ //结果
	int match;//字符匹配数量
	int pos; //位置匹配数组
}
