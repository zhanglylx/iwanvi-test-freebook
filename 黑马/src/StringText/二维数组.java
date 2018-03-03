package StringText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
/*
// * 1.基础班考试要进行分组,键盘录入该班级总共多少组?以及每组的学生数量?
//2.根据录入的组数及每组学员的数量创建二维数组
//3.利用随机数产生0-100的成绩(包含0和100)
//4.要求:
//(1)打印该班级中每组的不及格人数
//(2)打印该班级中每组的平均分
//(3)打印组的最高平均分
//(4)打印班级中的不及格人数
//(5)打印班级平均分
//(6)演示格式如下:
//请输入班级总组数:3
//请输入班级中每组的人数:10
//控制台输出:
//第1组不及格人数为: 6 人
//第1组平均分为: 52
//第2组不及格人数为: 7 人
//第2组平均分为: 46
//第3组不及格人数为: 3 人
//第3组平均分为: 69
//班级中单组最高平均分为:69
//班级中不及格人数为: 16 人
//班级总平均分为: 56
 * 
 */
public class 二维数组 {

	public static void main(String[] args) {
		group gr = new group();
		Random rand = new Random();
		List <Integer> list = new ArrayList<Integer>();//记录所有的分数
		for(int i=0;i<gr.group.length;i++){
			int fail=0;
			int avg =0;
			for(int j=0;j<gr.group[i].length;j++){
				int num =  rand.nextInt(101);
				if(num<60){
					fail++;
				}
				list.add(num);
				avg+=num;
				if(j==gr.group[i].length-1){
					//调用方法://(1)打印该班级中每组的不及格人数
					//(2)打印该班级中每组的平均分
					gr.printFlunk(fail,i+1);
					gr.printAvg(avg, gr.group[i].length, i+1);
				}
			}
			
		}
		System.out.println("班级中最高分为:"+Collections.max(list));
		int sum=0;
		int gradeFail=0;
		for(int s:list){
			sum+=s;
			if(s<60){
				gradeFail++;
			}
		}
		System.out.println("班级中不及格人数为:"+gradeFail);
		System.out.println("班级总平均分为:"+(sum/list.size()));
		

	}
	
}
class group{
	public int[][] group;
	group(){//构造器，初始化分组及人员
		this.group = new int[Scanner("班级总数")][Scanner("每组人数")];	
	}
	private int Scanner(String title) {//输入提示框
		return Integer.parseInt(JOptionPane.showInputDialog(null,"请输入"+title+"：\n","输入框",JOptionPane.PLAIN_MESSAGE));
	}
	public void printFlunk(int fail,int group) {//打印组不及格人数
	System.out.print("第"+group+"组不及格人数为: "+fail+"人;");
	}
	public void printAvg(int avg,int lenth,int group) {//打印组平均分数
		System.out.println("第"+group+"组平均分数为: "+(avg/lenth)+"分.");
		}
}

