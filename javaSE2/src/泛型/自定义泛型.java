package 泛型;
/**
 * 自定义泛型
 * @author Administrator
 *
 */
public class 自定义泛型 {

	public static void main(String[] args) {
		//请到Point查看泛型自定义
		Point<Double,Long> p = new Point<Double,Long>(1.1,2L);
		System.out.println(p);
	}

}
