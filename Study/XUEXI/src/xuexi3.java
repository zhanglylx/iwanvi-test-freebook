import java.util.Arrays;
public class xuexi3 {
	public static void main(String[]args){
		int[] arr=new int[]{3,2,1};
		
			
			Arrays.sort(arr);
		 int[] newarr=Arrays.copyOf(arr, arr.length);
		 for (int a=0;a<newarr.length;a++){
			 
		
			 System.out.println(newarr[a]);
			}
		}
}

