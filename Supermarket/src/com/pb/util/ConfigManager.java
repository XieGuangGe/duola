package com.pb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//读取配置文件（属性文件）的工具类
public class ConfigManager {
	private static ConfigManager configManager;
	//properties.load(InputStream);读取属性文件
	private static Properties properties; 
	
	private ConfigManager(){
		//加载文件
		String configFile="database2.properties";
		properties=new Properties();
		InputStream in=ConfigManager.class.getClassLoader()
				.getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConfigManager getInstance(){
		//单例模式
		if(configManager==null){
			configManager=new ConfigManager();
		}
		return configManager;
	}
	
	public String getString(String key){
		return properties.getProperty(key);
	}
}
