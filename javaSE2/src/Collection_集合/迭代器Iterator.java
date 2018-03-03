package Collection_集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器
 * 用于遍历集合中的元素使用
 * @author Administrator
 *
 */
public class 迭代器Iterator {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("#");
		list.add("Two");
		list.add("#");
		list.add("Three");
		list.add("#");
		/**
		 * iterator()方法
		 * 该方法会返回一个Iterator的实例类实例，用于遍历当前集合
		 * 
		 * Iterator在java.util包下
		 * 是一个接口，定义了遍历器应有的方法
		 * 不同的集合返回的Iterator不都是同一个子类实现。
		 * 了解即可
		 * 
		 * 迭代器的使用方式：先问后拿
		 * 问:boolean hashNext()
		 *    该方法询问迭代器当前集合是否还有元素
		 * 拿:Objcet next()
		 * 	   该方法会获取当前元素。
		 * 
		 * 迭代器的迭代方法是为while循环量身定制的
		 */
		Iterator<String> it = list.iterator();
		while(it.hasNext()){//集合中是否还有下一个元素
			Object element = it.next();//有就将其取出
			System.out.println(element);
		}
		/**
		 * 删除"#"
		 */
		/**
		 * 在迭代器迭代的过程中，我们不能通过集合的增删等操作
		 * 来改变集合的元素数量！否则会引发迭代异常！
		 * 若想删除迭代出来的元素，只能通过Iterator
		 */
		Iterator<String> str = list.iterator();
		while(str.hasNext()){//集合中是否还有下一个元素
			String element = (String)str.next();//有就将其取出
			if("#".equals(element)){
				//list.remove(element);//不可以！
				/**
				 * 迭代器的remove()方法可以将刚刚获取的元素从集合中
				 * 删除，但是不能重复调用两次
				 */
				str.remove();//删除当前位置的元素
			}
		}
		System.out.println(list);
	
	
	
	
	
	
	
	
	}

}
