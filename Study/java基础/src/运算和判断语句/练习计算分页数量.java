package 运算和判断语句;
import java.util.Scanner;
/**
 * 计算分页数量
 * 查询结果rows为：36行
 * 如果每页有10行，size
 * 计算分页以后的数量
 * 分析:如果行数能够被页数整除，就直接 rows/size
 *     否则就  rows/size +1
 * 
 * @author Administrator
 *
 */

public class 练习计算分页数量 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("请输入行数");
		Scanner rows=new Scanner(System.in);
		int number = rows.nextInt();
		int size =10;
		int page = number/size;
		// int page = number/size == 0 ？number/size:number/size+1；
		if ((number % size != 0)){
			page = page +1;
		}
		System.out.println("页数为:"+page);
	}

}
