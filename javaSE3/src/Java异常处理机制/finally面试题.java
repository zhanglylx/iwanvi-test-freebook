package Java异常处理机制;

public class finally面试题 {

	public static void main(String[] args) {
		System.out.println(
				test(null)+","+test("0")+","+test("")
				
				);
		/**
		 * 输出结果？
		 * 4,4,4 正确结果
		 */
	}
	public static int test(String str){
		try{
			return str.charAt(0) - '0';
		}catch (NullPointerException e) {
			return 1;
		}catch(RuntimeException e){
			return 2;
		}catch(Exception e){
			return 3;
		}finally{
			return 4;
		}
	}
}
