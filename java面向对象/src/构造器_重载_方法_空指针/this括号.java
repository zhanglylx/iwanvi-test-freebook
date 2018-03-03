package 构造器_重载_方法_空指针;
/**
 * this()
 * 调用本类的其他构造器
 * 按照参数调用构造器，必须在构造器中使用，必须在第一行使用
 * this() 与 super() 互斥
 * this. 是访问当前对象
 * this() 是调用本类构造器
 */
public class this括号 {

	public static void main(String[] args) {
		Cell c = new Cell();
		System.out.println(c.x + ","+ c.y);

	}

}
class Cell{
	int x;int y;
	public Cell(){
		this(1,1);//调用本类的其他构造器
		//this("a");
	}
	public Cell(int x,int y){
		this.x = x ; this .y = y;
	}
	public Cell(String a){
		
	}
}