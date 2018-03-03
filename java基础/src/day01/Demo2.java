package day01;
/**
 * 变量的作用域
 * 变量在声音的地方开始，到块结束
 * 一对{}叫做块
 */
public class Demo2 {
	public static void main(String[] args){
		int x=8;
		System.out.println(x);
		{
			int y=9;
			//y在块里有效
		}
	}
}
