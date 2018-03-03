package 数组;
import java.util.Arrays;
/** 数组变长算法! 
 * 数组对象长度不可改变
 * 但是很多实际应用需要长度可变的数组
 * 可以采用复制为容量更大的新数组, 替换原数组, 实现变长操作
* */
public class 数组的扩容 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//数组变长(扩容)算法! 
		int[] a = {1,2,3};
		a= Arrays.copyOf(a, a.length+1);
		a[a.length-1]=4;
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
		
		
	int[] ary={1,2,3};
		ary=Arrays.copyOf(ary, ary.length+1);
		ary[ary.length-1]=4;
		System.out.println(Arrays.toString(ary));//[1, 2, 3, 4]
		//字符串连接原理
		char[] chs = { '中', '国' };
		chs = Arrays.copyOf(chs, chs.length + 1);
		chs[chs.length - 1] = '北';
		chs = Arrays.copyOf(chs, chs.length + 1);
		chs[chs.length - 1] = '京';
		//字符数组按照字符串打印
		System.out.println(chs);//中国北京
		//其他数组按照对象打印
		System.out.println(ary[0]);//[I@4f1d0d
		
	}

}
