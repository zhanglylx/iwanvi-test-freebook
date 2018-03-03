package Collection_集和_Set;

import java.util.HashSet;
import java.util.Set;

public class HashSet特点 {

	public static void main(String[] args) {
		/**
		 * 定义一个Set集合，允许里面存放Point实例
		 */
		Set<Point> set = new HashSet<Point>();
		/**
		 * 创建两个内容一样的对象
		 */
		Point p1 = new Point(1,2);
		Point p2 = new Point(1,2);
		System.out.println("p1和p2是否为同一个对象"+ (p1 == p2));
		System.out.println("p1和p2内容是否一样："+p1.equals(p2));
		System.out.println("p1和p2的hashCode是否一样:"+(p1.hashCode()==p2.hashCode()));
		/**
		 * 将两个对象同时使用HashSet集合，查看结果
		 */
		set.add(p1);
		set.add(p2);
		System.out.println("hashSet集合的元素数"+set.size());
		for(Point p : set){
			System.out.println(p);
		}
		/**
		 * 当我们重写了Point的equals方法和hashCode方法后我们发现
		 * 虽然p1和p2是两个对象，但是当我们将他们同时存入集合时，p2
		 * 对象并没有被添加进集合，因为p1在存入后，p2放入时根据p2
		 * 的hashCode计算的位置中p2与该位置的p1的equals比较为true，
		 * hashSet认为该对象已经存在，所以拒绝将p2存入集合
		 */
		/**
		 * 若我们不重写Point的hashCode方法，但是重写的equals方法
		 * 两个对象都可以放入HashSet集合中。因为。两个对象具有不同的hashcode值，
		 * 那么当他们在放入集合时通过hashcode值进行的散列算法结果就不相同，那么他们
		 * 会被放入集合的不同位置。位置不相同，HashSet则认为他们不同，所以他们可以全部
		 * 被存入集合。
		 */
		//清除集合
		set.clear();
		System.out.println("若不重写hashCode方法，添加的效果");
		set.add(p1);
		set.add(p2);
		System.out.println("set集合的元素数："+set.size());
		for(Point p : set){
			System.out.println(p);
		}
		set.clear();
		System.out.println("清空集合");
		/**
		 * 若我们重写了hashCode但是不重写equals方法
		 * hashCode相同的情况下，在存放元素时，他们会在相同的位置，
		 * HashSet会在相同位置上将后放入的对象与该位置其他对象依次进行
		 * equals比较，若不相同，则将其存入。
		 * 在同一个位置存入若干元素，这些元素会被放入一个链表中
		 * 由此可以看出。我们应该尽量使得多有类的不同对象的hashcode值不同。
		 * 这样才可以提高HashSet在检索元素时的效率！否则可能检索效率还不如List
		 */
		set.add(p1);
		set.add(p2);
		System.out.println("集合中的元素数:"+set.size());
		for(Point p : set){
			System.out.println(p);
		}
		/**
		 * 结论：
		 * 使用HashSet集合存放元素时，应保证：equals与hashCode方法在api上定义的要求
		 * 存放规则：不同对象存放时，不会保存hashCode相同并且equals相同的对象。缺一不可。
		 * 否则HashSet不认为他们是重复对象。
		 */
	}

}
