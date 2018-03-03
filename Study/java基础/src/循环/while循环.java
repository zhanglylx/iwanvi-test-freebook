package 循环;
/**
 * for循环 与 while 循环
 * for 循环可以与while循环互换使用。达到相同的目的
 * 
 * 
 */
public class while循环 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int i=1;
		for(;i<10;){
			System.out.println(i++);
		}
		System.out.println(i);
		
		//两个表达式完全一样
		
		i=1;
		while(i<10){
			System.out.println(i++);
		}
		System.out.println(i);
	}

}
