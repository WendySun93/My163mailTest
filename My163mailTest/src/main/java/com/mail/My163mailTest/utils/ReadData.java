package com.mail.My163mailTest.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
