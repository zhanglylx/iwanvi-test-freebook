package Java异常处理机制;
/**
 * try - catch中的finally块
 * 
 * finally块定义在catch块的最后。只能出现一次。(0-1次)
 * 
 * 无论程序是否出错都会执行的块！
 * 无条件执行！
 * 
 * 注意final和finally的区别。
 * final：
 * 	定义属性，只能被赋值一次
 * 	定义方法，不能被重写
 *  定义类，   不能被继承
 *finally：
 *	try-catch的结束块 
 * 
 * 
 * @author Administrator
 *
 */
public class DemoFinally {

	public static void main(String[] args) {
		try{
			String info = "1234567890";
			System.out.println("字符串第10个字符"+info.charAt(9));
		}catch(NullPointerException  e){
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
		}finally{
			//里面的语句无条件执行！
			System.out.println("finally!!!");
		}

	}

}
