package 万达;

import java.util.Arrays;
public class Ary {
	String[] str = new String[0];
	int []   in = new int[0];
	public static String [] ArrayCapacity(String[] str){
		  str = Arrays.copyOf(str, str.length+1);
		return str;		
	}
	public static int [] ArrayCapacity(int[] in){
		in = Arrays.copyOf(in, in.length+1);
		return in;
		
	}
}
