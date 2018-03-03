package 彩票生成;
import java.util.Random;
import java.util.Arrays;
public class shuangseqiu {
	public static void main (String[]args){
		int y=0;
		int a;
		int[] zrr=new int[6];
		Random rand=new Random();   //创建随机数
		do{												
		for (a=0;a<6;a++){  //生成6个1-33的随机数
		int b=rand.nextInt(33)+1;		
		zrr[a]=b;	//将1-33值赋值给数组
		}
		int t;
		NO1:for (t=0;t<zrr.length;t++){ //遍历随机数，是否有重复值
			int f=zrr[t];
			int p=0;
			for (p=0;p<zrr.length;p++){
				    int k=zrr[p];
				if (t!=p){				    					     
					 if (k==f ){
						 y=1;
						 System.out.println("y：：："+y);
						 System.out.println(k);
						 System.out.println(f);
						 break NO1;
					 }else{
					 
						 y=0;
					 }
				 }	   
			}
		}		
	}while (y==1);
		Arrays.sort(zrr);
		System.out.print("红球为:");
		for (a=0;a<zrr.length;a++){   //打印6个随机数
			
			System.out.print(zrr[a]);
			if (a==zrr.length-1){
			System.out.print("");
			
			}else{
				System.out.print(",");
			}
		}
		System.out.println("篮球为："+(rand.nextInt(15)+1));
	}
}
