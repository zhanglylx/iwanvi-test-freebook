package 轻客户端;

import java.text.SimpleDateFormat;
import java.util.Date;

public class paihang {

	public static void paihang() {
		// TODO 自动生成的方法存根
		//int a =0;
		Thread t = new Thread(new Runnable(){
			public void run(){
				String paihang = "http://ot.yuedu.sogou.com/light/pages/rank.html";			
				String c = api.loadJSON(paihang);
				if(c.contains("full-screen")){
				}else{
					Date dt = new Date();
					SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					System.out.println(matter1.format(dt));
					System.out.println("排行异常"+c+"   "+dt);
				}
				
			}
		});

		t.start();


	}

}
