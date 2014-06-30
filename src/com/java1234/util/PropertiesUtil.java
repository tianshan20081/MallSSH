package com.java1234.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static String getValue(String key) throws IOException{
		Properties p = new Properties();
		InputStream in = new PropertiesUtil().getClass().getResourceAsStream("/page.properties");
		p.load(in);
		return (String)p.get(key);
	}
}
