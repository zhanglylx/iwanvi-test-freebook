package 概括;

import java.util.Arrays;

public class 认识的方式 {
	public static void main(String[] args) {  
		       String arr1[]=new String[]{"2","3","6","6","77"};  
		       for(String x:arr1){  
		            System.out.print(x+" ");  
		        }  
		          
		       Arrays.fill(arr1,2,2,"bb");  
		        System.out.println();  
		        for(String x:arr1){  
		            System.out.print(x+" ");  
		        }  
		         
		   }  

}
