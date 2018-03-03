package 运算和判断语句;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class if判断语句 {
	public static void main (String [] args){
		int a = 34;
		int b = 8;
		int c = 88;
		//一行语句可以省略大括号
		if (a<b)
			//a是最小的
			if (a<c)
				System.out.println("a最小:"+a);
			else
				System.out.println("c最小:"+c);
			
		else
			//b是小的
			if(b<c)
				System.out.println("b最小:"+b);
			else
				System.out.println("c最小:"+c);
			
			
		
				
	}
}
