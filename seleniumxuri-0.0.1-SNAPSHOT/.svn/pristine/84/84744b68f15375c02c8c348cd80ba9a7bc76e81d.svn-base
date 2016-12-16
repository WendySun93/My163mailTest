/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

/**
 * @author wangfan
 *
 */
public class HomePage {
	private final WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;

		FluentWait wait = new FluentWait(driver).withTimeout(30,
				TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.titleIs("Your Contacts"));
	}

	public String getHomePageWelcomeMessage() {
		 String r = driver.findElement(By.xpath("//*[@class='login_exit']")).getText();
		 System.out.println(r);
		 return r;
	}
}
