package 万达;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import jir.LocalProxy;
import 轻客户端.api;
public class API1 {

	public static void main(String[] args) {
		LocalProxy.LocalProxy();//设置请求时通过本地代理方式连接
		String url="https://api.ffan.com/ihos/beacon/v1/beaconsByUMM?callId=SYTM&coordinate=mercator&plazaId=1100079&re"
				+ "qTime=1499909424&signValue=11464b596578906c00edd52d25843a3250300b60";
		String response;
		response=api.loadJSON(url);
		response = "\"minor\":\""+response+"\"";
		System.out.println(response);
		String find = "d";
		String path = "D:/a.xls";
		String[] Excel =万达.Excel.ExcelNative(path, "获取所有列",find);
		int[] str = new int[0];
		int num = 0;
		for(int i=1;i<Excel.length;i++){//比对Excel信息是否存在接口中
			
			if(response.contains(Excel[i])){
			}else{							
				 //将错误信息添加进数组
				//给str数组扩容
					str = Arrays.copyOf(str, str.length+1);
					str[num]= i;
					num++;
				
			}
		}
		String[] values = new String[str.length];
		for(int i=0;i<str.length;i++){
			System.out.println(Excel[str[i]]);
			values[i]=Excel[str[i]];
		}		
		Ary arr = new Ary();	
		//StringText[] list = new StringText[0];
		//int []    number   = new int[0];
		int  ber = 0;
		byte one =0; 
		byte valuesOne=0;
		boolean[] boo = new boolean[str.length];
		/*
		 * 检查重复数据，使用boo判断当前值是否已经经过了筛选，使用ber给统计数据的值做索引
		 * 使用one值确定当前值是否是唯一
		 * 使用valuesOne判断当前值是否已经统计在arr.str数组中
		 * arr.str记录最后的没有出现在对比数据中的错误
		 * arr.in记录重复的数据重复多少次
		 */
		for(int i=0;i<str.length;i++){ //检查重复数据，统计有多少个个数
			if(boo[i]==true){continue;} //
			for(int j=0;j<values.length;j++){	
				if(boo[j]==true){continue;}
				if(values[i].equals(values[j]) && boo[j] == false){	//判断是否是重复数据并且当前值没有被检测
					boo[j] =true;
					if(valuesOne == 0){ //重复数据给arr.str赋值一次
						arr.str=Ary.ArrayCapacity(arr.str);
						arr.str[ber]=values[i];
						valuesOne =1;
					}		
					arr.in=Ary.ArrayCapacity(arr.in);	
					arr.in[ber] = arr.in[ber]+1;
					one = 1;
				}
			}
			if(one == 0){  //如果检测数据是唯一
				arr.str=Ary.ArrayCapacity(arr.str);
				arr.str[ber]=values[i];		
				one =0;
				arr.in=Ary.ArrayCapacity(arr.in);	
				arr.in[ber] = arr.in[ber]+1;	
			}
			ber++;
			valuesOne=0;
			boo[i] = true;
		}	
		for(int i = 0;i<arr.str.length;i++){
			System.out.println(find + " 未找到，数据为: "+arr.str[i]+"共出现:"+arr.in[i]);
		}




	}
	public static int repetition(String[] a,String[] b){



		return 0;

	}
}
