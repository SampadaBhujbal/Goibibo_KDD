package com.goibibo.customUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CustomUtil {
	static Properties prop=new Properties();
	public static String getProperty(String locaterName) {
	String locater="";
	try {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\shree-pc\\eclipse-workspace\\Goibibo_KDD\\src\\main\\resources\\ObjectRepository.properties");
	}catch(FileNotFoundException e) {
		e.printStackTrace();
		System.err.println("Object Repository not found");
		
	}catch(IOException e)	{
		e.printStackTrace();
		System.err.println("File not found");
		
	}
	return locater;
	}
	public static String[] getLocaterValue(String locaterName) {
		return getProperty(locaterName).split("##");

	}
}
