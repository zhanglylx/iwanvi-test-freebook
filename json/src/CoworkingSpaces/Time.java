package CoworkingSpaces;

public class Time {
	private long time;
	public Time(){
		this.time = System.currentTimeMillis();
	}
	public long getTime(){
		return this.time;
	}
	public void setTime(int time){
		this.time = time;
	}
}
