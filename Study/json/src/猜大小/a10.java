package 猜大小;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import 轻客户端.api;

public class a10 {

	public static void sosuo() {
		// TODO 自动生成的方法存根
		// int a =0;
		Thread t = new Thread(new Runnable() {
			public void run() {
				String[] app = { "wap", "android", "ios" };
				shuju user = new shuju();
				int i = 0;
				byte n = 0;
				int rand=1;			
				while (true) {
					if(rand==2){
						rand=rand+1;
					}else if (rand == 7){
						rand=1;
					}
					if (Integer.valueOf((user.user(0))[1]) == i) {
						i = 0;
					}
					String sosuo = "https://read.sogou.com/yd/activity/caidaxiao/recieveReward?channel="
							+  app[n] + "&eid=&userid=" + (user.user(i))[0]+ "&callback=getRewardCb&rewardId="
									+ rand;
					n++;
					
					if (n > 2) {
						n = 0;
					}				
					String s = api.loadJSON(sosuo);
					if(s.contains("领取成功")){
						System.out.println(sosuo);
						System.out.println("领取成功:"+(user.user(i))[0]);
					}else if(s.contains("不能重复领取")){
						api.loadJSON("https://read.sogou.com/yd/activity/caidaxiao/clearCacheByType?userid="
								+ (user.user(i))[0]
								+ "&type=lingjiang&rewardId="
								+ rand);
						System.out.println("不能重复领取:"+(user.user(i))[0]);
					}else if(s.contains("没有奖券")){
						System.out.println("没有奖券："+(user.user(i))[0]);
					}else if(s.contains("已经领取完了")){
						
						System.out.println("已经领取完了:"+(user.user(i))[0]);
					}else if(s.contains("奖券数不够")){
						System.out.println("奖券数不够:"+(user.user(i))[0]);
					}
					else{
						System.out.println("响应错误："+s);
						System.out.println((user.user(i))[0]);
						
					}
					i++;
					rand++;
					Date dt = new Date();
					SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
					System.out.println("a10:"+matter1.format(dt));					
				}
			}
		});

		t.start();

	}

}
