package 运算和判断语句;
/**
 * switch case
 * 只能处理整数 (byte，short，char，int)逻辑判断
 * @author Administrator
 *
 */
public class switch判断语句 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int score = 100;//分数，是100分制
		//switch 开关 case:情况下
		switch (score /10){
		case 10:
		case 9:
		case 8:
			System.out.println("良好");
			break;
		case 7:
			System.out.println("中等");
			break;
		default:System.out.println("不及格");
		}
	}

}
