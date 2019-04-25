package com.pb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//��ȡ�����ļ��������ļ����Ĺ�����
public class ConfigManager {
	private static ConfigManager configManager;
	//properties.load(InputStream);��ȡ�����ļ�
	private static Properties properties; 
	
	private ConfigManager(){
		//�����ļ�
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
		//����ģʽ
		if(configManager==null){
			configManager=new ConfigManager();
		}
		return configManager;
	}
	
	public String getString(String key){
		return properties.getProperty(key);
	}
}
