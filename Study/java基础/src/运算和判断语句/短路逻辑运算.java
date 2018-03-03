package 运算和判断语句;
/**
 * 短路逻辑运算
 * @author Administrator
 *
 */
public class 短路逻辑运算 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int age=65;
		char sex='男';
		if (sex == '女' && age++>60){
			
		}
		System.out.println(age);//65 表示(age++>60) 没有执行
		//是短路逻辑
		//&& 是短路逻辑  大多使用短路逻辑&&
		// & 是非短路逻辑
	}

}
