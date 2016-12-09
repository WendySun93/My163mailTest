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


public class TestIndexPage extends BaseTest {
	public WebDriver driver;
	WebDriverWait wait;
	IndexPage indexPage;
	WebServer webServer = new WebServer();
	Logger log = Logger.getLogger(getClass());
	String browser = ReadData.getAttribute("browser");
	
	@BeforeClass
	public void setUp() {
		log.info("===========case02 163邮箱写信=========");
		driver = webServer.driverOptions(browser,driver);
		wait = new WebDriverWait(driver, 10); 
		webServer.connUrl(driver);
		this.loginPage = new LoginPage(driver);
//		this.user_login(wait);
//		log.info("=========已录163邮箱===========");
		indexPage = new IndexPage(driver);
		
	}

	@AfterClass
	public void tearDown() {
//		driver.quit();	
	}
	
	@Test(priority = 1)
	public void assertLoginButton() {
		if (loginPage.allBtnIsExist(driver) == true) {
			log.info("===========获取页面正确=============");
		} else {
			log.error("===========获取页面错误=============");
		}
	}
	
	// 登录邮箱操作
	@Test(priority = 2, dependsOnMethods = { "assertLoginButton" })
	public void login() {
		this.user_login(wait);
		log.info("=========已登录163邮箱===========");
	}
	//写信操作
	@Test(priority = 2,dependsOnMethods = { "login" })
	public void writeMessage(){
//		indexPage.writeMessage(driver,wait);
		indexPage.writeMessageWithAttachment(driver,wait);
	}
	
}
