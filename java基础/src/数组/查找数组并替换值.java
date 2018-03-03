package 数组;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 * @author Administrator
 *
 */
public class 查找数组并替换值 {

	public static void main(String[] args) {
		int[] arr = {1,3,4,5,0,0,6,6,0,5,4,7,6,0,0,5};
		Arrays.sort(arr);
		Random rand = new Random();
		int count = 0;
		while(true){
			if(Arrays.binarySearch(arr, 0) <0){
				break;
			}
			arr[Arrays.binarySearch(arr, 0)] = rand.nextInt(10)+1;
			++count;
			Arrays.sort(arr);
		}
		
		for(int s: arr){
			System.out.println(s);
		}
		JOptionPane.showMessageDialog(null,  "共更换:"+count+"次");
		boolean[] numberBoolean = new boolean[arr.length];
		int[] numberStatistics = {};
		int[] numberCount = {};
		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			if (numberBoolean[i] == true) {
				continue;
			}
			boolean f = false;
			for (int j = 0; j < arr.length; j++) {
				if (numberBoolean[j] == true) {
					continue;
				}
				if (arr[i] == arr[j]) {
					if (f == false) {
						numberStatistics = Arrays.copyOf(numberStatistics, numberStatistics.length + 1);
						numberCount = Arrays.copyOf(numberCount, numberCount.length + 1);
					}
					numberStatistics[n] = arr[i];
					numberCount[n] = numberCount[n] + 1;
					numberBoolean[j] = true;
					f = true;
				}

			}
			n++;
		}
		int[][] countNum = new int[numberCount.length][2];
		numberBoolean = new boolean[numberCount.length];
		int wh = 0;
		n = 0;
		for (int i = 0; i < numberCount.length; i++) {
			countNum[i][0] = numberStatistics[i];
			countNum[i][1] = numberCount[i];
		}
		for (int i = 0; i < countNum.length - 1; i++) {
			for (int j = countNum.length - 1; j > i; j--) {
				if (countNum[i][1] < countNum[j][1]) {
					int[][] s = new int[1][2];
					s[0][0] = countNum[j][0];
					s[0][1] = countNum[j][1];
					countNum[j][0] = countNum[i][0];
					countNum[j][1] = countNum[i][1];
					countNum[i][0] = s[0][0];
					countNum[i][1] = s[0][1];
				}
			}

		}
	for(int i=0;i<countNum.length;i++){
		System.out.println(countNum[i][0]+"共出现:"+countNum[i][1]+"次");
	}
		
	}

}
