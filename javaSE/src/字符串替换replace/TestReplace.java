package 字符串替换replace;
/**
 * 测试字符串替换
 * @author Administrator
 *
 */
public class TestReplace {

	public static void main(String[] args) {
		//定义一个字符串，数字和字母穿插
		String info = "12345ABC67890DEF123GHI";
		/**
		 * 目标：
		 * 		将字符串中的数字部分替换为"#NUMBER#"
		 * 
		 * replaceAll方法:可以替换字符串中满足正则表达式部分的内容
		 * 
		 * 
		 * replaceAll(StringText regex,StringText replacement);
		 * 
		 * 
		 */
		String str = info.replaceAll("[0-9]+", "#NUMBER#");
		System.out.println(str);
	}

}
