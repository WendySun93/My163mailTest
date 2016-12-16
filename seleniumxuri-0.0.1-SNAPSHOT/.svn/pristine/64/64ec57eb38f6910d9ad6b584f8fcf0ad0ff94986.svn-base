/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page.keyPage;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.base.AppContext;
import com.sogou.bizqa.seleniumxuri.base.BasePage;

/**
 * @author wangfan
 *
 */
public class CreateKeyPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean("basePage");
	
	public static String CPCKEY_CREATE_BUTTON = "关键词.添加关键词";
	public static String CPCKEY_CREATE_LINK = "关键词.立即添加关键词";
	public static String CPCKEY_PLAN_SELECT = "新建关键词.计划名称";
	public static String CPCKEY_GRPNAME_SELECT = "新建关键词.组名称";
	public static String CPCKEY_KEYWORD_INPUTBOX = "新建关键词.关键词输入框";
	public static String CPCKEY_SAVEKEY_BUTTON = "新建关键词.保存关键词";
	
	public static String CPCKEY_ADDKEY_BUTTON = "新建关键词.添加关键词";
	public static String CPCKEY_SELPLAN_SELECT = "新建关键词.选择计划";
	public static String CPCKEY_SELGRP_SELECT =	"新建关键词.选择推广组";
	public static String CPCKEY_SUBMIT_BUTTON = "新建关键词.提交";
	public static String CPCKEY_SUBMITKEYS_BUTTON = "关键词预览.立即提交";

	public CreateKeyPage(boolean keyListIsEmpty){
		super();
		basePage.wait.waitOfThread();
		if (keyListIsEmpty) {
			basePage._Element(CPCKEY_CREATE_BUTTON).click();
		} else if(!keyListIsEmpty){
			basePage._Element(CPCKEY_CREATE_LINK).click();
		}
	}
	
	public CreateKeyPage(){
		super();
		basePage.wait.waitOfThread();
		basePage._Element(CPCKEY_CREATE_BUTTON).click();
	}
	
	/**
	 * 选择推广计划
	 * @param planName
	 */
	public void selectPlanNameOption(String planName){
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCKEY_PLAN_SELECT, planName);
	}
	
	/**
	 * 选择推广组
	 * @param grpName
	 */
	public void selectGrpNameOption(String grpName){
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCKEY_GRPNAME_SELECT, grpName);
	}
	
	/**
	 * 输入关键词
	 * @param keyWord
	 */
	public void typeKeyWordInputBox(String keyWord){
		basePage._Element(CPCKEY_KEYWORD_INPUTBOX).clear();
		basePage._Element(CPCKEY_KEYWORD_INPUTBOX).sendKeys(keyWord);
	}
	
	/**
	 * 保存关键词
	 */
	public void clickOnSaveKeyWordButton(){
		basePage._Element(CPCKEY_SAVEKEY_BUTTON).click();
		basePage.wait.waitOfThread();
		basePage._Alert().accept();
	}
	
	/**
	 * 选计划
	 * @param planName
	 */
	public void selectSelPlanOption(String planName){
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCKEY_SELPLAN_SELECT, planName);
	}
	
	/**
	 * 选推广组
	 * @param grpName
	 */
	public void selectSelGrpOption(String grpName){
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCKEY_SELGRP_SELECT, grpName);
	}
	
	/**
	 * 点击添加关键词按钮
	 */
	public void clickOnAddKeyButton(){
		basePage.wait.waitOfThread();
		basePage._Element(CPCKEY_ADDKEY_BUTTON).click();
	}
	
	/**
	 * 点击提交按钮
	 */
	public void clickOnSubmitButton(){
		basePage.wait.waitOfThread();
		basePage._Element(CPCKEY_SUBMIT_BUTTON).click();
		basePage.wait.waitOfThread();
		basePage._Element(CPCKEY_SUBMITKEYS_BUTTON).click();
		basePage.wait.waitOfThread();
		basePage._Alert().accept();
	}
	
	public void waitForCreateKey(){
		try {
			basePage.wait.wait(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
