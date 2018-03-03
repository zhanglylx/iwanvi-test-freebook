package toString;

public class toString {

	public static void main(String[] args) {
		toString obj = new toString();
		/*
		 * 为什么我有toString()方法?
		 * 因为所有的类都继承自Object，而toString方法是Object
		 * 定义的。我们直接继承了这个方法。
		 * 
		 * Object的toString()方法帮我们返回一个字符串。
		 * 这个字符串的格式是固定的:类名@hashcode
		 * 这个hashcode是一串数字。在java中叫“句柄”，或叫地址
		 * 
		 * toString定义的原意是返回能够描述当前这个类的实例的一串文字
		 * 
		 */
		String info = obj.toString();
		System.out.println(info);
		System.out.println(obj);
	}
	
	public toString(){}
	@Override
	public String toString(){
		return "这个是我自己定义的toString()方法的返回";
	}
}
