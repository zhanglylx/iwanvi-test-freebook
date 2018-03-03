package 继承;
/*
 * 图形  类型 其中x，y代表图形的位置
 * 图形作为父类型，被圆和矩形继承
 */
public class Shape {
	int x;
	int y;
	/*
	 * 图形向上移动的方法
	 */
	public void up(){
		y--;
	}
	public void up(int dy){	
		y-=dy;
	}
	public void up(int x,int y){
		this.y++;
	}
}
