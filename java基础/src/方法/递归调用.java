package 方法;

public class 递归调用 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(f(6));
		
	}
	/**
	f(n) = n　＋　ｆ（ｎ－１）　且　ｆ（１）＝１
	
	*/
	public static int f(int n){
		if (n ==1){
			return 1;
		}
		System.out.println(n);
		System.out.println("---");
		 return n + f(n-1);
	}
}

