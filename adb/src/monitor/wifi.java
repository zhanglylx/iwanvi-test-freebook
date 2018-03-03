package monitor;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.List;





public class wifi {

//获取流量

	public static void main(String[] args) {

		adb();

		//循环获取数据

		for (int i = 0; i < 60; i++) {

			flow1();

		}

	}

//运行monkey  com.netease.newsreader.activity  对应的APP名称

	public static void adb() {

		String command1 ="adb shell monkey -p  com.sogou.novel -s 500 -v 2000";

		Runtime runtime = Runtime.getRuntime();

		try {

			runtime.exec(command1);

		} catch (Exception e) {

			System.out.println("[Error][pressmonkey]" + e.getMessage());

		}

	}



	public static  void flow1(){

		//休眠1S获取数据

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}



		String command2 = "adb shell ps";

		String str="com.sogou.novel.ui.activity.SplashActivity";

		String SIBaseVersion = " ";

		String SIBaseVersion3 = " ";

		String SIBaseVersion4= " ";

		//WLAN流量和

		int FWlan=0;

		//3/4G网流量和

		int FNet=0;

		try {

			Runtime runtime = Runtime.getRuntime();

			Process getSIBaseVersionProcess2 = runtime.exec(command2);

			BufferedReader bufferedReader = new BufferedReader(

					new InputStreamReader(

							getSIBaseVersionProcess2.getInputStream()));

			while ((SIBaseVersion = bufferedReader.readLine()) != null) {

				//将字符串数组重新添加到list集合中，在从集合中获取相应的值

				List<String> tmp = new ArrayList<String>(); 

				if ( isHave(SIBaseVersion, str) ) {

					// StringText s = SIBaseVersion;

					// 截取需要的字符串

					String[] array = SIBaseVersion.split(" ");

					for (int i = 0; i < array.length; i++) {

						if (array[i].length() != 0) {

							tmp.add(array[i]);
							

						}

					}

					// 取list集合中的数据

					String H1 = tmp.get(1);

					// 转换成整型

					int Pid = Integer.parseInt(H1);

					String command3 = "adb shell cat /proc/" + Pid + "/status | grep Uid";

					Process getSIBaseVersionProcess3 = runtime.exec(command3);
					
					BufferedReader bufferedReader3 = new BufferedReader(
							
							new InputStreamReader(getSIBaseVersionProcess3.getInputStream()));

					while (((SIBaseVersion3 = bufferedReader3.readLine()) != null)) {

						List<String>tmp2 = new ArrayList<String>();

						if (!(SIBaseVersion3.equals(""))) {

							String[] array1 = SIBaseVersion3.split("\t");

							for (int i = 0; i < array1.length; i++) {

								tmp2.add(array1[i]);

							}

							// 	取list集合中的数据

							String U1 = tmp2.get(1);

							// 转换成整型

							int Uid = Integer.parseInt(U1);

							String command4 = "adb shell cat /proc/net/xt_qtaguid/stats | grep " + Uid;

							Process getSIBaseVersionProcess4 = runtime.exec(command4);

							BufferedReader bufferedReader4 = new BufferedReader(

									new InputStreamReader(getSIBaseVersionProcess4.getInputStream()));

							while ((SIBaseVersion4 = bufferedReader4.readLine()) != null) {

								String rmnet = "rmnet0";

								String wlan = "wlan0";

								List<String> tmp4 = new ArrayList<String>(); 

								if (isHave(SIBaseVersion4, wlan)) {

									String[] Wlanarray = SIBaseVersion4.split(" ");

									for (int i = 0; i < Wlanarray.length; i++) {

										if (Wlanarray[i].length() != 0) {

											tmp4.add(Wlanarray[i]);

										}

									}

									//挑选自己需要的数据

									if (tmp4.get(2).equals("0x0")&&tmp4.get(4).equals("1")) {

										String Wlan1 =tmp4.get(5);

										String Wlan2 =tmp4.get(7);

// 		//转换成整型

										double WLAN1 = Double.parseDouble(Wlan1);

										double  WLAN2 = Double.parseDouble(Wlan2);

										double W = WLAN1+WLAN2;

										FWlan+=W;

									} 

								}

								List<String> tmp3 = new ArrayList<String>(); 

								if (isHave(SIBaseVersion4, rmnet)) {

									String[] Netarray = SIBaseVersion4.split(" ");

									for (int i = 0; i < Netarray.length; i++) {

										if (Netarray[i].length() != 0) {

											tmp3.add(Netarray[i]);

										}

									}


									if (tmp3.get(2).equals("0x0")&&tmp3.get(4).equals("1")) {

										String Net1 = tmp3.get(5);

										String Net2 = tmp3.get(7);

										double NET1=Double.parseDouble(Net1);

										double NET2 = Double.parseDouble(Net2);

										double N=NET1+NET2;

										FNet+=N;

										System.out.println("FNet="+FNet);

									}

								}

							}

//输出相应流量值

							System.err.println("FWlan2 ="+1.0*FWlan/1024+" KB");

							System.err.println("FNET2 ="+1.0*FNet/1024+" KB");

							bufferedReader4.close();

							getSIBaseVersionProcess4.destroy();

						}



					}

					bufferedReader3.close();

					getSIBaseVersionProcess3.destroy();

				}

			}

			bufferedReader.close();

			getSIBaseVersionProcess2.destroy();


		} catch (Exception e) {

			System.out.println("[Error][getSIBaseVersion]" + e.getMessage());


		}



}





public static boolean isHave(String strs, String s) {

for (int i = 0; i < strs.length(); i++) {

if (strs.indexOf(s) != -1) {

return true;

}

}

return false;

}



}

