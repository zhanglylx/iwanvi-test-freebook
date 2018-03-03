package 数据结构;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈数据结构
 * Deque
 * @author Administrator
 *		push:压入   向栈中存入数据
 *		pop :弹出   从栈中取出数据
 *		peek:获取栈顶位置的元素，但不取出
 *栈结构本着先进后出原则(FILO)
 *例如：子弹夹就是一种栈结构
 *
 *LinkedList也是实现了Deque接口
 *
 */
public class 栈数据结构 {

	public static void main(String[] args) {
		/**
		 * 创建一个栈结构保存字符
		 */
		Deque<Character> deque = new LinkedList<Character>();
		for(int i=0;i<5;i++){
			deque.push((char)('A'+i));
		}
		System.out.println(deque);
		/**
		 * 注意：
		 * 		我们在使用pop获取栈顶元素之前，应先使用peek方法获取该元素，
		 * 		确定该元素不为null的情况下才应该将该元素从栈中“弹出”。否则
		 * 		若栈中没有元素后，我们调用pop会抛出异常"NoSuchElementException"
		 */
		//注意使用peek判断栈顶是否有元素
		while(deque.peek()!=null){
			System.out.println(deque.pop()+"");
		}
	}

}
