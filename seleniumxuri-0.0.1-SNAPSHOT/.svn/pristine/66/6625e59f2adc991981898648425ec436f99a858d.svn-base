/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.base.AppContext;
import com.sogou.bizqa.seleniumxuri.base.BasePage;

/**
 * @author wangfan
 *
 */
public class CpcAdInexPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");
	public static String CPCADINDEX_URL = "推广管理";
	public CpcAdInexPage(){
		super();
		basePage.wait.waitOfThread();
		basePage._ElementByLinkText(CPCADINDEX_URL).click();

		//basePage.operate.openUrl(basePage.propertiesParse.getValue(CPCADINDEX_URL));
		//basePage.wait.waitOfThread();
		//basePage._Alert().accept();

	}
}
