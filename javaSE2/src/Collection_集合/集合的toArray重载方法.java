package Collection_集合;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合的toArray()
 * @author Administrator
 *
 */
public class 集合的toArray重载方法 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Point(1,2));
		list.add(new Point(3,4));
		list.add(new Point(5,6));
		/**
		 * toArray的重载方法，可以很方便的让我们转换出实际的数组类型
		 * 参数的作用是作为返回值数组的类型，所以参数传入的数组
		 * 不需要有任何长度，因为用不到，就没有必要浪费空间-
		 */
//		Object[] array = list.toArray();
		Point[] array = (Point[])list.toArray(new Point[0]);
		for(int i = 0;i<array.length;i++){
			Point p =array[i];
			System.out.println(p.getX());
		}
	}

}
