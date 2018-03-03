package 循环;
/**
 * for 最常用，甚至只用这一个可以解决任何循环问题
 *     for 最常用在与次数有关的循环处理
 * 
 * while 很常用，用在循环时候要先检查循环条件在处理循环体
 *       用在与次数无关的情况。
 *       如果不能明确结束条件的时候，先使用while(true)，在
 *       适当条件使用break结束循环。
 *
 * do while 在循环最后判断是否结束的循环
 *    如：使用while(true) 实现循环时候，结束条件break在while
 *       循环体的最后，就可以使用do while。
 *    do while 的结束条件经常是“否定逻辑条件”，不便于思考业务逻辑。
 *    使用时候要注意，可以利用while(true)+break 替换
 *    
 *    
 *    循环的替换
 *    while(布尔表达式){} 等价 for(;布尔表达式;){}
 *    while(true){}  等价 for(;;){}
 *    while(true) + break 替换 do{}while(布尔表达式);
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class for_while_dowhile说明 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
