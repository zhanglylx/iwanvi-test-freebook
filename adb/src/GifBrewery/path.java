package GifBrewery;

import java.text.SimpleDateFormat;
import java.util.Date;

public class path {
	static final String ffmpegPatb = "F:\\ffmpeg\\ffmpeg-3.3.3-win64-shared\\bin";
	static final String pullPath = "F:\\video\\";
	static final String pathBase = "F:";
	private String gifName ;
	private String mp4Name ;
	public path(){
		Date dt = new Date();
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyyMMddHHmmsssss");
		String date = matter1.format(dt);
		this.gifName = date+".gif";
		this.mp4Name = "test"+".mp4";
	}
	public String getGifName(){
		return gifName;
	}
	public String getMp4Name(){
		return mp4Name;
	}
	
}
