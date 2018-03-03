package 数组;
/**
 * 数组的迭代
 * 迭代：遍历，就是将数组元素逐一处理一遍的方法
 */
public class 数组的迭代 {

	public static void main(String[] args) {
		int[] ary = {1,1,2,3,5,8,13,21,34,55};
		//i = 0 < length
		int sum=0;
		for(int i = 0 ; i <ary.length;i++){
			// i = 0 1 2 ...9 代表数组的每个序号
			//ary[i] = 1 1 2 ...55 代表数组中每个元素
			int n = ary[i]; // n 是数组中每个元素
			System.out.println(i+":"+n);//0:1
			sum+=n;
		}
		System.out.println(sum);

	}

}
