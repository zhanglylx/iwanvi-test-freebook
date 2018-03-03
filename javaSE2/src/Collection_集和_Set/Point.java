package Collection_集和_Set;

public class Point {
	private int x;
	private int y;
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public String toString(){
		/**
		 * 重写toString方法，返回的字符串用于描述当前对象
		 * 这个对象保存的是一个点的信息，所以告知外界x,y的坐标
		 */
		return "x="+this.x+",y="+y;
	}
	public static void main(String[] args){
		/**
		 * 不能直接使用toString()方法，因为该方法不是静态的
		 * java语法规定：
		 * 静态方法中不能直接引用非静态的属性和方法
		 * System.out.printls(toString());
		 * 非静态方法中可以直接引用静态属性和方法
		 */
		Point point = new Point(5,3);
		System.out.println(point.toString());
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Point other = (Point) obj;
//		if (x != other.x)
//			return false;
//		if (y != other.y)
//			return false;
//		return true;
//	}
//	
//	
	
	
//	public boolean equals(Object obj){
//		/**
//		 * 直接将Object转为子类是存在风险的！
//		 * 我们不能保证Object和我们要比较的对象是同一个类型
//		 * 这会引发ClassCastException!我们称为[类造型异常]
//		 */
//		Point p = (Point)obj;
//		return this.x == p.x && this.y == p.y;
//	}
}

