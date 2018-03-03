package monitor;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.swing.JOptionPane;

import monitor.meminfo;
import MB.devices;
public class statistics {

	public static void main(String[] args) throws IOException, InterruptedException {
		boolean device=devices.devices();//检测devices是否存在	
		if(device==false){ //检测是否有设备连接
			JOptionPane.showMessageDialog(null, "没有找到设备", "提示", JOptionPane.WARNING_MESSAGE); 
			System.exit(0);
			
		}
	
		int[] getUid=GetUid.getUid();
		
		long 	transferWlan=0;
		long 	results=0;
		int 	maximum=0;
		long	summeminfo=0;  //记录获取内存的总数
		double 	sumcpu=0.0d;
		int 	num =0;
		double  average=0.0d; 
		double	avgCpu=0.0D;
		byte 	index=0;
		long	sumWlan=0;
		long 	wlan=0;
		byte 	number=0;
		double  flowmeter=0.0d;
		byte    GetUidNull=0;
		int     cpunum=0;
		double  cpudouble=0.0d;
		//long    numbercount=1;
		//long    numbercountlook=0;
		多线程弹出窗口.exi();
		while(true){
			double cpu=cpuinfoTop.cpuinfo(); //通过top方法获取cpu的值
			int m =meminfoPs.meminfoPs(); //获取内存的使用值
			//int m =monitor.monitor();
			if(m!=0 && GetUidNull==0){//判断客户端是否开启，开启后更新uid
				getUid=GetUid.getUid();
				GetUidNull=1;
				}else if(m==0){
					GetUidNull=0;
				}
			if(maximum<m){   //计算最大内存使用值
				maximum = m;
			}
			//---------------计算流量
			
			long GetWlan=getwlan.getwlan(getUid);
			if(GetWlan!=0){//获取的流量为0时，wlan值保持上次的值不变
				if(index==0 ){
					transferWlan = GetWlan;
					index =1;			
				}else if(index==1){
					results = GetWlan;	
					index =0;				
				}					
			if(number==0){ //获取第一遍时，wlan直接为0
				wlan=0;
				number=1;
				}else{
					if(index==0){//第2遍时，用第2次获取的wlan值减去第一遍的值
					sumWlan = results - transferWlan;
					}else if(index ==1){//第三遍时，用第3次获取的wlan值减去第二遍的值
						sumWlan = transferWlan - results;
					}
					wlan =sumWlan+wlan;				
				}
			}
			if(index==0){//检查程序是否卸载重装或者其他更换手机时,wlan=0;
				if(results<transferWlan){
					wlan=0;
					System.out.println("更换了手机或者其他操作，wlan清0");
				}else if(index ==1){
					if(transferWlan<results){
						System.out.println("更换了手机或者其他操作，wlan清0");
						wlan=0;
					}
				}else if(wlan <0){
					wlan=0;
					System.out.println("更换了手机或者其他操作，wlan清0");
				}
				
			}			
			//---------------
			//-----------cpu计算
			BigDecimal a2 = new BigDecimal(Double.toString(sumcpu)); 
			BigDecimal b2 = new BigDecimal(Double.toString(cpu)); 
			sumcpu =a2.add(b2).doubleValue(); //cpu相加
			//-----------
			summeminfo=summeminfo+m;//内存相加		
			if(m!=0){
			++num;
			flowmeter = 1.0*wlan/1024;
			average=summeminfo*1.0/num;//内存平均值
			
			}
			if(cpudouble!=cpu){
				++cpunum;
				avgCpu =sumcpu*1.0/num;//cpu平均值
			}
			//System.out.print("流量为:"+flowmeter+" KB");
			System.out.print("  内存平均值为: "+average+" KB");
			System.out.print("  内存最大值为:"+maximum+" KB");
			System.out.println("  cpu平均率为:"+avgCpu+"%");
			System.out.println("内存实时使用数据:"+m+" KB");
			System.out.println("cpu实时数据:"+cpu+"%");
			System.out.println("循环次数:"+num);
			System.out.println("--------------------------------");
			//Thread.sleep(1000);
			//numbercountlook =numbercountlook+numbercount;
			
			
		}
		
		
		
	}
	}


