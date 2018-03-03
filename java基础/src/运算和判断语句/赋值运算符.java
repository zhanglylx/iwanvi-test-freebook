package 运算和判断语句;

public class 赋值运算符 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a;
		int b;
		int c;
		c = a = b = 3;
		c = (a = (b = 3));
		c = a + (b = 3);
		c = a + (b =1 );
		System.out.println(a+","+ b + "," + c);
		a = 1;
		b += a; // b = b+a;
		b *=a;
		b /=a;
		b %=a;
		//经典面试题：将一个数倒过来
		b = 2345;		
		int a1= b%10;		
		b/=10;		
		int a2= b%10;
		b/=10;
		int a3= b%10;
		b/=10;
		int a4= b%10;
		b/=10;
		int n =((a1*10 + a2)*10 + a3)*10+a4;
		System.out.println(n);
		String q1=""+a1+a2+a3+a4;
		System.out.println(q1);
		System.out.println(a1+","+a2+","+a3+","+a4);
		
	}

}
