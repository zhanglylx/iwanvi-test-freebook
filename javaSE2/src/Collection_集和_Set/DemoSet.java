package Collection_集和_Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set集合 无序且不重复集
 * 常用实现类：
 * 		HashSet : 使用散列算法实现的Set集合    哈希
 * @author Administrator
 *
 */
public class DemoSet {

	public static void main(String[] args) {
		/**
		 * 实例化一个HashSet集合
		 */		
		//多态写法
		Set<String> set = new HashSet<String>();
		/**
		 * 向集合添加元素也使用add
		 * 但是add方法不是向集合末尾追加元素，因为无序
		 */
		set.add("One");
		set.add("Two");
		set.add("Three");
		/**
		 * Set集合没有get(int index)方法
		 * 我们不能像使用List那样，根据下标获取元素
		 * 想获取元素需要使用Iterator
		 */
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		/*
		 *宏观上讲：元素的顺序和存放顺序是不同的。
		 *但是在内容不变的前提下，存放顺序是相同的。
		 *但在我们使用的时候，要当做是无序的使用。 
		 */
		
		//使用新循环遍历Set集合
		for(String element: set){
			System.out.println(element);
		}
		
	}

}
