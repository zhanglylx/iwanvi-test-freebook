package day01;
/**
 * 变量不能重复声明(声明==定义)
 * 在同一个作用域中不能重复声明变量
 * 一对{}为作用域
 */
public class Demo3 {

	public static void main(String[] args) {
		int age=12;  //年龄
		System.out.println(age);
		//int age =15;//编译错误，变量重复声明
		age=15;//变量的赋值
		{
			//int age=18;//编译错误，变量重复声明
			int rank=12;//rank  点数
			System.out.println(rank);
		}
		int rank=18;//离开作用域可定义
		System.out.println(rank);
	}

}
