package 免费电子书;

public class ArrayIndex {
	public static int index(int[] arrays,int index){
		if (index == arrays.length) {
			index = 0;
		}
		return index;
	}
}
