package 轻客户端;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class sosuo {

	public static void sosuo() {
		// TODO 自动生成的方法存根
		// int a =0;
		Thread t = new Thread(new Runnable() {
			public void run() {
				shuju a = new shuju();
				String[] arysosuo = a.sosuo(); // 调用搜索数据
				Random rand = new Random();
				//int   exi = JOptionPane.showConfirmDialog (null, "开始访问首页接口，关闭程序请按确认", "友情提示", JOptionPane.WARNING_MESSAGE);//你的提示消息
				String sosuo = "http://ot.yuedu.sogou.com/light/pages/search.html?query=";
				int n = rand.nextInt(arysosuo.length);
				String json = api.loadJSON(sosuo + arysosuo[n]);
				if(json.contains("viewport")){
				 }else{
					 Date dt = new Date();
						SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						System.out.println(matter1.format(dt));
					 System.out.println("搜素返回异常"+json+dt);
				 }

			}
		});

		t.start();

	}

}
