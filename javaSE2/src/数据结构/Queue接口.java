package 数据结构;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数据结构:队列
 * Quene接口：   java.util.Queue
 * 		offer:将元素放入队列
 * 		poll：从队列中取元素 取得的是最早offer的元素
 * 			  从队列中取出元素后，该元素会从队列中删除
 * 		peek:获取队首的元素。（不删除该元素！）
 * LinkedList就是队列的子类
 * @author Administrator
 *
 */
public class Queue接口 {

	public static void main(String[] args) {
		/**
		 * 创建一个LinkedList实例，把它当做队列去看待！
		 * 同样的，队列中我们也应该只存放一种数据类型的数据
		 * 所以同样可以用泛型去约束
		 */
		Queue<String> queue = new LinkedList<String>();
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		System.out.println(queue);
		//获取对首元素，单不令其出队
		System.out.println(queue.peek());
		String element = null;
		while((element = queue.poll())!=null){
			System.out.println(element);
		}
		/**
		 * 队列本着先进先出原则存放数据(FIFO)
		 * 队列不支持插队，插队是不道德的。
		 */

	}

}
