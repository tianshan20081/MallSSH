package com.java1234.util;

import java.text.SimpleDateFormat;
import java.util.Date;




public class DateUtil {

	public static String dataformat(Date date, String format){
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(date!=null){
			result = sdf.format(date);
		}
		return result;
	}
	
	public static String imageName(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
}
