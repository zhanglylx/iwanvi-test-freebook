package Collection_集合;

import java.util.ArrayList;
import java.util.List;

/*
 * 获取集合子集subList()
 */
public class 取子集 {

	public static void main(String[] args) {
		/**
		 * 创建一个集合，向集合中存放0-9的数字
		 * 
		 * 泛型定义基本类型时使用其包装类
		 */
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		System.out.println(list);
		//取子集(3-7)
		List<Integer> subList = list.subList(3, 8);
		System.out.println(subList);
		/**
		 * 若我们对自己的元素进行修改会不会影响原来的集合？
		 * 注意，我们在获取子集后，若对自己元素进行修改， 会影响
		 * 原来的集合元素。
		 */
		for(int i=0;i<subList.size();i++){
			int element = subList.get(i);
			element*=10;
			subList.set(i, element);
			//subList.set(i,subList.get(i)*10);//等同于上面三步
			
		}
		System.out.println(subList);
		System.out.println(list);//原来集合内容也被修改了
	}

}
