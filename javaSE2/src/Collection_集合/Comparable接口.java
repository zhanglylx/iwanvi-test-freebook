package Collection_集合;
/**
 * 可比较的点
 * 若我们定义的类想在数组或集合中可以排序，我们需要将当前类实现
 * Comparable接口，并定义比较规则
 * 
 * @author Administrator
 *
 */

public class Comparable接口 
						implements Comparable<Comparable接口> {
	/**
	 * 属性定义
	 */
	private int x;
	private int y;
	public Comparable接口(int x,int y){
		this.x = x;
		this.y = y;
	}
	/**
	 * 比较方法，该方法由Comparable接口定义
	 * 所有子类均需要实现该方法来定义比较规则
	 * 
	 * 比较规则：
	 * 		比较点到原点的距离，谁的距离长谁大
	 */
	public int compareTo(Comparable接口 o){
		//自身点到原点的距离
		int r = x * x + y* y;
		//参数点到原点的距离
		int other = o.x * o.x + o.y * o.y;
		/**
		 * 返回结果大于0，自身比参数大
		 *       小于0 ， 自身比参数小
		 *       等于0，自身和参数相等
		 * 需要注意：
		 * 		equals返回true的时候，
		 * 		comparaTo的返回值应该为0
		 * 		反过来也一样 
		 */
		return r - other;
	}
	public String toString(){
		return "x="+x+",y="+y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	
}
