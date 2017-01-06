package com.mail.My163mailTest;

import org.testng.annotations.Test;

public class TestWriteMessage extends BaseTest {
	//初始化顺序 先于BaseTest中driver的初始化，导致driver为空，IndexPage中定义的driver为空，所以@FindBy定位的数据为空
//	IndexPage indexPage = new IndexPage(driver);
	
	@Test(priority = 1)
	public  void writeMessage(){
		log.info("===========case03 写信=========");
		indexPage.writeMessageWithAttachment(wait);	
	}
	
}
