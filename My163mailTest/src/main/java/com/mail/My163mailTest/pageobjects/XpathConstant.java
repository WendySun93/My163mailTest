package com.mail.My163mailTest.pageobjects;

public class XpathConstant {
	//写邮件
	final static String xpathwriteMessageBtn="//b[@class='nui-ico fn-bg ga0']";
	final static String xpathrecipient="//input[@class='nui-editableAddr-ipt']";
	final static String xpathsubject="//div[@aria-label='邮件主题输入框，请输入邮件主题']/input";
	final static String xpathframe="//iframe[@class='APP-editor-iframe']";
	final static String xpathcontent="//body[@class='nui-scroll']";
	final static String xpathsendBtn="//header[@class='frame-main-cont-head']/div/div/div/span[2]";
	final static String xpathattachment="//div[@class='ia0']/div/div/input";
	
	//新建联系人【导航栏通讯录、新建联系人、姓名、电子邮箱、手机号码、备注、选择分组、确定】

	final static String AddressBookXpath = "//div[@class='nui-tabs-item-text nui-fNoSelect' and contains(.,'通讯录')]";
	final static String NewContactXpath = "//*[@class='js-component-component nui-mask']";
	final static String nameXpath = "//div[@id='contact_edit_main_normal']/dl/dd/div/input";
	final static String emailXpath = ".//div[@id='iaddress_MAIL_wrap']/dl/dd/div/input";
	final static String phoneNumXpath = "//div[@id='iaddress_TEL_wrap']/dl/dd/div/input";
	final static String noteXpath = "//div[@id='contact_edit_main_normal']/dl[3]/dd/div/textarea";
	final static String SelectGroupXpath = "//dd[@id='contact_edit_group']/div/div[1]/span";
	final static String confirmXpath = "//div[@class='nui-msgbox-ft-btns']/div[1]/span";
}
