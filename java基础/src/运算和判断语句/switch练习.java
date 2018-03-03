package 运算和判断语句;
import java.util.Scanner;
/**
 * 请选择如下功能
 * 1.显示全部用户列表
 * 2.添加新用户
 * 3.修改用户的密码
 * 4.删除已经存在的用户
 * 0.离开系统
 * 请选择(0,1,2,3,4):?
 * @author Administrator
 *
 */
public class switch练习 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("请选择如下功能:");
		System.out.println("\t 1 显示全部用户列表");
		System.out.println("\t 2 添加新用户");
		System.out.println("\t 3 修改用户的密码");
		System.out.println("\t 4 删除已经存在的用户");
		System.out.println("\t 5 离开系统");
		System.out.println("请选择(0，1，2，3，4):");
		Scanner console = new Scanner(System.in);
		int command = console.nextInt();
		//command:命令   常见的缩写 cmd
		switch(command){
		case 0:
			System.out.println("离开系统命令");
			break;
		case 1:
			System.out.println("显示全部用户列表");
			break;
		case 2:
			System.out.println("添加新用户");
			break;
		case 3:
			System.out.println("修改用户的密码");
			break;
		case 4:
			System.out.println("删除已经存在的用户");
			break;
		default:
			System.out.println("您输入的命令不正确，系统关闭");
			
		}
	}

}
