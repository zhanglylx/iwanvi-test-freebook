package java面向对象day02;
/**
 * 方法，与方法的重载
 * 
 * 重载:方法名一样，参数不同的方法构成重载的方法
 * 实现类似的功能。
 * @author Administrator
 *
 */
public class 类中定义方法_重载 {

	public static void main(String[] args) {
		 Point1 p1 = new Point1();
		 p1.x = 10; p1.y =20;
		 p1.up(5);
		 System.out.println(p1.x + ","  + p1.y);
		 Point1 p2 = new Point1();
		 p2.x = 8; p2.y = 14;
		 p2.up(3);//在当前对象上执行的方法，是对象的方法
		 //up方法的运算修改当前对象的属性y
		 System.out.println(p2.x + "," + p2.y);
		 Point1 p3 = new Point1();
		 p3.x = 10; p2.y=0;
		 p3.down(2);
		 System.out.println(p3.x+","+p3.y);
		 Point1 p4 = new Point1();
		 p4.x = 10; p4.y=5;
		 p4.down(2);
		 p4.up(3);
		 System.out.println(p4.x+","+p4.y);
		 p4.up();
		 System.out.println(p4.x+","+p4.y);
		 p4.up('a');
		 System.out.println(p4.x+","+p4.y);
	}

}
//class Point{}//在一个包package中不能有同名的类！
class Point1{
	int x; int y;
	/**向上移动当前点对象,就是将点数据结构中的y值更新*/
	public void up(int dy){
		y -= dy;
	}
	public void down(int dy){
		x -= dy;
	}
	/** 向上移一步 走一步! */
	public void up(){//方法重载
		y--;
	}
	public void up(char c){
		y++;
	}
}