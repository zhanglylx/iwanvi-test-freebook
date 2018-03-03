package 抽象类;

public class Circle extends Shape {
	private int r;
	public Circle(){
		
	}
	public Circle(int x,int y,int r){
		this.r = r;
		this.x = x;
		this.y = y;
	}
	/** 实现了抽象类Shape中的抽象方法 */
	public boolean contains(int x, int y) {
		int a = this.x - x;
		int b = this.y - y;
		double c = Math.sqrt(a*a + b*b);
		return c <=r;
	}

}
