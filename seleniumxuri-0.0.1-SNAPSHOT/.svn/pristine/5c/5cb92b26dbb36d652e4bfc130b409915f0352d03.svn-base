/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.base.AppContext;
import com.sogou.bizqa.seleniumxuri.base.BasePage;

/**
 * @author wangfan
 *
 */
public class LogoutPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");
	
	public static String LOGIN_LOGOUT_BUTTON = "首页.登出按钮";
	public static String LOGIN_VALIDATECODE_IMG = "登录页面.验证码图片";
	
	public LogoutPage(){
		super();
	}
	
	public void clickOnLogoutButton() {
		basePage._Element(LOGIN_LOGOUT_BUTTON).click();
	}
	
	public void waitForLoadPage() {
		basePage.wait.waitElement(LOGIN_LOGOUT_BUTTON);
	}
	
	public boolean isPrestentProfile() {
		return basePage.isExist.elementIsExist(LOGIN_VALIDATECODE_IMG);
	}
}
