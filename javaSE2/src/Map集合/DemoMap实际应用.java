package Map集合;
/**
 * 测试联系人信息
 * @author Administrator
 *
 */
public class DemoMap实际应用 {

	public static void main(String[] args) {
		/**
		 * 创建一个联系人信息
		 */
		Map实际应用 someone = new Map实际应用();
		someone.set("name", "张连宇");
		someone.set("phone", "17710893436");
		someone.set("mail", "zhanglylx@163.com");
		someone.set("qq", "237597440");
		System.out.println(someone);
		System.out.println(someone.get("name")+"qq是："+someone.get("qq"));
		
		Map实际应用 otherone  = new Map实际应用();
		otherone.set("name", "苍老师");
		otherone.set("phone", "13426283025");
		System.out.println(otherone);
		System.out.println(otherone.get("name")+"qq是："+otherone.get("qq"));
		
		
	}

}
