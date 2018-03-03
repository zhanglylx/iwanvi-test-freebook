package 包装类;
/**
 * int类型的Integer包装类
 * @author Administrator
 * 
 *
 */
public class DemoInteger {

	public static void main(String[] args) {
			/**
		 	* 用于将基本类型数据当做引用类型看待。
		 	*	八个基本类型都有其对应的引用类型
			*	例如:Integer i = new Integer(1);
			*	创建一个以对象形式存在的整形1.
			*	这种从基本类型转换为引用类型的过程称之为“装箱”。反之叫"拆箱"
			*	拆箱方法:
			*	int a = i.intValues();
			*/
		DemoInteger demo = new DemoInteger();
		say(demo);
		int a=1;
		say(a);//在java1.4版本的时候，这里还是语法错误的！
		/**
		 * 实例化一个对象，该对象代表整数1
		 * Integer的作用是让基本类型int作为一个引用类型去看待。
		 * 这样就可以参与到面向对象的编程方式了
		 * 由此我们可以将一个int当做一个Object去看到了。
		 */
		//装箱
		//方法1:
		Integer i = new Integer(a);
		//方法2:
		Integer s = Integer.valueOf(a);
		say(i);//在Integer是Object的子类，可以调用！
		//拆箱
		int n = i.intValue();
		/**
		 * java 1.5包装类自动拆装箱
		 * 在编译源程序的时候，编译器会预处理。将未做拆箱和装箱
		 * 工作的语句自动拆箱和装箱。
		 */
		//自动装箱
		say(Integer.valueOf(i));
		//自定拆箱
		Integer g= 0;
		int num =  g;
	}
	/**
	 * 输出对象的toString()方法的返回值
	 * @param obj
	 */
	public static void say(Object obj){
		System.out.println(obj);
	}

}
