package com.mail.My163mailTest.webserver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mail.My163mailTest.utils.ReadData;

public class WebServer {
	public WebDriver driverOptions(String browser,WebDriver driver ) {
		
		
		if(browser.equalsIgnoreCase("chrome")){
//			设置chromedriver.exe的路径
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			driver = new ChromeDriver(); //打开Chrome浏览器
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\iexplore.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

	
	public void connUrl(WebDriver driver){
		driver.get(ReadData.getAttribute("baseUrl"));
	}
}
