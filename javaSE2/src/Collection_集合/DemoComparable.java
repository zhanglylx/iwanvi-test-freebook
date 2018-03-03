package Collection_集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 测试集合工具类对集合元素进行的自然排序
 * 要确保集合中的元素是Cpmparable的子类！
 * @author Administrator
 *
 */
public class DemoComparable {

	public static void main(String[] args) {
		//创建Comparable接口实例
		List<Comparable接口> list = 
					new ArrayList<Comparable接口>();
		//向集合中存放3个对象
		list.add(new Comparable接口(1,5));
		list.add(new Comparable接口(3,4));
		list.add(new Comparable接口(2,2));
		//输出顺序与存放时一致
		System.out.println(list.toString());
		/**
		 * 使用集合工具类对集合进行自然排序
		 * 该方法会一次调用集合中每个元素的compareTo方法
		 * 进行比较
		 */
		Collections.sort(list);
		System.out.println(list);
		
		/**
		 * 在排序集合元素时，我们不想根据元素的比较规则来进行排序
		 * 排序：按照X值自小至大的顺序排序集合元素
		 *   1：定义一个类并实现Comparator接口
		 *   2：实现接口中的抽象方法compareTo(E o1,E o2)
		 *   3:实例化这个比较器
		 *   4:调用Collections的重载方法
		 *   	sort(Collection c , Comparator comparator)进行排序
		 *   
		 *   使用匿名类方式创建一个实例来定义比较器
		 */
		Comparator<Comparable接口> c = new Comparator<Comparable接口>(){

			/**
			 * 自定义的比较规则
			 * @author Administrator
			 * @return 等于0:o1==o2 大于0:o1>o2  小于0:o1<o2
			 */ 
			public int compare(Comparable接口 o1, Comparable接口 o2) {
				// TODO Auto-generated method stub
				return o1.getX() - o2.getX();
			}
			
		};
		Collections.sort(list,c);
		System.out.println(list);
	}

}
