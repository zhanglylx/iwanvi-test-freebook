package 泛型;

public class Point<E,Y> {
	private E x;
	private Y y;
	public Point(E x,Y y){
		this.x=x;
		this.y=y;
	}
	
	
	public E getX() {
		return x;
	}


	public void setX(E x) {
		this.x = x;
	}


	public Y getY() {
		return y;
	}


	public void setY(Y y) {
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
	public boolean equals(Object obj){
		/**
		 * 直接将Object转为子类是存在风险的！
		 * 我们不能保证Object和我们要比较的对象是同一个类型
		 * 这会引发ClassCastException!我们称为[类造型异常]
		 */
		Point p = (Point)obj;
		return this.x == p.x && this.y == p.y;
	}
}

