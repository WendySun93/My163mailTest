/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.action;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.page.CpcAdInexPage;
import com.sogou.bizqa.seleniumxuri.page.CpcAdOverviewPage;
import com.sogou.bizqa.seleniumxuri.page.GroupPage;
import com.sogou.bizqa.seleniumxuri.page.grppage.CreateGrpPage;

/**
 * @author wangfan
 *
 */
public class CommonGrp {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	public static CpcAdOverviewPage cpcAdOverviewPage;
	public static CpcAdInexPage cpcAdInexPage;
	public static GroupPage groupPage;
	public static CreateGrpPage createGrpPage;

	public static ArrayList<Map> grpList(int rowCount) {
		// groupPage = new GroupPage(getDriver());
		return groupPage.getGroupList(rowCount);
	}

	public boolean queryGrpByAccurate(String status, String grpName) {
		groupPage = new GroupPage();
		groupPage.selectGrpStatusOption(status);
		groupPage.typeQueryGrpInputBox(grpName);
		groupPage.selectGrpMatchType();
		groupPage.clickOnQueryButton();
		ArrayList<Map> grpListFirstLine = grpList(1);
		if (grpListFirstLine == null) {
			return false;
		}
		Map<String, String> grpMap = grpListFirstLine.get(0);
		if (grpMap == null) {
			return false;
		}
		assertThat("查询推广组失败！", grpMap, hasEntry("cpcGrpName", grpName));
		return true;
	}

	/**
	 * 新建推广组
	 * 
	 * @param planName
	 * @param grpName
	 * @param grpPrice
	 */
	public void createGrp(String planName, String grpName, String grpPrice) {
		cpcAdOverviewPage = new CpcAdOverviewPage();
		cpcAdInexPage = new CpcAdInexPage();
		groupPage = new GroupPage();
		createGrpPage = new CreateGrpPage(false);
		String newGrpPrice = createGrpPage.inputFormat(grpPrice);
		createGrpPage.selectPlanNameOption(planName);
		createGrpPage.typeGroupNameInputBox(grpName);
		createGrpPage.typeGroupPriceInputBox(newGrpPrice);
		createGrpPage.clickOnSaveGrpButton();
		if (queryGrpByAccurate("所有状态", grpName)) {
			Map<String, String> grpMap = grpList(1).get(0);
			assertThat("新建推广组失败！", grpMap, hasEntry("cpcGrpName", grpName));
			assertThat("新建推广组失败！", grpMap, hasEntry("cpcPlanName", planName));
		} else {
			assertThat("新建推广组失败！", "A", equalTo("B"));
		}
	}

	public void createGrpContinue(String grpName, String grpPrice){
		
	}
	
	public void createGrp2EmptyGrpList(String planName, String grpName, String grpPrice){
		cpcAdOverviewPage = new CpcAdOverviewPage();
		cpcAdInexPage = new CpcAdInexPage();
		groupPage = new GroupPage();
		createGrpPage = new CreateGrpPage(true);
		String newGrpPrice = createGrpPage.inputFormat(grpPrice);
		createGrpPage.selectPlanNameOption(planName);
		createGrpPage.typeGroupNameInputBox(grpName);
		createGrpPage.typeGroupPriceInputBox(newGrpPrice);
		createGrpPage.clickOnSaveGrpButton();
		if (queryGrpByAccurate("所有状态", grpName)) {
			Map<String, String> grpMap = grpList(1).get(0);
			assertThat("新建推广组失败！", grpMap, hasEntry("cpcGrpName", grpName));
			assertThat("新建推广组失败！", grpMap, hasEntry("cpcPlanName", planName));
		} else {
			assertThat("新建推广组失败！", "A", equalTo("B"));
		}
	}
	
	/**
	 * 删除推广组
	 * 
	 * @param grpName
	 */
	public void deleteGrp(String grpName) {
		if (queryGrpByAccurate("所有状态", grpName)) {
			groupPage.selectGroupList();
			groupPage.clickOnMoreOpstatButton();
			String tips = groupPage.clickOnDeleteButton();
			assertThat("删除推广组失败！", tips,
					equalTo("您确定要删除选中的推广组吗？点击确定将同时删除组内的关键词、创意和附加创意。删除操作不可恢复！"));
		} else {
			assertThat("推广组不存在！", "A", equalTo("B"));
		}
		if (!queryGrpByAccurate("所有状态", grpName)) {
			assertThat("删除计划失败！", "", anything());
		} else {
			assertThat("删除计划失败！", "A", equalTo("B"));
		}
	}
}
