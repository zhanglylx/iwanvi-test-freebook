package Collection_集合;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试ArrayList
 * @author Administrator
 *
 */
public class TestArrayList {

	public static void main(String[] args) {
		//多态的写法
		List list = new ArrayList();
		
		//正常的写法
		//ArrayList arrayList = new ArrayList();
	
		list.add( new Point(1,2));
		list.add( new Point(3,4));
		list.add( new Point(5,6));
		
		System.out.println(list);
		Point s = (Point) list.get(0);
		System.out.println(s.toString());
		//创建一个Point对象
		Point p = new Point(1,2);
		/**
		 * contains(Object obj)方法检查给定对象是否被包含在集合中
		 * 检查规则是obj对象与集合中每个元素进行equals比较
		 * 若equals返回true，则该方法返回true
		 * 若比对了所有元素均没有equals为true的则返回false
		 */
		System.out.println("p在集合中存在吗？"+list.contains(p));
		/**
		 * 被存放的元素equals方法在集合中决定的事情还很多！
		 * 是否重写元素的equals方法对集合的操作结果有很大的效果
		 */
		/**
		 * 删除一个元素
		 */
		System.out.println("删除前元素数："+list.size());
		list.remove(p);//将p对象删除
		System.out.println("删除后元素数："+list.size());
	}

}
