package Methods_summarize;

import java.util.Random;

public class 生成指定范围的随机数 {

	public static void main(String[] args) {
		int max=20;
	      int min=10;
	      Random random = new Random();
	      int s;
	      System.out.println(s=random.nextInt(max)%(max-min+1)+min);
	      
	      
	      //指定位数随机数
	      System.out.println( (int) ((Math.random() * 9 + 1) * 100000));
	    
	}

}
