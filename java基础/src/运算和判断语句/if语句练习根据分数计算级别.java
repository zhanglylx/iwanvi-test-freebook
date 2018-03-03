package 运算和判断语句;
import java.util.Scanner;
public class if语句练习根据分数计算级别 {
	public static void main (String[] args){
		Scanner scan=new Scanner(System.in);		
		System.out.println("请输入分数");
		int score = scan.nextInt(); // score: 分数
		if (score>=90){
			System.out.println("优秀");
		}else if(score >=80){
			System.out.println("良好");
		}else if (score >=70){
			System.out.println("中等");
		}else if (score >=60){
			System.out.println("及格");
		}else {
			System.out.println("不及格");
		}
	}
}
