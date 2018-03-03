package CoworkingSpaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import 招商平台.printErr;

public class StartEruptSimultaneously {
	/**
	 * 代码为预定办公桌并发 get1 get1 = new get1();代表一个线程，需要多个线程时， 创建多个get类继承get2
	 * 需要配置循环次数,执行次数,间隔时间,会议室总数,会议室时间默认为8:
	 * 日期默认为系统日期如:20170918
	 * 
	 * @param args
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	static int i = 0;
	static int officeId = 1;
	static int indexTimeDate = 0;

	public static void main(String[] args) throws ParseException, InterruptedException {
		List<String> errList = new LinkedList<String>();
		List<String> correctList = new LinkedList<String>();
		Map<String, Object> timeDateMap = new HashMap<>();
		get1 get1 = new get1();
		get2 get2 = new get2();
		get3 get3 = new get3();
		get4 get4 = new get4();
		get5 get5 = new get5();
		DateTime date = new DateTime(8, 30);

		// 执行次数
		int index = 200;
		//并发线程
		int thread = 5;
		// 间隔时间 单位ms
		int intervalTime = 0;
		// 会议室总数
		int meetingSum = 8;
		// token
		String token1 = "0ad9deaaa13020cf79b19a76b9100345";
		//循环记录
	    int indexCirculation = 0;
		while (true) {
			if (indexCirculation == index) {
				break;
			}
			check ch = new check(thread);// 需要开始的线程数，必须配置
			// 需要配置线程的id
			StartEruptSimultaneously reserve = new StartEruptSimultaneously();
			timeDateMap = reserve.timeDate(date.fromTimeDate(), date.toTimeDate());
			String fromTimeDate = (String) timeDateMap.get("fromTimeDate");
			String toTimeDate = (String) timeDateMap.get("toTimeDate");
		    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    Long time=new Long(fromTimeDate+"000");  
		    String d = format.format(time);  
		    System.out.println("Format To StringText(Date):"+d);
		    SimpleDateFormat format2 =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    Long time2=new Long(toTimeDate+"000");  
		    String d3 = format2.format(time2);  
		    System.out.println(" To StringText(Date):"+d3);
			System.out.println();
			int officeId = StartEruptSimultaneously.officeId;
			get1.run(1, officeId, fromTimeDate, toTimeDate, token1);
			get2.run(2, officeId, fromTimeDate, toTimeDate, token1);
			get3.run(3, officeId, fromTimeDate, toTimeDate, token1);
			get4.run(4, officeId, fromTimeDate, toTimeDate, token1);
			get5.run(5, officeId, fromTimeDate, toTimeDate, token1);
			
			// 检查线程已经执行完毕	
			while (true) {
				int t=0;
				Map<Thread,StackTraceElement[]> maps = Thread.getAllStackTraces();
				for(Thread s : maps.keySet()){
					if(s.toString().matches(".+,main]")){
						t+=1;
					}
				}
				if(t==1){
					break;
				}
			}			
			indexCirculation++;		
			if (ch.checkCheck()) {
				correctList.add("第" + indexCirculation + "次检查通过");
			} else {
				errList.add("第" + indexCirculation + "次检查不通过");
			}
			// 超过第meetingSum会议室停止
			
			System.out.println(indexCirculation);
			System.out.println("==================================");
			//会议室所有时间预定完成后更换会议室
			if(toTimeDate.equals(date.toTimeDate()[date.toTimeDate().length-1])){
				StartEruptSimultaneously.officeId++;
				if (StartEruptSimultaneously.officeId == meetingSum +1) {
					System.out.println(officeId);
					System.out.println(meetingSum +1);
					break;
				}
			}
			
			Thread.sleep(intervalTime);
			
		}
		System.out.println("检查不通过list:");
		new printErr(errList);
		System.out.println("检查通过list:");
		new printErr(correctList);
		System.exit(0);
	}

	public Map<String, Object> timeDate(String[] fromTimeDate, String[] toTimeDate) {
		Map<String, Object> timeDate = new HashMap<String, Object>();
		String from;
		String to;
		if (StartEruptSimultaneously.indexTimeDate == 0) {
			from = toTimeDate[StartEruptSimultaneously.indexTimeDate];
			to = fromTimeDate[StartEruptSimultaneously.indexTimeDate + 1];
		} else if (StartEruptSimultaneously.indexTimeDate == toTimeDate.length-1 && i==0) {
			from = fromTimeDate[StartEruptSimultaneously.indexTimeDate];
			to = toTimeDate[StartEruptSimultaneously.indexTimeDate];
			StartEruptSimultaneously.indexTimeDate = -1;
		} else {
			if(i==0){
			from = fromTimeDate[StartEruptSimultaneously.indexTimeDate];
		    to = toTimeDate[StartEruptSimultaneously.indexTimeDate];	
		    i=1;
			}else{
		    from = toTimeDate[StartEruptSimultaneously.indexTimeDate-1];
		    to = fromTimeDate[StartEruptSimultaneously.indexTimeDate];
		    i=0;
		    StartEruptSimultaneously.indexTimeDate--;
			}
		}
		StartEruptSimultaneously.indexTimeDate++;
		timeDate.put("fromTimeDate", from);
		timeDate.put("toTimeDate", to);
		return timeDate;

	}

}
