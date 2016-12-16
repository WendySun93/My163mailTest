/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.scenario;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Test;

import com.sogou.bizqa.seleniumxuri.action.CommonLogin;
import com.sogou.bizqa.seleniumxuri.base.BaseTest;
import com.sogou.bizqa.seleniumxuri.page.HomePage;
import com.sogou.test.element.MyEventListener;

/**
 * @author wangfan
 *
 */
public class TestSceneLogin extends BaseTest {
	private CommonLogin commonLogin = new CommonLogin();
	
	public void setUpTest() {
		System.out.println("准备测试！");
		try {
			if (basePage.webDriver != null)
				basePage.webDriver.quit();
			setPropertisFilepath(basePage.propertieFilepath);
			
		} catch (Exception e) {
			basePage.webDriver.quit();
		}
	}

	public void clearTest(){
 		if (basePage.webDriver != null)
			basePage.webDriver.quit();
	}
	
	@Test
	public void testLogin1() {
		System.out.println("TestCase1");
		WebDriverEventListener eventListener = new MyEventListener();
		basePage.webDriver = new EventFiringWebDriver(
				basePage.dr.getDriver(basePage.driverType, basePage.ip))
				.register(eventListener);
		setDriver(basePage.webDriver);
		setExplorerType(basePage.driverType);
		init();
		commonLogin.login("admin@xianhua.cn", "22222222","1111");	
	}
	
	@Test
	public void testLogin2(){
		System.out.println("TestCase2");
		WebDriverEventListener eventListener = new MyEventListener();
		basePage.webDriver = new EventFiringWebDriver(
				basePage.dr.getDriver(basePage.driverType, basePage.ip))
				.register(eventListener);
		setDriver(basePage.webDriver);
		setExplorerType(basePage.driverType);
		init();
		commonLogin.login("shgelin@sogou.com", "22222222","1111");	
	}
}