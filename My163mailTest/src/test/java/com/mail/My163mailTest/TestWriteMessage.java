package com.mail.My163mailTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mail.My163mailTest.pageobjects.IndexPage;
import com.mail.My163mailTest.pageobjects.LoginPage;
import com.mail.My163mailTest.utils.ReadData;
import com.mail.My163mailTest.webserver.WebServer;


public class TestWriteMessage extends BaseTest {
	IndexPage indexPage = new IndexPage(driver);
	
	@Test(priority = 1)
	public void writeMessage(){
		log.info("===========case03 写信=========");
		indexPage.writeMessageWithAttachment(wait);
	}
	
}
