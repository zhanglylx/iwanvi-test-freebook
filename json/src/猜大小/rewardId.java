package 猜大小;

import java.util.Random;

public class rewardId {
	public static int rewardid(){
		Random rand = new Random();
		int n = rand.nextInt(7);
		n = n+1;
		if(n==7){
			n=6;
		}else if(n==2){
			n=1;
		}
		return n;
	} 
}
