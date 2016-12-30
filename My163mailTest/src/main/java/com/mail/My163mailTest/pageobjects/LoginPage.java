package com.mail.My163mailTest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@name='email']")
	private static WebElement loginUser;
	@FindBy(xpath="//input[@name='password']")
	private static WebElement loginPasswd;
	@FindBy(xpath="//a[@id='dologin']")
	private static WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public  boolean allBtnIsExist(WebDriver driver) {
		driver.switchTo().frame("x-URS-iframe");
		Assert.assertTrue(loginUser.isDisplayed());
		Assert.assertTrue(loginPasswd.isDisplayed());
		Assert.assertTrue(loginButton.isDisplayed());
		return true;
	}
	
	//登录
	public void login(String username,String passwd,WebDriverWait wait){
		driver.switchTo().frame("x-URS-iframe");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='email']")));
		loginUser.sendKeys(username);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
		loginPasswd.sendKeys(passwd);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='dologin']")));
		loginButton.click();
		driver.switchTo().defaultContent();
	}

}
