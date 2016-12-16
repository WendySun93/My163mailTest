package com.sogou.bizqa.seleniumxuri.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.sogou.bizqa.seleniumxuri.action.CommonLogin;
import com.sogou.test.element.MyEventListener;

public class BaseTest {

	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");

	private CommonLogin commonLogin = new CommonLogin();

	@BeforeClass
	public void beforeClass() {
		setUpTest();
	}

	@BeforeTest
	public void beforeTest() {
		readyTest();
	}

	@AfterTest
	public void afterTest() {
		clearTest();
	}

	@AfterClass
	public void afterClass() {
		tearDownTest();
	}

	public void setUpTest() {
		// TODO Auto-generated method stub
		System.out.println("准备测试！");
		try {
			if (basePage.webDriver != null)
				basePage.webDriver.quit();
			setPropertisFilepath(basePage.propertieFilepath);
			WebDriverEventListener eventListener = new MyEventListener();
			basePage.webDriver = new EventFiringWebDriver(
					basePage.dr.getDriver(basePage.driverType, basePage.ip))
					.register(eventListener);
			setDriver(basePage.webDriver);
			setExplorerType(basePage.driverType);
			login();
			init();
		} catch (Exception e) {
			basePage.webDriver.quit();
		}
	}

	public void readyTest() {
		// TODO Auto-generated method stub

	}

	public void clearTest() {
		if (basePage.webDriver != null)
			basePage.webDriver.quit();
		System.out.println("====关闭浏览器======");
	}

	public void tearDownTest() {
		// TODO Auto-generated method stub

		System.out.println("释放测试！");
	}

	public void login() {
		// TODO Auto-generated method stub
		System.out.println("login");
		commonLogin.login("1141587371@qq.com", "22222222");
	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String getExplorerType() {
		return basePage.getExplorerType();
	}

	public void setExplorerType(String explorerType) {
		// TODO Auto-generated method stub
		// this.explorerType = explorerType;
		basePage.wait.setExplorerType(explorerType);
		basePage.operate.setExplorerType(explorerType);
		basePage.value.setExplorerType(explorerType);
		basePage.isExist.setExplorerType(explorerType);
		basePage.resultList.setExplorerType(explorerType);
	}

	public void setDriver(WebDriver webDriver) {
		// TODO Auto-generated method stub
		System.out.println("TestBase setDriver");
		basePage.wait.setDriver(webDriver);
		basePage.operate.setDriver(webDriver);
		basePage.value.setDriver(webDriver);
		basePage.isExist.setDriver(webDriver);
		basePage.resultList.setDriver(webDriver);
	}

	protected void setPropertisFilepath(String propertieFilepath) {
		// TODO Auto-generated method stub
		// this.propertieFilepath = propertieFilepath;
		basePage.propertiesParse.setFilePath(propertieFilepath);
		basePage.dr.setPropertisFilePath(propertieFilepath);
		basePage.wait.setPropertisParsePath(propertieFilepath);
		basePage.operate.setPropertisParsePath(propertieFilepath);
		basePage.value.setPropertisParsePath(propertieFilepath);
		basePage.isExist.setPropertisParsePath(propertieFilepath);
		basePage.resultList.setPropertisParsePath(propertieFilepath);
	}
}