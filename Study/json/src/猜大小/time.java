package 猜大小;

import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class time {
	public static void main (String [] args ){
		  GregorianCalendar gc = new GregorianCalendar(2017, 06, 23, 10, 27);
		    java.util.Date myDate = gc.getTime();
		    Timer timer = new Timer();
		    TimerTask TimerTask = new TimerTask(){
		      public void run(){
		        System.out.println("done");
		        }
		      
		    };
		    timer.schedule(TimerTask ,myDate);
		
		
		
	}
}
