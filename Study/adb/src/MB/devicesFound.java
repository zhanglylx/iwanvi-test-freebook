package MB;

public class devicesFound {
	public static void devicesfound(String[] ary){
		
		if(ary[0]!=null){
			
			for(int i=0;i<ary.length;i++){
		if(ary[i].contains("error: no devices found")){
			System.out.println("设备中断");
			System.exit(0);
		}
		}
		}
	}
}
