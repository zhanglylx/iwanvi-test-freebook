package 新循环;
/**
 * 新循环
 * @author Administrator
 *
 */
public class 新循环 {

	public static void main(String[] args) {
		/**
		 * 对比新老循环在遍历数组上的差异
		 */
		int[] array = new int[]{1,2,3,4,5,6,7};
		/**
		 * 老循环：
		 * 		自己维护循环次数
		 *      循环体重自动维护获取元素的方式
		 */
		for(int i=0;i<array.length;i++){//维护循环次数
			int element = array[i];		//获取数组元素
			System.out.println(element);
		}
		/**
		 * 新循环
		 * 		自动维护循环次数(由遍历的数组或集合的长度决定)
		 * 		自动获取每次迭代的元素
		 * 新循环执行流程：
		 * 		遍历数组array中的每个元素，将元素依次赋值给element
		 * 		后进入循环体。直到所有元素均被迭代完毕后退出循环
		 * 注意事项:
		 * 		使用新循环，element的类型应与循环迭代的数组或集合中
		 * 		的元素类型一致！至少要是兼容类型。
		 * 新循环的内部实现是使用迭代器完成的Iterator
		 */
		for(int element : array){
			System.out.println(element);
		}
	}

}
