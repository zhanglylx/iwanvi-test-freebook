package Java异常处理机制;

/**
 * throw关键字，可以主动抛出一个异常
 * 
 * 应用环境： 当我们的方法出现错误时，这个错误我们不应该去解决，而是 通知调用方法去解决时，会将这个错误告知外界，而告知外界的方式
 * 就是throw异常(抛出异常)
 * 
 *
 */
public class DemoThrow {
	public static void main(String[] args) {
		try {
			/**
			 * 通常我们调用方法时需要传入参数的话，那么这些方法都不会 自动处理异常，而是将错误抛给我们解决。
			 */
			String result = getGirFirend("女神");
			result = null;
			System.out.println("我追到了女神么？" + result);
		} catch (Exception e) {
			// 我们应该在这里捕获异常并处理
			System.out.println("没追到。。。。");
		}

	}

	/**
	 * 介绍女朋友
	 * 
	 * @param name
	 *            女朋友的名字
	 * @return 是否同意
	 */
	public static String getGirFirend(String name) {
		try {
			if ("春哥".equals(name)) {
				return "行";
			} else if ("曾哥".equals(name)) {
				return "行";
			} else if ("我女朋友".equals(name)) {
				return "不行";
			} else {
				/**
				 * 当出现了错误(可能是业务逻辑上的，不一定是真实异常) 我们可以主动向外界抛出一个异常！
				 */
				throw new RuntimeException("人家不干！");
			}
		} catch (NullPointerException e) {
			throw e;// 出错了不解决，抛给调用者解决。
		}
	}
}
