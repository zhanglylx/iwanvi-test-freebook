package 数组;
/** 
 *访问数组元素
 *
 */
public class 访问数组元素 {

	public static void main(String[] args) {
		int[] ary = new int[]{2,4,5};
		//数组的长度属性length
		//System.out.println(ary.length);//3
		//数组的下标范围 0,1,2 最后一个元素的位置 length-1
		//超过数组下标范围访问会出现异常，运行异常
		System.out.println(ary[ary.length-1]);
		ary[0]=8;//修改数组元素
		ary[1]++;
		System.out.println(ary[0]);
		System.out.println(ary[1]);

	}

}
