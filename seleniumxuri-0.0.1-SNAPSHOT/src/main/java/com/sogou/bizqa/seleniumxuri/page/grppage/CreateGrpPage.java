/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page.grppage;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.base.AppContext;
import com.sogou.bizqa.seleniumxuri.base.BasePage;

/**
 * @author wangfan
 *
 */
public class CreateGrpPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");

	public static String CPCGRP_CREATE_BUTTON = "推广组.新建组";
	public static String CPCGRP_CREATE_LINK = "推广组.创建推广组";
	public static String CPCGRP_PLAN_SELECT = "新建组.计划名称";
	public static String CPCGRP_GRPNAME_INPUTBOX = "新建组.组名称";
	public static String CPCGRP_GRPPRICE_INPUTBOX = "新建组.组出价";
	public static String CPCGRP_SAVECONTINUE_BUTTON = "新建组.保存并继续";
	public static String CPCGRP_SAVEGRP_BUTTON = "新建组.保存推广组";

	public CreateGrpPage() {
		super();
		basePage.wait.waitOfThread();
		basePage._Element(CPCGRP_CREATE_BUTTON).click();
		basePage.wait.waitOfThread();
	}
	
	public CreateGrpPage(boolean grpListIsEmpty){
		super();
		basePage.wait.waitOfThread();
		if(grpListIsEmpty){
			basePage._Element(CPCGRP_CREATE_LINK).click();
		}else if (!grpListIsEmpty) {
			basePage._Element(CPCGRP_CREATE_BUTTON).click();
		}
	}

	public void selectPlanNameOption(String planName) {
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCGRP_PLAN_SELECT, planName);
	}

	public void typeGroupNameInputBox(String grpName) {
		basePage._Element(CPCGRP_GRPNAME_INPUTBOX).clear();
		basePage._Element(CPCGRP_GRPNAME_INPUTBOX).sendKeys(grpName);
	}

	public void typeGroupPriceInputBox(String grpPrice) {
		basePage._Element(CPCGRP_GRPPRICE_INPUTBOX).clear();
		basePage._Element(CPCGRP_GRPPRICE_INPUTBOX).sendKeys(grpPrice);
	}

	public void clickOnSaveContinueButton() {
		basePage._Element(CPCGRP_SAVECONTINUE_BUTTON).click();
	}

	public void clickOnSaveGrpButton() {
		basePage._Element(CPCGRP_SAVEGRP_BUTTON).click();
		basePage.wait.waitOfThread();
		while (basePage.isAlert()) {
			basePage._Alert().accept();
			basePage.wait.waitOfThread();
		}
	}

	public String inputFormat(String input) {
		return basePage.util.string2Float(input);
	}
}
