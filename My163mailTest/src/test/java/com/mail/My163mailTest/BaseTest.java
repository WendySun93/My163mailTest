package com.mail.My163mailTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mail.My163mailTest.pageobjects.LoginPage;
import com.mail.My163mailTest.pageobjects.LogoutPage;
import com.mail.My163mailTest.utils.ReadData;

public class BaseTest {
	LoginPage loginPage;
	LogoutPage logoutPage;
	//登录
	protected void user_login(WebDriverWait wait){
		String user = ReadData.getAttribute("loginuser");
		String passwd = ReadData.getAttribute("loginpasswd");
		loginPage.login(user,passwd,wait);
	}
	
	protected void user_logout(WebDriver driver,WebDriverWait wait){
		logoutPage.logOut(driver,wait);
	}
}
