package com.mail.My163mailTest;

import org.testng.annotations.Test;

import com.mail.My163mailTest.pageobjects.LoginPage;
import com.mail.My163mailTest.pageobjects.LogoutPage;
import com.mail.My163mailTest.utils.ReadData;
import com.mail.My163mailTest.webserver.WebServer;

import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TestLoginMail extends BaseTest {

	public WebDriver driver;
	WebDriverWait wait;
	WebServer webServer = new WebServer();
	// 在class上引入注解@Slf4j即可直接使用.
	// public Log log= LogFactory.getLog(getClass());
	Logger log = Logger.getLogger(getClass());
	String browser = ReadData.getAttribute("browser");
	
	@BeforeClass
	public void setUp() {
		log.info("===========case1 登录163邮箱===========");
		driver = webServer.driverOptions(browser, driver);
		wait = new WebDriverWait(driver, 10); 
		webServer.connUrl(driver);
		this.loginPage = new LoginPage(driver);
		this.logoutPage = new LogoutPage(driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("===========case1已完成  关闭浏览器===========");
	}

	@Test(priority = 1)
	public void assertLoginButton() {
		if (loginPage.allBtnIsExist(driver) == true) {
			log.info("===========获取页面正确=============");
		} else {
			log.error("===========获取页面错误=============");
		}
	}
	//登录邮箱操作
	@Test(priority = 2, dependsOnMethods = { "assertLoginButton" })
	public void login() {
		this.user_login(wait);
		log.info("=========已登录163邮箱===========");
	}

	//退出登录操作
	@Test(priority = 3, dependsOnMethods = { "login" })
	public void logout() {
		this.user_logout(driver,wait);
		log.info("==========已退出163邮箱===============");
	}

}
