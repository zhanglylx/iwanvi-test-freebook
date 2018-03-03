package 轻客户端;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class mulu {

	public static void sosuo(String n) {
		// TODO 自动生成的方法存根
		// int a =0;
		Thread t = new Thread(new Runnable() {
			public void run() {			 
				String sosuo = "http://ot.yuedu.sogou.com/light/data/chapter/list?md="+n+"&sort=asc&pageNo=1";
				String json = api.loadJSON(sosuo);
				if(json.contains("name")){
				 }else{
					 Date dt = new Date();
						SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						System.out.println(matter1.format(dt));
					 System.out.println("目录返回异常"+json+dt+"   "+sosuo);
				 }

			}
		});

		t.start();

	}

}
