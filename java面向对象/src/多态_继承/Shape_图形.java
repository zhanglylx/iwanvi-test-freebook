package 多态_继承;
/**
 * 图形 类型 其中 x，y代表图形的位置
 * 图形作为父类型，被圆和矩形继承
 * @author Administrator
 *
 */
public class Shape_图形 {
	int x;
	int y;
	/**图形向上移动的方法*/
	public void up(int dy){
		y -= dy;
	}
	public void up(){
		y--;
	}
	/** 检查当前图形是否包含(contains)坐标(x,y)*/
	public boolean contains(int x ,int y){
		return false;
	}
	
}
