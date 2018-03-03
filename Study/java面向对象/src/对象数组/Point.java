package 对象数组;

public class Point {/**默认继承 extens object    */
 private int x;
 private int y;
 public Point(){
	 
 }
 public Point(int x, int y){
	 this.x = x;
	 this.y = y;
 }
 public int gerX(){
	 return x;
 }
 public int getY(){
	 return y;
 }
 //Point.java
 //toString是objext类定义，子类继承的方法
 //在打印对象时候，默认调用，重写这个方法可以打印的更好看！
 public String toString(){
	 return x + "," + y;
 }
}
