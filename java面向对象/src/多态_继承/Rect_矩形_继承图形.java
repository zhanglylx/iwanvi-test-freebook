package 多态_继承;
/**
 * 矩形
 * 
 *
 */
public class Rect_矩形_继承图形 extends Shape_图形 {
	int width;//宽
	int height;//高
	public Rect_矩形_继承图形(int x,int y, int w, int h){
		super.x = x;//super. 访问父类中继承属性
		this.y = y;//this. 访问当前对象的，y继承与父类
		this.height = h;
		width = w;
	}
	public double area(){//计算矩形面积的方法	
		return width * height;
	}
	//重写父类方法
	public  boolean contains(int x,int y){
		int dx = x - this.x; // 0<=dx<width
		int dy = y - this.y; // 0<=dy<height
		return 0<=dx && dx<width && 0<dy && dy<height;
	}
}
