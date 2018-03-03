package 数组;
import java.util.Arrays;
import java.util.Random;
/**
 * 
 * 随机生成双色球彩票号码
 * 33 红球取 6
 * 16 篮球去 1
 * 7个2位数号码
 * 1.在33元素的数组中取出6个不重复的元素
 *   先定义33个元素的数组表示球池pool(池)
 *	 在定义使用标记boolean数组，代表某个球是否被取出过
 *	used:用过
 *  pool={01，02，03..}
 *  used={f，f，f...}
 *  balls = {null,null,null,null,null,null}
 *  ball:球 balls 保存抽取结果的空位置，6个！
 * 
 * 2.生成随机数n,n的范围 0<=n<33
 * 3.检查n对应的球使用标记used[n]
 * 4.如果使用过，used[n]的值是true，就返回(1)
 * 5.如果没有使用过，就取出 球 pool[n] 送到 balls[i++]
 *   balls[i++] = pool[n]
 *   将n对应的使用标记设置为true，表示使用过了！
 * 6.检查balls 球的数量，如果满了就结束
 * 7. 返回(1)
 */
public class 随机生成双色球彩票号码 {
	public static void main(String[] args){
		Random num= new Random();
		String[] pool={"01","02","03","04","05","06","07","08","09","10","11","12","13"
				,"14","15","16","17","18","19","20","21","22","23","24","25"
				,"26","27","28","29","30","31","32","33"};
		boolean[] used = new boolean[pool.length];
		String[] balls=new String[6];
		int i=0;//记录抓取数的次数和下次要插入到balls的位置		
			while(true){
			int number = (num.nextInt(pool.length));//随机出一个数组下标
			System.out.println(number);		
			if(used[number]==false){	//判断是否已经抓取过这个数			
				used[number]=true; //将抓取过的数的used设置为true
			
				balls[i++]=pool[number];//将抓取的数赋值给balls	
				
			}
			if(i==6){ //判断是否已经抓取过了6个数
				Arrays.sort(balls); //对数组进行有小到大排序
				System.out.println("红球为:"+balls[0]+" "+balls[1]
						+" "+balls[2]+" "+balls[3]+" "+balls[4]
								+" "+balls[5]);//打印生成的数
				break;
			}
		}
	}
}
