package com.mail.My163mailTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mail.My163mailTest.pageobjects.IndexPage;
import com.mail.My163mailTest.pageobjects.LoginPage;
import com.mail.My163mailTest.pageobjects.LogoutPage;
import com.mail.My163mailTest.utils.ReadData;
import com.mail.My163mailTest.webserver.WebServer;

public class BaseTest {
	public WebDriver driver;
	WebDriverWait wait;
	WebServer webServer = new WebServer();
	LoginPage loginPage;
	LogoutPage logoutPage;
	Logger log = Logger.getLogger(getClass());
	String browser = ReadData.getAttribute("browser");
	//登录
	public void user_login(WebDriverWait wait){
		String user = ReadData.getAttribute("loginuser");
		String passwd = ReadData.getAttribute("loginpasswd");
		loginPage.login(user,passwd,wait);
	}
	
	public void user_logout(WebDriver driver,WebDriverWait wait){
		logoutPage.logOut(driver,wait);
	}
	
	@BeforeClass
	public void setUp() {
		log.info("===========开始登陆喽=========");
		driver = webServer.driverOptions(browser,driver);
		wait = new WebDriverWait(driver, 10); 
		webServer.connUrl(driver);
		this.loginPage = new LoginPage(driver);
		user_login(wait);
		log.info("=========已录163邮箱啦==========");	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();	
	}
}
