package Collection_集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 自定义比较器联系 {
	public static void main(String [] args){
		/**
		 * 定义一个字符串集合
		 * 集合中存放:"Tom","Jerry","Boss","Killer","Kack","Clark"
		 * 使用自然排序查看排序结果
		 * 自定义排序规则：字母长的在后面，进行排序
		 */
		List<String> list = new ArrayList<String>();
		list.add("Tom");
		list.add("Jerry");
		list.add("Boss");
		list.add("Killer");
		list.add("Kack");
		list.add("Clark");
		list.add("boss");
		/**
		 * 系统自带排序
		 */
		Collections.sort(list);
		System.out.println(list.toString());
		/**
		 * 自定义排序
		 */
		Collections.sort(list,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				
				return  o1.length() - o2.length() ;
			}
		});
		System.out.println(list.toString());
	}
	
}
