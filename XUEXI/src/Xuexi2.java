import java.util.Scanner;	//引入扫面器
public class Xuexi2{	//声明类
	private String name;
	private String language;
	public static void main(String[]args){	//创建主方法
		Scanner scan=new Scanner(System.in);	//创建扫描器
        System.out.println("请输入员工的姓名");	//提示员工输入姓名
        String name=scan.nextLine();	//使用变量name接收用户输入的姓名
        System.out.println("请输入新员工应聘的语言");	//提示员工输入应聘的语言
        String language=scan.nextLine();	//使用变量language接收用户输入的语言
        int a=0;	//给a赋初值
        int resume1=1;    //
		do {	//创建循环体来循环检测员工应聘的语言
			if (resume1==0){			
		        System.out.println("请再次输入员工的姓名");	//提示员工输入姓名
		        String name1=scan.nextLine();	//使用变量name接收用户输入的姓名
		        System.out.println("请再次输入新员工应聘的语言");	//提示员工输入应聘的语言
		        String language1=scan.nextLine();	//使用变量language接收用户输入的语言
		        name=name1;
		        language=language1;
			}
			switch(language.hashCode()){
				case 3254818:	//检测输入的语言是否为java程序语言
					a=1;
					break;					
				case 2301506:	//检测输入的语言是否为Java程序语言
					a=1;
					break;
				case 2269730:	//检测输入的语言是否为JAVA程序语言
					a=1;
					break;
				case 3104:	//检测输入的语言是否为c#程序语言
					a=2;
					break;
				case 2112:	//检测输入的语言是否为C#程序语言
					a=2;
					break;
				case -709190099:	//检测输入的语言是否为Asp.net程序语言
					a=3;
					break;
				case 955463181:
					a=3;
					break;
				case 9745901:	//检测输入的语言是否为Aap.net程序语言
					a=4;
					break;
				default:
					a=5;
					break;
			}
			String b = null;	//创建变量b接收程序的语言
			switch(a){	//判定a属于哪门语言复制给b
				case 1:
					b="java";
					break;
				case 2:
					b="c#";
					break;
				case 3:
					b="Asp.net";
					break;
				case 4:
					b="Aap.net";
					break;				
			}
			if (a!=5){	//判断如果存在此门语言，输出应聘成功，否则输出重新应聘
			System.out.println("员工："+name+"被分配到了"+b+"程序开发部门");
			System.out.println("输入\"是\"继续输入，输入其他字符，程序关闭");
			String resume=scan.nextLine();	//接收用户是否继续输入
			a=(resume.equals("是"))?0:5;    //输入是，继续执行循环体
			resume1=a;   
			}else{
			System.out.println("没有这门语言，请重新应聘");
			a=4;       //给a赋值继续执行循环体
			resume1=0; //给resume1赋值，执行循环体中的再次输入语句
			}			
		}while(a !=5); //当a的值不为5时，继续执行循环体
		System.out.println("程序关闭");
	}
	
}
