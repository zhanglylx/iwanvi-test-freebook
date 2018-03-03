package Collection_集合;
/**
 * 测试ArrayList中元素的equals
 */
import java.util.ArrayList;
import java.util.List;

public class TestArrayList1 {

	public static void main(String[] args) {
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		List list3 = new ArrayList();
		//为第一个集合添加元素
		list1.add("One");
		list1.add("Two");
		list1.add("Three");
		//为第二个集合添加元素
		list2.add("Four");
		list2.add("Five");
		//为第三个集合添加元素
		list3.add("One");
		list3.add("Two");
		/**
		 * 将集合2的元素存放到集合1中
		 * 集合的addAll(Collection c)
		 * 该方法允许将c对应的集合中的所有元素存入该集合
		 * 注意：这里的参数为Collection，所以换句话说，任何集合
		 * 类型都可以将元素存入其他集合中！
		 */
		list1.addAll(list2);
		System.out.println(list1);
		/**
		 * 删除给定集合与当前的交集部分
		 * equals为true的
		 */
		list1.removeAll(list3);
		System.out.println(list1);
		//取交集(equals为false的)
		list1.retainAll(list2);
		System.out.println(list1);
	}

}
