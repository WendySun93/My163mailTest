package com.mail.My163mailTest;

import org.testng.annotations.Test;
import com.mail.My163mailTest.pageobjects.AddressBookPage;

public class TestAddressBookPage extends BaseTest{
	AddressBookPage addressBook = new AddressBookPage(driver);
	
	@Test
	public void NewContact(){
		log.info("=========要新建联系人喽========");
		addressBook.NewContact(wait);
		log.info("=========已新建联系人=========");
	}
}
