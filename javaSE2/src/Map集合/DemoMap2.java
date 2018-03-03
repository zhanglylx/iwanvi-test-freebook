package Map集合;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Map的小应用
 * 
 * boolean containsKey(K key):当前map中是否包含给定的key
 * boolean containsValue(V value):当前map中是否包含给定的value
 * @author Administrator
 *
 */
public class DemoMap2 {

	public static void main(String[] args) {
		/**
		 * 需求:统计每个数字出现的次数
		 * 思路：
		 * 		使用每个数字作为key存放在map中，默认值为1
		 * 		之后判断后面的数字是否作为key在map中存在:
		 * 		结果:
		 * 		1：不存在：那么使用这个数字作为key，value为1存入
		 *      2：存在：那么使用key将value取出加1后再存入
		 * 步骤：
		 * 		1.将字符串str根据","拆分
		 *  	2.创建map
		 *  	3.循环拆分后字符串数组
		 *  	4.将每一个数字作为key在map中检查是否包含
		 *  	5.包含则对value值累加1
		 *  	6.不包含则使用该数字作为key，value为1存入map
		 */
		String str = "123,456,789,225,,,,698,759,456";
		//1
		String[] array = str.split(",");
		String[] arr = new String[0];
		int n=0;
		for(int i=0;i<array.length;i++){
			if("".equals(array[i])==false){
				arr=Arrays.copyOf(arr, arr.length+1);
				arr[n]=array[i];
				n++;
			}
		}
		System.out.println(Arrays.toString(arr));
		//2
		Map<String,Integer> map = new HashMap<String,Integer>();
		//3
		for(String number : array){
			//4
			if(map.containsKey(number)){
				//5
				map.put(number,  map.get(number)+1);
			}else{
				//6
				map.put(number, 1);
			}
			
		}
		System.out.println(map);
		//遍历map中的key和values
		for(Map.Entry<String, Integer> m : map.entrySet()){
			System.out.println("Key："+m.getKey()+",值："+m.getValue());
		}

	}

}
