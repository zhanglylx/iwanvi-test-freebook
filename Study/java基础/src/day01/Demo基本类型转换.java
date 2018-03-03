package day01;
/**
 * 基本数据类型转换
 * @author Administrator
 *
 */
public class Demo基本类型转换 {
	public static void main(String[] args){
		//自动类型
		long l=1;// 1 是int(32) 自动转化为long类型(64)位赋值给变量1
		l =1024L * 1024 *1024 * 4;
		int i=(int)l;
		System.out.println(i);//溢出了
	}

}
