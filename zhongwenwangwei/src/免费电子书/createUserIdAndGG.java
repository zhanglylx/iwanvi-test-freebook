package 免费电子书;

import java.util.Arrays;

public class createUserIdAndGG {
	public static int[] userId(){
		int[] userId = new int[0];
		//给用户id数组赋值
		for (int j = 1; j <= config.userNumber; j++) {
			userId = Arrays.copyOf(userId, userId.length + 1);
			userId[j-1] = getRandNum();
		}
		return userId;	
	}
	public static int[] GG(){
		int[] GG = new int[0];
		// 给广告位赋值
		for (int j = 1; j <= config.GGNumber; j++) {
			GG = Arrays.copyOf(GG, GG.length + 1);
			GG[j - 1] = j;
		}
		return GG;
	}
	public static int getRandNum() {
		return (int) ((Math.random() * 9 + 1) * 100000);
	}
}
