package Map集合;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 迭代map的方式2
 * 以“键值对”的形式迭代
 * 
 * map支持另一个方法entrySet()
 * 该方法返回一个Set集合，里面的元素是map中的每一组键值对
 * map以Entry类的实例来描述每一个键值对
 * 
 * Entry描述一个键值对
 * 其有两个方法：
 *    	getKey() :获取key值
 *    	getValue():获取value值
 *
 */
public class 遍历HashMap2 {

	public static void main(String[] args) {
		/**
		 * LinkedHashMap:
		 * 		用法和HashMap相同，内部维护着一个链表。可以使其存放
		 * 	元素时的顺序与迭代时一致。
		 */
		Map<String,Point> map = new LinkedHashMap<String,Point>();
		
		map.put("1,2", new Point(1,2));
		map.put("2,3", new Point(2,3));
		map.put("3,4", new Point(3,4));
		map.put("4,5", new Point(4,5));
		/**
		 * 使用entrySet()遍历map
		 * 获取map中所有的键值对
		 * Set的泛型不会变，就是Entry
		 * 
		 * Entry所在位置 ： java.util.Map.Entry
		 * Entry也需要泛型的约束。其约束的泛型应该和Map相同！
		 * 因为一个Entry实例保存着这个Map中的一组键值对。
		 */
		Set<Entry<String,Point>> entrySet = map.entrySet();
		/**
		 * 遍历键值对
		 */
		for(Entry<String,Point> entry : entrySet){
			//获取key
			String key = entry.getKey();
			//获取value
			Point p = entry.getValue();
			System.out.println(key + ":" + p.getX()+","+p.getY());
		}
		
	}

}
