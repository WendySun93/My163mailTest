package com.mail.My163mailTest.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadData {
	static String profilepath = "src/test/resources/dataSource.properties";
	

	public static String getAttribute(String inputkey){
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(profilepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props.getProperty(inputkey);

	}

	
}
