package 数组;

import java.util.Arrays;

/**
 * 二分查找
 * @author Administrator
 *
 */
public class 二分查找 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] names={"Tom","Lii","Jerry","Andy","John","Robin"};	
		//查找Tom的位置
		//错误的使用二分查找:返回值不确定
		int index = Arrays.binarySearch(names, "Tom");
		System.out.println(index);
		//正确使用二分查找:必须在有序 上使用二分查找
		Arrays.sort(names);//排序
		index = Arrays.binarySearch(names,"Tom" );
		System.out.println(index+" "+names[Arrays.binarySearch(names,"Tom" )] );
		
		index = Arrays.binarySearch(names, "Lia");
		System.out.println(index);//返回结果小于0表示没有找到！
	}
	
}
