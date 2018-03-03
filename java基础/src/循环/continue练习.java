package 循环;

public class continue练习 {
	public static void main(String [] args){
		//i=1
		//(1)->(2)-true->(3.1)-true->(3.2)->(4)->
		//i=2
		//(2)-true->(3.1)-false->(3.3)print(i)
		//
		for(int i=1/*1*/;i<=10/*2*/;i++/*4*/){
			if(i<2/*3.1*/){
				/*3.2*/continue;//重新开始循环
			}
			/*3.3*/System.out.println(i);
		}
	}
}
