package Collection_集合;

import java.util.ArrayList;
import java.util.List;

import org.omg.Messaging.SyncScopeHelper;

/**
 * List(线性表)
 * List本身不能实例化！我们可以使用其几个子类实现
 * @author Administrator
 * 使用List我们不需要在创建的时候考虑容量
 * 集合的容量是根据其所保存的元素决定的
 * 换句话说，集合的容量是可以自动扩充的。
 *
 */
public final class List_线性表 {

	public static void main(String[] args) {
		/**
		 * 创建一个ArrayList实例
		 * List和ArrList均处于java.util包下
		 */
		List<String> list = new ArrayList<String>();
		/**
		 * add方法，向集合末尾追加一个新元素
		 * add(Object obj)
		 * 从该方法的参数定义不难看出，集合可以存放任意类型的元素
		 * 但在实际编程中我们发现，几乎不会向集合中存放一种以上不同类型的元素。
		 * 
		 */
		list.add("One");//向集合中添加一个字符串。
		list.add("Two");
		list.add("Three");
		//不建议这样的操作！尽量不在同一个集合中存放不同类型元素
		//list.add(1);
		System.out.println("集合中的元素数量："+list.size());
		/**
		 * ArrayList同样重写了toString()方法。
		 * 返回的字符串是每个元素的toString()返回值的序列
		 */
		System.out.println(list);
		//清空集合
		list.clear();
		System.out.println("清空后集合元素数量："+list.size());
	    System.out.println("集合是空的么？"+list.isEmpty());
	}

}
