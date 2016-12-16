/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.seleniumemulation.IsElementPresent;

import com.sogou.bizqa.seleniumxuri.base.AppContext;
import com.sogou.bizqa.seleniumxuri.base.BasePage;
import com.sogou.bizqa.seleniumxuri.base.Util;

/**
 * @author wangfan
 *
 */
public class LoginPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");

	public static String LOGIN_USERNAME_INPUTBOX = "登录页面.用户名";
	public static String LOGIN_PASSWORD_INPUTBOX = "登录页面.密码";
	public static String LOGIN_VALIDATECODE_INPUTBOX = "登录页面.验证码";
	public static String LOGIN_LOGIN_BUTTON = "登录页面.登录按钮";
	public static String LOGIN_PROFILE = "首页.登出按钮";

	public LoginPage() {
		super();
		basePage.operate.openUrl(basePage.propertiesParse.getValue("loginUrl"));
	}

	public void waitForLoadPage() {
		basePage.wait.waitElement(LOGIN_USERNAME_INPUTBOX);
	}

	public void typeUserNameInputBox(String userName) {
		basePage._Element(LOGIN_USERNAME_INPUTBOX).clear();
		basePage._Element(LOGIN_USERNAME_INPUTBOX).sendKeys(userName);
	}

	public void typePassWordInputBox(String passWord) {
		basePage._Element(LOGIN_PASSWORD_INPUTBOX).clear();
		basePage._Element(LOGIN_PASSWORD_INPUTBOX).sendKeys(passWord);
	}

	public void typeValiDateCodeInputBox(String valiDateCode) {
		basePage._Element(LOGIN_VALIDATECODE_INPUTBOX).clear();
		basePage._Element(LOGIN_VALIDATECODE_INPUTBOX).sendKeys(valiDateCode);
	}

	public void clickOnLoginButton() {
		basePage._Element(LOGIN_LOGIN_BUTTON).click();
		basePage.wait.waitOfThread();
		while(basePage.isAlert()){
			basePage._Alert().accept();
			basePage.wait.waitOfThread();
		}
	}
	
	public boolean isPrestentProfile() {
		try{
			basePage.isExist.elementIsExist(LOGIN_PROFILE);
			return true;
		}catch(NullPointerException e){
			return false;
		}
	}
}
