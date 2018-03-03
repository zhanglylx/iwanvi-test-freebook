package 轻客户端;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;
import net.sf.json.JSONObject;

//
//23号24号已测试完毕
public class api {
	public static void main(String[] args) throws InterruptedException {			
		/*
		shuju a = new shuju();
		StringText [] arysosuo = a.sosuo();
		StringText [] aryxiangqing = a.xiangqing();
		while(true){
		StringText shouye = "http://ot.yuedu.sogou.com/light/data/index";
		api.loadJSON(shouye);
		StringText paihang = "http://ot.yuedu.sogou.com/light/pages/rank.html";
		api.loadJSON(paihang);	
		 // 调用搜索数据
		Random rand = new Random();
		StringText sosuo = "http://ot.yuedu.sogou.com/light/pages/search.html?query=";
		int n = rand.nextInt(arysosuo.length);
		api.loadJSON(sosuo + arysosuo[n]);
		StringText xiangqingye = "http://ot.yuedu.sogou.com/light/data/detail?md=";
		int nx = rand.nextInt(aryxiangqing.length);
		api.loadJSON(xiangqingye + aryxiangqing[nx]);
		StringText mulu = "http://ot.yuedu.sogou.com/light/data/chapter/list?md="+aryxiangqing[nx]+"&sort=asc&pageNo=1";
		api.loadJSON(mulu);		
		Thread.sleep(1000);
		}
		 */
		long n=0;
		while(true){
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();	
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();
			shouye.shouye();//执行访问首页
			sosuo.sosuo();//执行搜素
			paihang.paihang();//执行排行访问
			xiangqingye.xiangqing();		
			System.out.println((n++)+"---------------------------------------");
			Thread.sleep(1000);
		}

	}
	public static String loadJSON(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return json.toString();
	}
}