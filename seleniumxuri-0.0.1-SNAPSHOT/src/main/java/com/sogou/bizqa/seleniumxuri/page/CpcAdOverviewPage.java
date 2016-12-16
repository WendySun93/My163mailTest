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
public class CpcAdOverviewPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");
	public static String CPCADOVERVIEW_URL = "搜索推广";

	public CpcAdOverviewPage() {
		super();
		basePage.wait.waitOfThread();
		basePage._ElementByLinkText(CPCADOVERVIEW_URL).click();

		// basePage.operate.openUrl(basePage.propertiesParse.getValue(CPCADINDEX_URL));
		// basePage.wait.waitOfThread();
		// basePage._Alert().accept();

	}
}
