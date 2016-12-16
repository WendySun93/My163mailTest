/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page.ideapage;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.base.AppContext;
import com.sogou.bizqa.seleniumxuri.base.BasePage;

/**
 * @author wangfan
 *
 */
public class CreateIdeaPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean("basePage");
	
	public static String CPCIDEA_CREATE_BUTTON = "创意.添加创意";
	public static String CPCIDEA_CREATE_LINK = "创意.创建创意";
	public static String CPCIDEA_PLAN_SELECT = "新建创意.计划名称";
	public static String CPCIDEA_GRP_SELECT = "新建创意.推广组";
	public static String CPCIDEA_IDEATITLE_INPUTBOX = "新建创意.创意标题";
	public static String CPCIDEA_IDEADESC1_INPUTBOX = "新建创意.创意描述第一行";
	public static String CPCIDEA_IDEADESC2_INPUTBOX = "新建创意.创意描述第二行";
	public static String CPCIDEA_IDEAVISITURL_INPUTBOX = "新建创意.默认访问URL";
	public static String CPCIDEA_IDEASHOWURL_INPUTBOX = "新建创意.默认显示URL";
	public static String CPCIDEA_IDEAMOBILEVISITURL_INPUTBOX = "新建创意.移动访问URL";
	public static String CPCIDEA_IDEAMOBILESHOWURL_INPUTBOX = "新建创意.移动显示URL";
	public static String CPCIDEA_SAVECONTINUE_BUTTON = "新建创意.保存并继续";
	public static String CPCIDEA_SAVEIDEA_BUTTON = "新建创意.保存创意";
	
	public CreateIdeaPage(){
		super();
		basePage.wait.waitOfThread();
		basePage._Element(CPCIDEA_CREATE_BUTTON).click();
	}
	
	public CreateIdeaPage(boolean ideaListIsEmpty){
		super();
		basePage.wait.waitOfThread();
		if (ideaListIsEmpty) {
			basePage._Element(CPCIDEA_CREATE_LINK).click();
		} else if(!ideaListIsEmpty){
			basePage._Element(CPCIDEA_CREATE_BUTTON).click();
		}
	}
	
	/**
	 * 选择计划
	 * @param planName
	 */
	public void selectPlanNameOption(String planName){
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCIDEA_PLAN_SELECT, planName);
	}
	
	/**
	 * 选择推广组
	 * @param grpName
	 */
	public void selectGrpNameOption(String grpName){
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCIDEA_GRP_SELECT, grpName);
	}
	
	/**
	 * 输入创意标题
	 * @param ideaTitle
	 */
	public void typeIdeaTitleInputBox(String ideaTitle){
		basePage._Element(CPCIDEA_IDEATITLE_INPUTBOX).clear();
		basePage._Element(CPCIDEA_IDEATITLE_INPUTBOX).sendKeys(ideaTitle);
	}
	
	/**
	 * 输入创意描述第一行
	 * @param ideaDesc1
	 */
	public void typeIdeaDesc1InputBox(String ideaDesc1){
		basePage._Element(CPCIDEA_IDEADESC1_INPUTBOX).clear();
		basePage._Element(CPCIDEA_IDEADESC1_INPUTBOX).sendKeys(ideaDesc1);
	}
	
	/**
	 * 输入创意描述第二行
	 * @param ideaDesc2
	 */
	public void typeIdeaDesc2InputBox(String ideaDesc2){
		basePage._Element(CPCIDEA_IDEADESC2_INPUTBOX).clear();
		basePage._Element(CPCIDEA_IDEADESC2_INPUTBOX).sendKeys(ideaDesc2);
	}
	
	/**
	 * 输入默认访问URL
	 * @param ideaVisitUrl
	 */
	public void typeIdeaVisitUrlInputBox(String ideaVisitUrl){
		basePage._Element(CPCIDEA_IDEAVISITURL_INPUTBOX).clear();
		basePage._Element(CPCIDEA_IDEAVISITURL_INPUTBOX).sendKeys(ideaVisitUrl);
	}
	
	/**
	 * 输入默认显示URL
	 * @param ideaShowUrl
	 */
	public void typeIdeaShowUrlInputBox(String ideaShowUrl){
		basePage._Element(CPCIDEA_IDEASHOWURL_INPUTBOX).clear();
		basePage._Element(CPCIDEA_IDEASHOWURL_INPUTBOX).sendKeys(ideaShowUrl);
	}
	
	/**
	 * 输入移动访问URL
	 * @param ideaMobileVisitUrl
	 */
	public void typeIdeaMobileVisitUrlInputBox(String ideaMobileVisitUrl){
		basePage._Element(CPCIDEA_IDEAMOBILEVISITURL_INPUTBOX).clear();
		basePage._Element(CPCIDEA_IDEAMOBILEVISITURL_INPUTBOX).sendKeys(ideaMobileVisitUrl);
	}
	
	/**
	 * 输入显示URL
	 * @param ideaMobileShowUrl
	 */
	public void typeIdeaMobileShowUrlInputBox(String ideaMobileShowUrl){
		basePage._Element(CPCIDEA_IDEAMOBILESHOWURL_INPUTBOX).clear();
		basePage._Element(CPCIDEA_IDEAMOBILESHOWURL_INPUTBOX).sendKeys(ideaMobileShowUrl);
	}
	
	/**
	 * 保存并继续
	 */
	public void clickOnSaveContinueButton(){
		basePage._Element(CPCIDEA_SAVECONTINUE_BUTTON).click();
	}
	
	/**
	 * 保存创意
	 */
	public void clickOnSaveIdeaButton(){
		basePage._Element(CPCIDEA_SAVEIDEA_BUTTON).click();
		basePage.wait.waitOfThread();
		basePage._Alert().accept();
	}
	
	public void getIdeaViewDomain(){}
}
