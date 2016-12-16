/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.action;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.page.HomePage;
import com.sogou.bizqa.seleniumxuri.page.LoginPage;

/**
 * @author wangfan
 *
 */
public class CommonLogin {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public LoginPage loginPage;

	public void login(String userName, String passWord, String valiDateCode) {
		loginPage = new LoginPage();
		loginPage.waitForLoadPage();
		loginPage.typeUserNameInputBox(userName);
		loginPage.typePassWordInputBox(passWord);
		loginPage.typeValiDateCodeInputBox(valiDateCode);
		loginPage.clickOnLoginButton();
		Assert.assertTrue("login failed", loginPage.isPrestentProfile());
	}

	public void login(String userName, String passWord) {
		loginPage = new LoginPage();
		if(!loginPage.isPrestentProfile()){
			loginPage.typeUserNameInputBox(userName);
			loginPage.typePassWordInputBox(passWord);
			loginPage.typeValiDateCodeInputBox("1111");
			loginPage.clickOnLoginButton();
		}
	}
	
	public void login() {
		loginPage = new LoginPage();
		loginPage.waitForLoadPage();
		loginPage.typeUserNameInputBox("1141587371@qq.com");
		loginPage.typePassWordInputBox("22222222");
		loginPage.typeValiDateCodeInputBox("1111");
		loginPage.clickOnLoginButton();
	}
}
