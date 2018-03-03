package 轻客户端;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import net.sf.json.JSONObject;

public class shouye {

	public static void shouye() {
		// TODO 自动生成的方法存根
		//int a =0;
		Thread t = new Thread(new Runnable(){
			public void run(){
				String shouye = "http://ot.yuedu.sogou.com/light/data/index";			
				String b =api.loadJSON(shouye);
			 if(b.contains("bookMd")){
			 }else{
				 Date dt = new Date();
					SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					System.out.println(matter1.format(dt));
				 System.out.println("首页返回异常"+b+dt);
			 }										
			}
		});
		t.start();


	}

}
