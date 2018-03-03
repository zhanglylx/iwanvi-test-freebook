package 运算和判断语句;
import java.util.Scanner;
/**
 * 工资个税的计算公式为：
 * 应纳税额=(工资薪资所得-扣除数)X适用税率-速算扣除数
 * 全月应纳税所得额=月工资薪金所得-扣除数
 * 2011年9月1日起执行7级超额累进税率:扣除数为3500
 * 个人所得税缴纳标准：
 * 全月应纳税额不超过1500元     税率:3%  速算扣除数:0
 * 全月应纳税超过1500元至4500元   税率:10%  速算扣除数:105
 *全月应纳税超过4500元至9000元   税率:20%  速算扣除数:555
 *全月应纳税超过9000元至35000元   税率:25%  速算扣除数:1005
 *全月应纳税超过35000元至55000元   税率:30%  速算扣除数:2755
 *全月应纳税超过55000元至80000元   税率:35%  速算扣除数:5505
 *全月应纳税超过80000         税率:45%  速算扣除数:13505
 *
 * @author Administrator
 *
 */
public class if语句练习工资个税计算 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入工资:");
		double salary=scan.nextDouble();
			salary = salary-3500;
		double tax=0;
		if(salary>0){
		if (salary<=1500){
			tax =salary*0.03;
			System.out.println("1");
		}else if (salary<=4500){
			tax =salary*0.1-105;
			System.out.println("2");
		}else if (salary<=9000){
			tax =salary*0.2-555;
			System.out.println("3");
		}else if (salary<=35000){			
			tax =salary*0.25-1005;
			System.out.println("4");
		}else if (salary<=55000){
			tax =salary*0.3-2755;
			System.out.println("5");
		}else if (salary<=80000){
			tax =salary*0.35-5505;
			System.out.println("6");
		}else{
			tax =salary*0.45-13505;
			System.out.println("7");
		}
		System.out.println(tax);
		}else{
			int inttax=(int)tax;
			System.out.println(inttax);
		}
		
		/*
	//////////////////////////////////////
		//第二种
		double tax;//税
		double taxIncome; //Income 收入;税收
		taxIncome =salary -3500;
		if (taxIncome <=0){
			tax = 0;
		}else if (taxIncome <=1500){
			tax = taxIncome *(3.0/100);
		}else if(taxIncome <=4500){
			tax = taxIncome * (10D/100)-105;
		}
		*/
	}

}
