package 彩票生成;

import java.util.Arrays;
import java.util.Random;

public class 就靠你了 {
	public static void main(String[] args) {
		int[] number = { 2, 5, 6, 16, 28, 29, 4, 19, 22, 27, 30, 33, 5, 1, 18, 19, 30, 31, 2, 6, 11, 12, 19, 29, 9, 1,
				12, 19, 22, 29, 8, 11, 13, 19, 28, 31, 7, 8, 9, 15, 22, 27, 10, 18, 19, 29, 32, 33, 5, 7, 10, 23, 28,
				29, 1, 7, 10, 16, 22, 33, 11, 12, 13, 16, 23, 25, 7, 9, 18, 22, 23, 29, 3, 6, 13, 14, 19, 28, 3, 5, 6,
				13, 20, 22, 1, 5, 06, 16, 25, 30, 1, 5, 11, 20, 22, 24, 3, 8, 14, 20, 24, 26, 14, 18, 21, 25, 28, 29, 3,
				5, 14, 25, 26, 30, 01, 12, 16, 20, 22, 24, 3, 7, 14, 23, 25, 27, 5, 7, 18, 19, 22, 24, 1, 2, 4, 15, 17,
				22, 1, 4, 8, 9, 14, 15, 1, 3, 6, 19, 21, 29, 2, 6, 16, 23, 30, 31, 3, 6, 16, 23, 26, 30, 6, 11, 14, 23,
				26, 30, 2, 3, 6, 14, 31, 32, 1, 6, 14, 22, 25, 26 };
		int[] blue = { 4, 1, 3, 6, 16, 6, 12, 9, 3, 9, 12, 6, 6, 07, 9, 2, 12, 10, 5, 8, 8, 16, 14, 13, 7, 2, 14, 2, 3,
				12 };
		//筛选出每个数出现的次数
		int[][] count = cheak(number);
		int[] redBall = new int[6];
		for (int i = 0; i < count.length; i++) {
			redBall[i] = count[i][0];
			if (i == 5) {
				break;
			}
		}
		System.out.print("红球为:");
		Arrays.sort(redBall);
		for (int s : redBall) {
			System.out.print(s + " ");
		}
		System.out.println();
		int[][] countBlue = cheak(blue);
		System.out.println("篮球为:" + countBlue[0][0]);
		// 随机抽取
		Random rand = new Random();

		System.out.print("随机抽取的红球为:");
		boolean[] extract = new boolean[count.length];
		byte n = 0;
		while (true) {
			int ex = rand.nextInt(count.length);
			if (extract[ex] == false) {
				redBall[n] = count[ex][0];
				extract[ex] = true;
				n++;
			}
			if (n == 6) {
				break;
			}
		}
		Arrays.sort(redBall);
		for (int s : redBall) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("                 篮球为:" + countBlue[rand.nextInt(countBlue.length)][0]);
	}
/**
 * 
 * @param number 
 * 		  需要进行统计的int数组
 * @return 
 * 		返回int二维数字，int[values][count]
 */
	public static int[][] cheak(int[] number) {
		//用于存放数组是否被检查
		boolean[] numberBoolean = new boolean[number.length];
		//存放检查的key
		int[] numberStatistics = {};
		//存放检查key出现的次数
		int[] numberCount = {};
		int n = 0;
		for (int i = 0; i < number.length; i++) {
			if (numberBoolean[i] == true) {
				continue;
			}
			//给f初值，如果相同的数已经扩容过数组不在进行扩容
			boolean f = false;
			for (int j = 0; j < number.length; j++) {
				if (numberBoolean[j] == true) {
					continue;
				}
				if (number[i] == number[j]) {
					if (f == false) {
						numberStatistics = Arrays.copyOf(numberStatistics, numberStatistics.length + 1);
						numberCount = Arrays.copyOf(numberCount, numberCount.length + 1);
						numberStatistics[n] = number[i];
					}					
					numberCount[n] = numberCount[n] + 1;
					numberBoolean[j] = true;
					f = true;
				}

			}
			n++;
		}
		//用于存放筛选出来的key与values放在同一个二维数组中
		int[][] count = new int[numberCount.length][2];
		numberBoolean = new boolean[numberCount.length];
		n = 0;
		for (int i = 0; i < numberCount.length; i++) {
			count[i][0] = numberStatistics[i];
			count[i][1] = numberCount[i];
		}
		//进行倒序排序
		for (int i = 0; i < count.length - 1; i++) {
			for (int j = count.length - 1; j > i; j--) {
				if (count[i][1] < count[j][1]) {
					int[][] s = new int[1][2];
					s[0][0] = count[j][0];
					s[0][1] = count[j][1];
					count[j][0] = count[i][0];
					count[j][1] = count[i][1];
					count[i][0] = s[0][0];
					count[i][1] = s[0][1];
				}
			}

		}
		return count;

	}
}
