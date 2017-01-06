package com.mail.My163mailTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.mail.My163mailTest.pageobjects.AddressBookPage;

public class TestAddressBookPage extends BaseTest{
//	AddressBookPage addressBook = new AddressBookPage(driver);
	
	@Test
	public void NewContact(){
		log.info("=========要新建联系人喽========");
		addressBookPage.ClickAddressBook(wait);
		addressBookPage.NewContact(wait);
		log.info("=========已新建联系人=========");
	}
	
	@AfterTest(enabled = true)
	public void tearDown() {
		if (driver != null) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("要关闭啦！！！");
			driver.quit();
			
		}	
	}
}
