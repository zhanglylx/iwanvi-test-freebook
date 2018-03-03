package Map集合;

import java.util.HashMap;
import java.util.Map;

/**
 * 联系人信息
 * @author Administrator
 *
 */
public class Map实际应用 {
	/**
	 * 定义一个Map类型属性
	 * 该属性可以存放自定义的属性内容
	 * @param args
	 */
	Map<String,String> fields = new HashMap<String,String>();
	/**
	 * 设置属性的方法
	 * @param field 属性名
	 * @param value 属性值
	 */
	public void set(String field,String value){
		fields.put(field, value);
	}
	/**
	 * 获取联系人信息
	 * @param field 属性名
	 * @return		对应该属性的值
	 */
	public String get(String field){
		return fields.get(field);
	}
	
	
	
	@Override
	public String toString() {
		//将HashMap的toString()作为联系人的toString()返回
		return fields.toString();
	}

}
