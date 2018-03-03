package Collection_集合;

import java.util.List;
import java.util.ArrayList;

/**
 * List元素的修改与查询
 * @author Administrator
 *
 */
public class List元素的修改与查询 {

	public static void main(String[] args) {
		/**
		 * 想获取集合中的元素我们可以使用get()方法
		 * Object get(int index);
		 * 根据元素下标获取对应位置的元素并返回
		 * 这里元素下标和数组相似。
		 */
		List list = new ArrayList();
		list.add("One");
		list.add("Two");
		list.add("Three");
		
		//因为get方法是以Object类型返回的元素，所以需要造型
		String element = (String)list.get(2);
		System.out.println(element);
		//遍历集合
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		/**
		 * set 方法，用于修改集合中的元素
		 * Object set(int index,Object new Element);
		 * 将index位置的元素修改为newElement，修改后会将被修改的元素返回
		 * 将“three”替换为“三”
		 */
		Object old = list.set(2, "三");
		System.out.println("被替换的元素："+old);
		
		System.out.println(list);
		
		/**
		 * 向集合中插入一个元素
		 * add(int index,Object new Element);
		 * 使用add的重载方法，我们可以向index指定位置插入newElement
		 * 原位置的元素自动向后移动
		 * 
		 * 在One Two与三之间插入一个“二”
		 */
		list.add(2, "二");
		System.out.println(list);
		
		/**
		 * 根据下标删除元素
		 *Object remove(int index)
		 * 将集合中下标为index的元素删除
		 */
		Object obj = list.remove(2);
		System.out.println("被删除的元素："+obj);
		System.out.println(list);

	}

}
