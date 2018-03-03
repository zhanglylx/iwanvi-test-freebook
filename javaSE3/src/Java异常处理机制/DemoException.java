package Java异常处理机制;
/**
 * java异常处理机制
 * 我们在程序中可以捕获的是Exception的子类异常
 * 而java中的异常有两大类。
 * Exception：程序级别的异常，我们可控
 * Error	:系统级别的异常。我们不可控
 * 
 * 所以我们关心的是Exception的相关子类！
 * 
 * 异常处理语句
 * try{
 * 	可能发生异常的代码片段
 * }catch(Exception e){//列举代码中可能出现的异常类型
 * 	当出现了列举的异常类型后，在这里处理
 * }
 * @author Administrator
 *
 */
public class DemoException {

	public static void main(String[] args) {
		try{
		String info = "hello";
		//空指针异常！
		System.out.println("这个字符串长度："+info.length());
		//
		System.out.println("第10个字符是："+info.charAt(9));
		}catch(NullPointerException e){
		System.out.println("这里的字符串是空的！");
		//下标越界
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("字符串没有那么长！");
		//顶级程序级别顶级父类异常
		}catch(Exception e){
			/*
			 * 良好的习惯，在异常捕获机制的最后书城catch(Exception e)
			 * 捕获未知的错误(或不需要针对处理的错误)。
			 */
			
		}
		System.out.println("程序结束了！");
	}

}
