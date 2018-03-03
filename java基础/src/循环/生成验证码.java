package 循环;
import java.util.Random; //导入随机方法Random
import java.util.Scanner; //导入方法Scanner
public class 生成验证码 {
	public  static void main (String[] args){ //主方法
		while(true){
		Random rand=new Random();  //new一个随机方法
		char  chaA=('a');
		char[] c=new char[4];        //创建数组，用于存入随机生成的验证码
		for (int i=1;i<5;i++){           //循环4此随机生成验证码
		int a=rand.nextInt(26);   //生成随机数
		int b=rand.nextInt(2);				
		if (b==1){               //随机生成大写或者小写的验证码
			 chaA=(char)('A'+a);  //使用生成的随机数随机一个大写的验证码	
		}else{
			 chaA=(char)('a'+a);  //使用一个生成的随机数随机一个小写的验证码		
		}		
		c[i-1]=chaA;              //将生成的随机数存入数组		
		}
		System.out.print("请输入验证码:");
		for (int i=0;i<c.length;i++){
			System.out.print(c[i]);       //打印生成的验证码提示给用户
		}
		Scanner scan=new Scanner(System.in);  //new一个Scanner
		System.out.println();
		String Strscan=scan.nextLine();          //接收用户的输入
		char [] v=Strscan.toCharArray();     //将用户输入的分割成单个字符存入数组
		int x=0;
		for (int i=0;i<c.length;i++){        //比对用户输入的验证码与生成的验证码是否相等
			if(v.length==4){  //判断用户输入的验证码位数是否为4位
			if (v[i]==c[i]){
				x=1;
			}else{
				x=0;
			}
		}
		}
		if (x==0){
			System.out.println("您输入的验证码不正确");
		}else{
			System.out.println("您输入的验证码正确，登录成功");
			break;
		}
		}
		
	}

	
}
