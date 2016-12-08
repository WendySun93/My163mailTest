package com.mail.My163mailTest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogoutPage {
	
	 WebDriver driver;
	 WebDriverWait wait;
	//退出邮箱
	@FindBy(xpath="//a[@class='sh0 nui-txt-link']")
	static WebElement logOut;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void logOut(WebDriver driver,WebDriverWait wait) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='sh0 nui-txt-link']")));
		logOut.click();
	}
}
