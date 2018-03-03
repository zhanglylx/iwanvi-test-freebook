package 设计模式;
/**
 * 单利模式
 * 任何情况下，该类只能创建一个实例
 * @author Administrator
 * 
 * 三步：
 *  	1：定义一个私有的静态的当前类的实例作为属性
 *  	2：私有化构造方法
 *  	3：定义一个静态的可以获取当前类实例的方法
 *  		这个方法中我们可以判断是否创建过实例，创建过后直接返回
 *  		从而达到单利的效果
 *
 */
public class 单利模式 {
	private static 单利模式 obj;
	private int x=0;
	/**
	 * 私有化构造方法
	 */
	private 单利模式(){
		x+=1;
	}
	public static 单利模式 get单利模式(){
		if(obj == null){
			obj = new 单利模式();
		}
		return obj;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	
	

}
