package 循环;

import java.util.Scanner;
/**
 * 注意：比较字符串是否相等，必须使用equals方法！不能使用==
 * "1".equals(cmd) 比 cmd.equals("1") 要好，后边表达式有空指针风险
 *
 */
public class while练习选择功能 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		//while(true){//死循环  可以替换成 for(;;)  与 while(true) 等价！
		for(;;){
		System.out.println("选择功能：\n\t1.查看全部; \n\t2.删除;"+
				"\n\t3.添加;  \n\t0.退出;");
		String cmd = console.nextLine();
		if("1".equals(cmd)){//"1"和 cmd是否相等
			System.out.println("查看全部");	
		}else if("0".equals(cmd)){
			System.out.println("退出");
			break;//break:打断！ 结束当前循环
		}else{
			System.out.println("命令不正确");
		}
		}
	}

}
