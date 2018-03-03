package equals;

public class TestEquals {
	/*
	 *重写Object继承过来的该方法，用于定义对象内容比较规则 
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(2,3);
		Point p2 = new Point(2,3);
		/**
		 *  == 比较的双方的值是否相等
		 *  p1和p2是两个引用类型变量，而引用类型变量保存的是对象
		 *  的句柄(对象的地址hashcode值).
		 *	==在对象比对时，描述的是p1和p2是否为同一个对象！
		 *  
		 *  equals方法力图去描述两个对象内容是否相等
		 *  内容相等取决于业务逻辑需要，可以自行定义比较规则.
		 */
		if(p1==p2){
			System.out.println("两个点相等");
		}else{
			System.out.println("两个点不相等");
			System.out.println("点1:"+p1);
			System.out.println("点2:"+p2);
		}
		
		if(p1.equals(p2)){
			System.out.println("两个点相等");
		}else{
			System.out.println("两个点不相等");
			System.out.println("点1:"+p1);
			System.out.println("点2:"+p2);
		}
		
		TestEquals p3 = new TestEquals();
		if(p1.equals(p3)){
			System.out.println("两个点相等");
		}else{
			System.out.println("两个点不相等");
		}
		Point p4= null;
		if(p1.equals(p4)){}
		
	}

}
class Point {
	private int x;
	private int y;
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public boolean equals(Object obj){
		/**
		 * 		若给的对象obj的地址和当前对象地址一致，那么他们是
		 * 同一个对象，equals肯定要返回true！自己一定像自己！
		 * 		当我们在equals方法中有大量的内容比较逻辑，加上这个
		 * 判断会节省性能的开销
		 */
		if(this == obj){
			return true;
		}
		/**
		 * equals比较前要进行安全验证，确保给定的对象不是null！
		 * obj如果是null，说明该引用变量没有指向任何对象，那么就不能引用
		 * obj所指向的对象(因为对象不存在)的属性或方法！
		 * 如果这么做就会引发NullPointerException,空指针异常！
		 */
		if(obj == null){
			return false;
		}
		/**
		 * 直接将Object转为子类是存在风险的！
		 * 我们不能保证Object和我们要比较的对象是同一个类型
		 * 这会引发ClassCastException!我们称为[类造型异常]
		 */
		//重写equals时第一件要做的事情就是判断给定的对象是否和当前
		//对象为同一个类型，不是同类型直接返回false,不具备可比性
		if(!(obj instanceof Point)){
			return false;
		}
		Point p = (Point)obj;
		return this.x == p.x && this.y == p.y;
	}
}


