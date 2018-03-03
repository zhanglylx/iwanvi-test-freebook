package Map集合;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 数据结构
 * 存放数据以 Key-value的形式成对保存
 * Map保存的数据可以重复，但是Key不可以
 * 若重复保存相同的key的value时，实际的操作是替换value操作。
 * 
 * 同时这样的数据结构在存放数据时不建议存放两种以上的数据类型，
 * 所以通常我们在使用Map时也要使用泛型约束存储内容的类型
 * @author Administrator
 *
 */
public class DemoMap {
	public static void main(String[] args){
		/**
		 * 创建Map时使用泛型。这里要约束两个类型，一个是key的类型，一个是value的类型
		 * 
		 * 创建一个Key为字符串value为Point的Map
		 */
		Map<String,Point> map = new HashMap<String,Point>();
		/**
		 * 使用put方法将元素以key的形式放入map
		 */
		map.put("1,2", new Point(1,2));
		map.put("3,4", new Point(3,4));
		/**
		 * 注意，因为map中已存在了key为"1,2"的元素，若再次以该key存放数据，那么Point(5,6)会替换
		 * 之前的Point(1,2)!
		 */
		map.put("1,2", new Point(5,6));
		/**
		 * 获取map中的元素使用get方法
		 * V get(K key)：传入对应的key获取其对应的Value
		 */
		Point p = map.get("1,2");
		System.out.println("x="+p.getX() + ",y="+p.getY());
		/**
		 * 若给定的key在map中不存在则返回null！
		 * 所以，原则上在从map中获取元素时要先判断是否有该元素
		 * 有在使用，避免空指针异常的出现。
		 */
		/**
		 * Map在获取元素时非常有针对性
		 * 集合向获取元素需要遍历集合内容。而Map不需要。只要给它特定的key就可以获取该元素
		 */
		p = map.get("haha");
		System.out.println("x="+p.getX() + ",y="+p.getY());//报错
	}
}
