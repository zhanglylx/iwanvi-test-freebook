package 内部类;
import java.util.Timer;
import java.util.TimerTask;
public class 匿名内部类用途演示 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    final	Timer timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				System.out.println("HI");
			}
		};
		timer.schedule(task, 0,1000);
		//企业中采用以下写法，简洁
		timer.schedule(new TimerTask(){
			public void run(){
				timer.cancel();//在匿名内部类中只能访问fianl局部变量
			}
		}, 1000*10);
	}

}
