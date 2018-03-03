package Collection_集合;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * List中的其他方法
 * @author Administrator
 *
 */
public class List中的其他方法 {

	public static void main(String[] args) {
		/**
		 * List中也有类似String的方法indexOf，lastIndexOf
		 */
		List list = new ArrayList();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("One");
		/**
		 * 0    1    2    3
		 * One Two Three One
		 */
		System.out.println(list.indexOf("One"));
		System.out.println(list.indexOf("Three"));
		System.out.println(list.lastIndexOf("One"));
		/**
		 * 如何将一个集合转换为数组？
		 * Object[] toArray()
		 * 该方法会将集合以对象数组的形式返回
		 */
		Object[] array = list.toArray();
		System.out.println(Arrays.toString(array));
		
		

		
	}

}
