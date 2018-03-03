package 运算和判断语句;
/**
 * 自增自减运算
 * ++ --
 * 
 * 
 * 
 */

public class 自增自减运算 {
	public static void main(String[] args){
		int a=1;
		a++;
		++a;
		System.out.println(a);//3
		a = 1;
		int b = a++;//后++，先用a 然后+1
		// 上述表达的运算步骤：
		// 1 取a的值1作为(a++)的结果1
		// 2 将a增加1 a为2
		// 3 执行赋值运算，将(a++)结果1 赋值给b
		System.out.println(a+","+b);
		a = 1;
		b = ++a;//先++，先+1,然后用a
		// 步骤，先执行++,然后执行赋值运算
		//运算优先级:与数学规则一致
		// ++ -- 优先级高于乘除
		int x = 5; int y=6;
		y = y + --x * y++ + y;
		//  6 + 4 * 6 + 7 ;
		//  6 + 24 +7;
		//  37
		System.out.println(y);		
	}
}
