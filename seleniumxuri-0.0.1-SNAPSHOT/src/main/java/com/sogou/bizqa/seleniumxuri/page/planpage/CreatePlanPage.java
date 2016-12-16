/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page.planpage;

import static org.hamcrest.Matchers.hasEntry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.base.AppContext;
import com.sogou.bizqa.seleniumxuri.base.BasePage;

/**
 * @author wangfan
 *
 */
public class CreatePlanPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");
	public static String CPCPLAN_CREATE_BUTTON = "推广计划.新建计划";
	public static String CPCPLAN_CREATE_LINK = "推广计划.创建推广计划";
	public static String CPCPLAN_PLANNAME_INPUTBOX = "新建计划.计划名称";
	public static String CPCPLAN_MOBILEPRICE_INPUTBOX = "新建计划.移动出价比例";
	public static String CPCPLAN_KNOWLEDGECUBICPRICE_INPUTBOX = "新建计划.知立方出价比例";
	public static String CPCPLAN_SAVECONTINUE_BUTTON = "新建计划.保存并继续";
	public static String CPCPLAN_SAVEPLAN_BUTTON = "新建计划.保存推广计划";
	
	/**
	 * 通过传参方式选择使用新建按钮或新建链接两种方式新建，方法二只有计划列表为空时可用
	 * @param planListIsEmpty
	 */
	public CreatePlanPage(Boolean planListIsEmpty) {
		super();
		basePage.wait.waitOfThread();
		if(planListIsEmpty){
			basePage._Element(CPCPLAN_CREATE_LINK).click();
		}else if (!planListIsEmpty) {
			basePage._Element(CPCPLAN_CREATE_BUTTON).click();
		}	
	}
	
	/**
	 * 默认通过新建按钮新建
	 */
	public CreatePlanPage(){
		super();
		basePage.wait.waitOfThread();
		basePage._Element(CPCPLAN_CREATE_BUTTON).click();
	}

	public void tyepPlanNameInputBox(String planName) {
		basePage._Element(CPCPLAN_PLANNAME_INPUTBOX).clear();
		basePage._Element(CPCPLAN_PLANNAME_INPUTBOX).sendKeys(planName);
	}

	public void typeMobilePriceInputBox(String mobilePrice) {
		basePage._Element(CPCPLAN_MOBILEPRICE_INPUTBOX).clear();
		basePage._Element(CPCPLAN_MOBILEPRICE_INPUTBOX).sendKeys(mobilePrice);
	}

	public void typeKnowledgeCubicPriceInputBox(String knowledgeCubicPrice) {
		basePage._Element(CPCPLAN_KNOWLEDGECUBICPRICE_INPUTBOX).clear();
		basePage._Element(CPCPLAN_KNOWLEDGECUBICPRICE_INPUTBOX).sendKeys(
				knowledgeCubicPrice);
	}

	public void clickOnSaveContinueButton() {
		basePage._Element(CPCPLAN_SAVEPLAN_BUTTON).click();
	}

	public void clickOnSavePlanButton() {
		basePage._Element(CPCPLAN_SAVEPLAN_BUTTON).click();
		basePage.wait.waitOfThread();
		basePage._Alert().accept();
	}

	public String inputFormat(String input) {
		return basePage.util.string2Float(input);
	}
}
