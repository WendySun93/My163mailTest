/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.action;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.page.LoginPage;
import com.sogou.bizqa.seleniumxuri.page.LogoutPage;

/**
 * @author wangfan
 *
 */
public class CommonLogout {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	
	public LogoutPage logoutPage;
	
	public void logout() {
		logoutPage = new LogoutPage();
		logoutPage.waitForLoadPage();
		Assert.assertTrue("logout failed", logoutPage.isPrestentProfile());
	}
}
