package GifBrewery;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileTime {
	
	public static String timeGif(String path){
	     Calendar cal = Calendar.getInstance(); 
	     long time = fileLastModifiedGif(path); 
	     cal.setTimeInMillis(time); 
	     SimpleDateFormat timea=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss" );
			String date = timea.format(cal.getTime());
	     return date;	    	    	 
	     }
	public static long fileLastModifiedGif(String path){ //检查GIF修改时间
		File file=new File(path); 
		return file.lastModified();
	}
}
