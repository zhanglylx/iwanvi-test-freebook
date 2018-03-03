package 内部类;
import java.util.Timer;
import java.util.TimerTask;
public class 内部类 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xoo x = new Xoo();
		x.start();
	}

}
class Xoo{
	Timer timer = new Timer();
	public void start(){
		timer.schedule(new MyTask(), 0,1000);//执行定时器
		timer.schedule(new StopTask(), 1000*10);//在10秒以后执行
	}
	private class StopTask extends TimerTask{//内部类
		public void run(){
			timer.cancel();//取消定时器任务
		}
	}
	private class MyTask extends TimerTask{//内部类
		int i=10;
		public void run(){
		System.out.println(this.i--);//执行定时器
		}
	}
}