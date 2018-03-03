package 数组;
import java.util.Arrays;
public class 数组排序 {
	public static int[] b(int[] a){  //倒序
		for(int i=0;i<a.length;i++){
			for(int j=0;j<i;j++){
				if(a[i]	>a[j]){
					
					int c=a[i];
					a[i]=a[j];
					a[j]=c;
				}
			}
		}
		
		return a;
	}
	public static void main (String[] args){
		int [] a={5,3,1};
		//a=Arrays.copyOf(a, a.length+10);
	//	for(int i=a.length-10;i<a.length;i++){
	//		a[i]=i;
	//	}
		a=b(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
