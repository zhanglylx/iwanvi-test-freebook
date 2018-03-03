package 抽象类;
/**
 * 抽象类，用于表示抽象概念，这里表示抽象的“图形”概念
 * 包含抽象方法的类一定是抽象类
 * 抽象类可以定义变量，抽象类不能直接实例化，抽象只能被继承
 * 具体类在继承抽象类时候必须实现全部的抽象方法
 * @author Administrator
 *
 */
public abstract class Shape {
	protected int x;
	protected int y;
	/**  具体方法，有方法体 */
	public void up(){
		y--;
	}
	/** 抽象方法，没有方法 */
	public abstract boolean contains(int x,int y);
}
