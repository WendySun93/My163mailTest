package com.mail.My163mailTest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mail.My163mailTest.utils.ReadData;
import com.mail.My163mailTest.utils.WaitEncap;

public class AddressBookPage {
	WebDriver driver;
	
	//导航栏通讯录
	final static String AddressBookXpath = "//div[@class='nui-tabs-item-text nui-fNoSelect' and contains(.,'通讯录')]";
	//新建联系人
	final static String NewContactXpath = "//div[@class='nui-toolbar-item']/div/span[2]";
	//姓名
	final static String nameXpath = "//div[@id='contact_edit_main_normal']/dl/dd/div/input";
	//电子邮箱
	final static String emailXpath = ".//div[@id='iaddress_MAIL_wrap']/dl/dd/div/input";
	//手机号码
	final static String phoneNumXpath = "//div[@id='iaddress_TEL_wrap']/dl/dd/div/input";
	//备注
	final static String noteXpath = "//div[@id='contact_edit_main_normal']/dl[3]/dd/div/textarea";
	//选择分组
	final static String SelectGroupXpath = "//dd[@id='contact_edit_group']/div/div[1]/span";
	//确定
	final static String confirmXpath = "//div[@class='nui-msgbox-ft-btns']/div[1]/span";
	
	@FindBy(xpath = AddressBookXpath)
	private static WebElement AddressBook;

	@FindBy(xpath = NewContactXpath)
	private static WebElement newContact;

	@FindBy(xpath = nameXpath)
	private static WebElement name;

	@FindBy(xpath = emailXpath)
	private static WebElement email;

	@FindBy(xpath = phoneNumXpath)
	private static WebElement phoneNum;

	@FindBy(xpath = noteXpath)
	private static WebElement note;

	@FindBy(xpath = SelectGroupXpath)
	private static WebElement selectGroup;
	
	@FindBy(xpath = confirmXpath)
	private static WebElement confirm;
	
	public AddressBookPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//切换到"通讯录"导航栏
	public void ClickAddressBook(WebDriverWait wait){
		WaitEncap.WaitMethod(wait, AddressBookXpath);
		AddressBook.click();
	}
	
	//新建联系人功能
	public void NewContact(WebDriverWait wait){
		WaitEncap.WaitMethod(wait, NewContactXpath);
		newContact.click();
		WaitEncap.WaitMethod(wait, nameXpath);
		name.sendKeys(ReadData.getAttribute("name"));
		email.sendKeys(ReadData.getAttribute("email"));
		phoneNum.sendKeys(ReadData.getAttribute("phoneNum"));
		note.sendKeys(ReadData.getAttribute("note"));
//		selectGroup.click();
		confirm.click();
		System.out.println("已点击确定");
	}
}
