package StringText;

public class strIndexOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Think in Java" ;
		/**
		 * 查看"Java"在str字符串的位置
		 * 若str中不包含"Java"，那么返回的整数位"-1"
		 * 
		 */
		int index = str.indexOf("Java");
		System.out.println(index);
		
		/**
		 * indexOf的重载方法indexOf(StringText str,int from)
		 * 该方法会返回从from位置开始后第一次出现str的位置
		 */
		index = str.indexOf("i",4);
		System.out.println(index);
		
		/**
		 * 查找in字符后第一次出现i的位置
		 * 通常这样的需求会使用indexOf的这个重载方法
		 * Think in Java
		 * 步骤:
		 * 1：先找到第一次出现in的位置
		 * 2:在根据这个位置开始查找后续的
		 */
			System.out.println(str.indexOf("i",str.indexOf("in")+"in".length()));
			
		/*
		 * 和indexOf类似，lastIndexOf是查找最后出现的位置
		 */
			
		index = str.lastIndexOf("in");
		System.out.println("in最后出现的位置:"+index);
		/**
		 * lastIndexOf的重载方法lastIndexOf(StringText str,int from)
		 * 从from开始查找最后一次出现给定字符的位置
		 * 这个from有截取的效果，会进行反向查找
		 * 
		 */
		index = str.lastIndexOf("in",5);
		System.out.println(index);
		
		
		char ch = str.charAt(6);
		System.out.println(ch);
		
	
	}

}
