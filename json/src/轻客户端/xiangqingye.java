package 轻客户端;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class xiangqingye {

	public static void xiangqing() {
		// TODO 自动生成的方法存根
		// int a =0;
		Thread t = new Thread(new Runnable() {
			public void run() {
				shuju a = new shuju();
				String[] arysosuo = a.xiangqing(); // 调用搜索数据
				Random rand = new Random();
				String sosuo = "http://ot.yuedu.sogou.com/light/data/detail?md=";
				int n = rand.nextInt(arysosuo.length);
				String json = api.loadJSON(sosuo + arysosuo[n]);
				mulu.sosuo(arysosuo[n]);
				if(json.contains("bookMd")){
				 }else{
					 Date dt = new Date();
						SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						System.out.println(matter1.format(dt));
					 System.out.println("详情页返回异常"+json+dt+" "+sosuo + arysosuo[n]);
				 }

			}
		});

		t.start();

	}

}
