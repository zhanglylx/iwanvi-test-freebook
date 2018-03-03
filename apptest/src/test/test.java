package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import AppiumMethod.*;
public class test {
	public static ArrayList<String> list = new ArrayList<String>();
	public static ArrayList<String> listLog = new ArrayList<String>();
	public static void main(String[] args) {
		while(true){
		adb("  shell tail -f /sdcard/FreeBook/ad/2018-01-19/GG-31.txt");
		for(String s : list){
			if(!listLog.contains(s)){
//				System.out.println(s);
			}
		}
		listLog.addAll(list);
		break;
		}
	}
	public static String[] adb(String code) {
		String[] str = new String[0];
		try {
			installAPPPackage.isPuth(config.ADB_PUTH);
			Process pro = Runtime.getRuntime().exec(config.ADB_PUTH + " " + code);
			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String msg = null;
			ArrayList<String> s = new ArrayList<String>();
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
				s.add(msg);

			}
			list = s;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
