package MB;
import java.util.Arrays;
import java.util.Scanner;
//能够处理18行的数据
//终止pv需要在第一个PV数据上填写1
//终止日启，需要填写1
public class URL {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		int[] g = new int[]{5325454
				 ,5346871
				 ,5400659
				 ,50970
				 ,50092
				 ,53150
				 ,57587
				 ,58360
				 ,58288
				 ,57528
				 ,58887
				 ,53398
				 ,59603
				 ,59991
				 ,61191
				 ,61300
				 ,61227
				 ,61562
				 ,60356
				 ,60276
				 ,60826
				 ,59476
				 ,56180
				 ,55857
				 ,55380
				 ,57256
				 ,57420
				 ,56669
				 ,51308
				 ,11111
				 };  //崩溃数,不用管，有个默认值就可以
				 
				 
		
		int v=0;
		int number=0;
		
		Scanner console = new Scanner(System.in);
		while(true){
			String[] b =new String[]{"0"};
			String[] b1 =new String[]{"0"};
		String[] a =new String[]{"0"};
		String[] a1 =new String[]{"0"};
		String[] a2 =new String[]{"0"};
		String[] a3 =new String[]{"0"};
		String[] a4 =new String[]{"0"};
		String[] a5 =new String[1];
		String[] a6 =new String[1];
		String[] a7 =new String[1];
		String[] a8 =new String[1];
		String[] a9 =new String[1];
		String[] a10 =new String[1];
		String[] a11 =new String[1];
		String[] a12 =new String[1];
		String[] a13 =new String[1];
		String[] a14 =new String[]{"0"};
		String[] a15 =new String[]{"0"};
		String[] a16 =new String[]{"0"};
		String[] a17 =new String[]{"0"};
		String[] a18 =new String[]{"0"};
		String[] a19 =new String[]{"0"};
		String[] a20 =new String[]{"0"};
		
		System.out.println("请输入第"+(v+1)+"个crash:");
		b1[0]= console.nextLine();
		b[0] = console.nextLine();
		a[0] = console.nextLine();
		a1[0] = console.nextLine();
		a2[0] = console.nextLine();
		a3[0] = console.nextLine();
		a4[0] = console.nextLine();
		a5[0] = console.nextLine();
		a6[0] = console.nextLine();
		a7[0] = console.nextLine();
		a8[0] = console.nextLine();
		a9[0] = console.nextLine();
		a10[0] = console.nextLine();
		a11[0] = console.nextLine();
		a12[0] = console.nextLine();
		a13[0] = console.nextLine();
		a14[0] = console.nextLine();
		a15[0] = console.nextLine();
		a16[0] = console.nextLine();
		a17[0] = console.nextLine();
		//a18[0] = console.nextLine();
		if(a[0].contains("version")==false){
			a[0]=a1[0];
			a1[0]=a2[0];
			a2[0]=a3[0];
			a3[0]=a4[0];
			a4[0]=a5[0];
			a5[0]=a6[0];
			a6[0]=a7[0];
			a7[0]=a8[0];
			a8[0]=a9[0];
			a10[0]=a11[0];
			a11[0]=a12[0];
			a12[0]=a13[0];
			a13[0]=a14[0];
			a15[0]=a16[0];
			a16[0]=a17[0];		
			a17[0]="version[2800_2800]	 pv[2]	 uv[18]";
		}
		int q =0;
		int q1=0;
		int q2=0;
		int q3=0;
		int q4=0;
		int q5=0;
		int q6=0;
		int q7=0;
		int q8=0;
		int q9=0;
		int q10=0;
		int q11=0;
		int q12=0;
		int q13=0;
		int q14=0;
		int q15=0;
		int q16=0;
		int q17=0;
		int q18=0;
		q=c(a);
		if(q==1){			
				System.out.println("切换到日启:");
				break;			
		}
		q1=c(a1);
		q2=c(a2);
		q3=c(a3);
		q4=c(a4);
		q5=c(a5);
		q6=c(a6);
		q7=c(a7);
		q8=c(a8);
		q9=c(a9);
		q10=c(a10);
		q11=c(a11);
		q12=c(a12);
		q13=c(a13);
		q14=c(a14);
		q15=c(a15);
		q16=c(a16);
		q17=c(a17);
		//q18=c(a18);
		int w =q+q1+q2+q3+q4+q5+q6+q7+q8+q9+q10+q11+q12+q13+q14+q15+q16+q17+q18;
		System.out.println("结果为:"+w);	
		g[v]=w;
		
		v++;
		}
		
		int[] h = new int[31];  //日启
		v=0;
		while(true){
			int a = console.nextInt();
			h[v]=a;
			if(a==1){
				break;
			}
			v++;
		}
		double[] o = new double[30];
		int u=1;
		for(int i=0;i<g.length;i++){
			System.out.print("7月"+(u)+"日pv崩溃:"+g[i]+"  ");
			System.out.print("7月"+(u)+"日启动数:"+h[i]+"  ");
			double t = g[i];
			double y = h[i];
			double f = t/y;
			System.out.print("7月"+(u)+"日崩溃率:"+f);
			System.out.println();
			o[i]=f;
			u++;
		}
		double aa =0.0;
		for(int i=0;i<o.length;i++){
			aa = aa+o[i];
	}
		System.out.println("7月总崩溃率为:"+(aa/30.0));
	}
	public static int c(String a[]){
		int b=0;
		if(a[0].equals("1")){
			
		}else{
		a=a[0].split("pv\\[");
		a=a[1].split("\\]");
		System.out.println(a[0]);
		
		 b=Integer.parseInt(a[0]);
	}
		return b;
	}
/*
 *
 *48364    48364
 *50825
 *49799
 *50970
 *50092
 *53150   53150
 *57587
 *58360
 *58288   58288
 *57528
 *58887
 *53398
 *59603   59603
 *59991
 *61191
 *61300
 *61227  61227
 *61562
 *60356  60356
 *60276
 *60826
 *59476
 *56180
 *55857
 *55380
 *57256
 *57420
 *56669
 *51308
 *50529
 *
 *
 *
 *
 * 
 */
}
