package com.mail.My163mailTest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mail.My163mailTest.utils.ReadData;
import com.mail.My163mailTest.utils.WaitEncap;

public class IndexPage {
	
	WebDriver driver;
	
	final static String xpathwriteMessageBtn="//b[@class='nui-ico fn-bg ga0']";
	final static String xpathrecipient="//input[@class='nui-editableAddr-ipt']";
	final static String xpathsubject="//div[@aria-label='邮件主题输入框，请输入邮件主题']/input";
	final static String xpathframe="//iframe[@class='APP-editor-iframe']";
	final static String xpathcontent="//body[@class='nui-scroll']";
	final static String xpathsendBtn="//header[@class='frame-main-cont-head']/div/div/div/span[2]";
	final static String xpathattachment="//div[@class='ia0']/div/div/input";
	
	//写信按钮
	@FindBy(xpath= xpathwriteMessageBtn)
	private static WebElement writeMessageBtn;
	
	//收件人
	@FindBy(xpath=xpathrecipient)
	private static WebElement recipient;
	//主题
	@FindBy(xpath=xpathsubject)
	private static WebElement subject;
	
	@FindBy(xpath=xpathframe)
	WebElement frame;
	//写信内容
	@FindBy(xpath=xpathcontent)
	private static WebElement content;
	//附件
	@FindBy(xpath=xpathattachment)
	private static WebElement attachment;
	//发送按钮
	@FindBy(xpath=xpathsendBtn)
	private static WebElement sendBtn;
	
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void writeMessage(WebDriver driver, WebDriverWait wait) {
		//元素找到后点击写信按钮
		WaitEncap.WaitMethod(wait, xpathwriteMessageBtn);
		writeMessageBtn.click();
		//元素找到后输入收信人
		WaitEncap.WaitMethod(wait, xpathrecipient);
		recipient.sendKeys(ReadData.getAttribute("recipient"));
		//元素找到后输入主题
		WaitEncap.WaitMethod(wait, xpathsubject);
		subject.sendKeys(ReadData.getAttribute("subject"));
		//进入iframe
		driver.switchTo().frame(frame);
		//元素找到后输入信件内容
		WaitEncap.WaitMethod(wait, xpathcontent);
		content.sendKeys(ReadData.getAttribute("content"));
		//跳出iframe
		driver.switchTo().defaultContent();
		//元素找到后点击发送按钮
		WaitEncap.WaitMethod(wait, xpathsendBtn);
		sendBtn.click();
	}
	
	public void writeMessageWithAttachment(WebDriver driver, WebDriverWait wait) {
		//元素找到后点击写信按钮
		WaitEncap.WaitMethod(wait, xpathwriteMessageBtn);
		writeMessageBtn.click();
		//元素找到后输入收信人
		WaitEncap.WaitMethod(wait, xpathrecipient);
		recipient.sendKeys(ReadData.getAttribute("recipient"));
		//元素找到后输入主题
		WaitEncap.WaitMethod(wait, xpathsubject);
		subject.sendKeys(ReadData.getAttribute("subject"));
		//进入iframe
		driver.switchTo().frame(frame);
		//元素找到后输入信件内容
		WaitEncap.WaitMethod(wait, xpathcontent);
		content.sendKeys(ReadData.getAttribute("content"));
		//跳出iframe
		driver.switchTo().defaultContent();
		//添加附件
//		wait.until(ExpectedConditions.elementToBeClickable(attachment));
		attachment.sendKeys("C:\\Users\\sunwenjuan\\Desktop\\test.txt");
		//元素找到后点击发送按钮
		WaitEncap.WaitMethod(wait, xpathsendBtn);
		sendBtn.click();
	}
	
	
}
