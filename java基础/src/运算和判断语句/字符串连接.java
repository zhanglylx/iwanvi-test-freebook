package 运算和判断语句;

public class 字符串连接 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a = 100;
		String msg = "a="+a;
		System.out.println(msg); //结果为:a=100;
		
		msg = ""+100+200;
		System.out.println(msg); //结果为:100200
		
		msg = 100+200+"";
		System.out.println(msg); // 结果为:300
		
		System.out.println("A"+"B");//AB
		System.out.println('A'+'B');//65+66
	}

}
