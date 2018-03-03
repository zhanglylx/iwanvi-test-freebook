package 猜大小;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import net.sf.json.JSONObject;
import 轻客户端.api;

public class s27 {

	public static void sosuo() {
		// TODO 自动生成的方法存根
		// int a =0;
		Thread t = new Thread(new Runnable() {
			public void run() {
				String url;
				String Response;
				shuju user = new shuju();
				int num0 = 0;
				int num1 = 0;
				byte guess = 0;
				int gl = 6;
				float g = 0;
				int userid = 0;

				while (true) {
					if ((user.user(0)[1]).equals(Integer.toString(userid))) {
						System.out.println("抽奖完毕");
						userid = 0;
					}
					url = "https://read.sogou.com/yd/activity/" + "caidaxiao/lottery?channel=w" + "ap&eid=&userid="
							+ (user.user(userid))[0] + "&callback=lotteryCb&guess=" + guess;
					if (guess == 1) {
						guess = 0;
					} else {
						guess = 1;
					}

					Response = api.loadJSON(url);
					if (Response.contains("no chance")) {
						api.loadJSON("https://read.sogou.com/yd/activity/cai" + "daxiao/clearCacheByType?userid="
								+ (user.user(userid))[0] + "&type=jihui&rewardId=");
						Response = api.loadJSON(url);
					}
					Response = Response.replace("lotteryCb({\"chance\":\"chance\",\"lottery\":", "");
					try {
						Response = Response.substring(0, Response.length() - 1);
					} catch (Exception e) {
						System.out.println(Response);
						System.exit(0);
						
					}	
					if(Response.contains("结束")){
						System.out.println("抽奖结束啦======"
								+ "==============================="
								+ "======================"+Response);
						System.out.println("抽奖结束啦======"
								+ "==============================="
								+ "======================"+Response);
						gl=0;
					}else{
					JSONObject arr = JSONObject.fromObject(Response);
					gl = arr.getInt("gl");
					}
					if (gl == 0) {
						num0++;

					} else if (gl == 2) {
						num1++;

					} else {
						System.out.print("json有问题" + Response + "  ");
						
					}
					System.out.println("num1:  " + num1 + "  " + (user.user(userid))[0]);
					if (num1 > 1) {
						userid++;
						num1=0;
						System.out.println("切换用户");
					}

				}
			}
		});

		t.start();

	}

}
