package 对象数组;

public class 二维数组 {

	public static void main(String[] args) {
		int [][] ary = new int[3][5];//等价{{0,0,0},{0,0,0}}
		ary[1] = new int[]{4,5,6,7};
		
		System.out.println(ary[1][2]);
		System.out.println(ary.length);
		System.out.println(ary[0].length);
		System.out.println(ary[1].length);
		System.out.println(ary[0][3]);
	}

}
