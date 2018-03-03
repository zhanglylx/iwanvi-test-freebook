package Map集合;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 遍历HashMap
 * 方法1：获取所有的key并根据key获取value从而达到遍历的效果
 * 
 * HashMap获取所有key的方法:KeySet()
 * 该方法可以获取保存在该map下所有的key并以Set集合的形式返回
 *
 */
public class 遍历HashMap {
	public static void main (String [] args){
		Map<String,Point> map = new LinkedHashMap<String,Point>();
		
		map.put("1,2", new Point(1,2));
		map.put("2,3", new Point(2,3));
		map.put("3,4", new Point(3,4));
		map.put("4,5", new Point(4,5));
		
		/**
		 * 获取当前map中所有的key
		 * 因为Key在HashMap的泛型中规定了类型为String
		 * 所以返回的Set中的元素也有是String，为了更好的使用
		 * 我们在定义Set类型变量时也应该加上泛型
		 */
		Set<String> keyset = map.keySet();
		/**
		 * 遍历所有的key，根据key去map中获取对应的value
		 */
		for(String key : keyset){
			Point p = map.get(key);//根据key获取value
			System.out.println(key+":"+p.getX()+","+p.getY());
		}
		//使用普通for循环
		for(Iterator<String> it = keyset.iterator()
				;
				it.hasNext()
				;){
			String key = it.next();
			Point p = map.get(key);
			System.out.println(key+":"+p.getX()+","+p.getY());
		}
		
	}
}
