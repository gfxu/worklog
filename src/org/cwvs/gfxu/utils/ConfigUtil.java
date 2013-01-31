package org.cwvs.gfxu.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;



public class ConfigUtil {
	private static Properties prop = new Properties();//属性集合对象    
	private static final String fileName = "/conf/config.properties";
	private static String strFilePath=null;
	private static FileInputStream fis=null;//属性文件流    

	
	private ConfigUtil() throws IOException{

	}
	/**
	 * 获得配置文件属性
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	public static String getProperty(String key) throws IOException{		
		strFilePath= System.getProperty("user.dir") ;
		String filePath =strFilePath +fileName;
		fis=new FileInputStream(filePath);//属性文件流    
		prop.load(fis);//将属性文件流装载到Properties对象中   
		return prop.getProperty(key);
	}
	



}
