package 方法;
/**
 * 方法的定义
 * 1. 方法在类中(类体中)定义
 * 什么是方法：可以重复使用的算法功能
 * y = max(5，max(7,8));
 * 参数:方法计算的前提条件
 * 返回值:返回计算结果
 */
public class 方法的定义 {
	/**
	 * 计算x，y中的最大值
	 * 方法名：与功能命名一致，一般使用动词命名！
	 * 一般使用小写字母开头，第二个单词开始，单词首字母大写
	 * 如：saveOrder()
	 * 返回值:方法必须定义返回值，如果无返回值定义void
	 *  如果定义了返回值，在方法中必须使用return语句返回数据
	 * @param x
	 * @param y
	 * @return
	 * 如下是方法的声明(定义),方法定义在类体中
	 */
    public static int max(int x, int y){
    	int z = x>y?x:y;
    	return z;
   
    }

	public static void main(String[] args){
		//方法的调用:使用方法吗和参数列表调用方法 max(3,4)
		//max(3) ; //编译错误:没有max(int)的方法
		max(10,3);//调用了方法max(int,int),丢弃了返回值
		int n = max(10,3);//接收了返回值
		System.out.println(n);
		int a =5 ;
		int y = 6;
		int z = max(a,y);
		System.out.println(z);
	}
}