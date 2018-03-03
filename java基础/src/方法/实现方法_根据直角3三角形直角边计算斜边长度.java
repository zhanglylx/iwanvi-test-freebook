package 方法;
/**
 * 勾股定理:a*a + b*b = c*c
 * 已知 ab 计算c
 */
public class 实现方法_根据直角3三角形直角边计算斜边长度 {
	/**
	 * 根据直角三角形直角边计算斜边的长度
	 * @param a   一个直角边长度
	 * @param b	    一个直角边长度
	 * @return  斜边长度
	 */
	public static double f(double a,double b){
		//Math.sqrt(a) //计算a的平方根，是JavaAPI提供的方法
		double c =Math.sqrt(a*a + b*b);//调用javaAPI提供的方法
        return c;//返回计算结果c
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(f(1,1));
	}

}
