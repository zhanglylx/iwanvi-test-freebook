package 循环;
/**
 * 
 * 1 ->2 ->3 ->4 ->2 ->3 ->4 ->2 ->3
 *for 语句中3个表达式可以适当的省略不写 
 *for 经常用于执行计次数
 *for 的灵活运用
 *1.for(;;)是死循环 与 while(true)一样，在死循环中
 *	经常利用break结束循环过程
 *2.for(;布尔表达式;)与 while(布尔表达式)一致
 */
public class for循环结构 {

	public static void main(String[] args) {
		//第一种写法
		//i 变量的作用域，在for内部有效
		//变量的作用域，越小越好
		for (int i=0/*1*/;i<10/*2*/;i++/*4*/){
			System.out.println(i);/*3*/
		}
		//第二种写法
		//i 变量的作用域，是main方法中有效
		int i=1;
		for(;i<10;i++){
			System.out.println(i);
		}
		System.out.println(i);//11  循环是在不满足条件时候结束的！
	}

}
