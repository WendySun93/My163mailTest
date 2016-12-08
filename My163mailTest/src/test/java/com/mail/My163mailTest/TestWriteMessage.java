package com.mail.My163mailTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mail.My163mailTest.pageobjects.IndexPage;
import com.mail.My163mailTest.pageobjects.LoginPage;
import com.mail.My163mailTest.utils.ReadData;
import com.mail.My163mailTest.webserver.WebServer;


public class TestWriteMessage extends BaseTest {
	public WebDriver driver;
	WebServer webServer = new WebServer();
	Logger log = Logger.getLogger(getClass());
	String browser = ReadData.getAttribute("browser");
	LoginPage loginPage;
	IndexPage indexPage;
	WebDriverWait wait;
	
	
	@BeforeClass
	public void setUp() {
		log.info("===========case03 写信=========");
		driver = webServer.driverOptions(browser,driver);
		wait = new WebDriverWait(driver, 10); 
		webServer.connUrl(driver);
		loginPage = new LoginPage(driver);
		this.user_login(wait);
		log.info("=========已用手机号登录139邮箱===========");
		indexPage = new IndexPage(driver);
	}

	@AfterClass
	public void tearDown() {
//		this.user_logout(driver);
//		driver.quit();	
	}

	@Test(priority = 1)
	public void writeMessage(){
		indexPage.writeMessage(driver,wait);
	}
	
}
