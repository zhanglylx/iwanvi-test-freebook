package Collection_集和_Set;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试hashCode对HashSet的影响
 * @author Administrator
 *
 */
public class DemoHashSet {

	public static void main(String[] args) {
		Set<生成hashCode与equals方法> set = new HashSet<生成hashCode与equals方法>();
		set.add(new 生成hashCode与equals方法(1, 2));
		set.add(new 生成hashCode与equals方法(3, 4));
		/**
		 * 查看新创建的对象是否在set中被包含
		 * 虽然这里是新创建的对象，但是通过散列算法找到了位置后
		 * 和里面存放的元素进行equals比较为true，所以依然认为是
		 * 被包含的
		 * 
		 * 若我们不重写hashCode，那么使用的就是Object提供的
		 * 该方法是返回句柄！换句话说，不同的对象hashCode不同
		 */
		System.out.println(set.contains(new 生成hashCode与equals方法(1, 2)));
	
	
	
	
	
	}

}
