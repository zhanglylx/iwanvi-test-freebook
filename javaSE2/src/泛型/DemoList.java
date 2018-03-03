package 泛型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * 泛型
 * 使用ArraysList举例
 * @author Administrator
 *
 */
public class DemoList {

	public static void main(String[] args) {
		/**
		 * ArrayList支持泛型
		 */
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(1,2));
		list.add(new Point(2,3));
		list.add(new Point(4,5));
		//list.add("哈哈哈");
		for(int i =0;i<list.size();i++){
			Point p = list.get(i);
			System.out.println(p.toString());
		}	
		/**
		 * 迭代器也支持泛型，但是迭代器使用的泛型应该和他所
		 * 迭代的集合的泛型类型一致
		 */
		Iterator<Point> it = list.iterator();
		while(it.hasNext()){
			Point p = it.next();
			System.out.println(p);
		}
	}

}
