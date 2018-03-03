package monitor;

import java.util.Arrays;

public class containsSogou {

	public static String[] SogouAry(String[] ary) {
		// TODO 自动生成的方法存根
		int index=0;
		String[] ary1=new String[1];
		for(int i=0;i<ary.length;i++){
			 
			//System.out.println(ary[i]);
			for(int q=0;q<ary.length;q++){
			
				if(ary[i].contains(Package.Package(2))){
					int num=0;
					for(int k=0;k<ary1.length;k++){  //检查ary1中是否已经存入符合条件的数据
						if(ary[i].equals(ary1[k])){  //如果已经存入了数据，num=1，不在存入数据
							num=1;
						}
					}
					
					if(num==0){
						if(index==0){
							ary1[index]=ary[i];
						}else if(index>0){
							ary1=Arrays.copyOf(ary1, ary1.length+1);
							ary1[ary1.length-1]=ary[i];
						}
						index++;				
					}
				}
			}
		}
		return ary1;
	}

}
