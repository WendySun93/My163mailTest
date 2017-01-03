package com.mail.My163mailTest.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitEncap {
	
public static  void WaitMethod(WebDriverWait wait,String expression){
		
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(expression)));
	}

}
