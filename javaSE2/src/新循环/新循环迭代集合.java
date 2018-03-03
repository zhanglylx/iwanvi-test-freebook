package 新循环;

import java.util.ArrayList;

public class 新循环迭代集合 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("赵六");
		/**
		 * 使用新循环来遍历集合
		 * 注意：
		 * 		集合若使用新循环，应该为其定义泛型，否则我们只能
		 * 		使用Object作为接收元素时的类型。
		 * 		通常情况下，集合都要加泛型。
		 */
		for(String str : list){
			System.out.println(str);
		}
		

	}

}
