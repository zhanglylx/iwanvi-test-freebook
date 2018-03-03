package 免费电子书;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
public class test {
public static void main(String[] args) {
	 LinkedHashMap<String, Integer> userMap = new LinkedHashMap<String, Integer>();
	//获取广告出现的次数
	 LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();	
	 map=测试后台统计用户点击量_曝光量_广告总点击量_广告总曝光量.addUv(userMap, map, 456, "GG-1", 12345);
	 System.out.println(map.toString());
	 System.out.println(Math.random());
	 System.out.println( (int) ((Math.random() * 9 + 1) * 100000));
}
}
