package MB;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileTime {
	
	public static String timeGif(String a){
	     Calendar cal = Calendar.getInstance(); 
	     long time = fileLastModifiedGif(a); 
	     cal.setTimeInMillis(time); 
	     SimpleDateFormat timea=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss" );
			String date = timea.format(cal.getTime());
	     return date;	    	    	 
	     }
	public static long fileLastModifiedGif(String a){ //检查GIF修改时间
		File file=new File(path.path()+a); 
		return file.lastModified();
	}
}
