package 定时器_继承抽象类javaAPITimer;
/**
 * 定时器应用
 * 定时器可以进行定时执行一段代码(方法)
 * @author Administrator
 *
 */
import java.util.Timer;//定时器
import java.util.TimerTask;//定时器任务
public class 定时器应用 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		//schedule  计划
		//毫秒单位
		//timer.schedule(new MyTask(), 延迟时间,执行时间);
		timer.schedule(new MyTask(), 10000,1000/5);
	}

}

//继承TimerTask抽象类
class MyTask extends TimerTask{
	private char[] chs = {'-','\\','|','/',};
	private char[] chss = {'.','o','O','o'};
	private int i = 0;
	public void run(){
		int s = i++%chs.length;
		System.out.println(chs[s]);
	}
}