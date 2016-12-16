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
import com.sogou.bizqa.seleniumxuri.page.PlanPage;
import com.sogou.bizqa.seleniumxuri.page.planpage.CreatePlanPage;

/**
 * @author wangfan
 *
 */
public class CommonPlan {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static CpcAdOverviewPage cpcAdOverviewPage;
	public static CpcAdInexPage cpcAdInexPage;
	public static PlanPage planPage;
	public static CreatePlanPage createPlanPage;

	public static ArrayList<Map> planList(int rowCount) {
		// cpcAdInexPage = new CpcAdInexPage(getDriver());
		// planPage = new PlanPage(getDriver());
		return planPage.getPlanList(rowCount);
	}

	public boolean queryPlanByAccurate(String status, String planName) {
		planPage = new PlanPage();
		planPage.selectPlanStatusOption(status);
		planPage.typeQueryPlanInputBox(planName);
		planPage.selectPlanMatchType();
		planPage.clickOnQueryButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Map> planListFirstLine = planList(1);
		if (planListFirstLine == null) {
			return false;
		}
		Map<String, String> planMap = planListFirstLine.get(0);
		if (planMap == null) {
			return false;
		}
		System.err.println("#########查询完毕#########");
		assertThat("query cpcPlan error!", planMap,
				hasEntry("cpcPlanName", planName));
		
		return true;
	}

	public void createPlan(String planName, String mobilePrice,
			String knowledgeCubicPrice) {
		cpcAdOverviewPage = new CpcAdOverviewPage();
		cpcAdInexPage = new CpcAdInexPage();
		planPage = new PlanPage();
		createPlanPage = new CreatePlanPage(false);
		String newMobilePrice = createPlanPage.inputFormat(mobilePrice);
		String newKnowledgeCubicPrice = createPlanPage
				.inputFormat(knowledgeCubicPrice);
		createPlanPage.tyepPlanNameInputBox(planName);
		createPlanPage.typeMobilePriceInputBox(newMobilePrice);
		createPlanPage.typeKnowledgeCubicPriceInputBox(newKnowledgeCubicPrice);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createPlanPage.clickOnSavePlanButton();
		if (queryPlanByAccurate("所有状态", planName)) {
//			System.out.println("planList(1).get(0))"+planList(1).get(0));
			Map<String, String> planMap = planList(1).get(0);
			
			assertThat("create cpcPlan error!", planMap,
					hasEntry("cpcPlanName", planName));
		} else {
			assertThat("create cpcPlan error!", "A", equalTo("B"));
		}

	}

	public void createPlanContinue(String planName, String mobilePrice,
			String knowledgeCubicPrice) {
		cpcAdInexPage = new CpcAdInexPage();
		planPage = new PlanPage();
		createPlanPage = new CreatePlanPage(false);
		String newMobilePrice = createPlanPage.inputFormat(mobilePrice);
		String newKnowledgeCubicPrice = createPlanPage
				.inputFormat(knowledgeCubicPrice);
		createPlanPage.tyepPlanNameInputBox(planName);
		createPlanPage.typeMobilePriceInputBox(newMobilePrice);
		createPlanPage.typeKnowledgeCubicPriceInputBox(newKnowledgeCubicPrice);
		createPlanPage.clickOnSaveContinueButton();
	}

	public void createPlan2EmptyPlanList(String planName, String mobilePrice,
			String knowledgeCubicPrice) {
		cpcAdOverviewPage = new CpcAdOverviewPage();
		cpcAdInexPage = new CpcAdInexPage();
		planPage = new PlanPage();
		createPlanPage = new CreatePlanPage(true);
		String newMobilePrice = createPlanPage.inputFormat(mobilePrice);
		String newKnowledgeCubicPrice = createPlanPage
				.inputFormat(knowledgeCubicPrice);
		createPlanPage.tyepPlanNameInputBox(planName);
		createPlanPage.typeMobilePriceInputBox(newMobilePrice);
		createPlanPage.typeKnowledgeCubicPriceInputBox(newKnowledgeCubicPrice);
		createPlanPage.clickOnSavePlanButton();
		if (queryPlanByAccurate("所有状态", planName)) {
			Map<String, String> planMap = planList(1).get(0);
			assertThat("create cpcPlan error!", planMap,
					hasEntry("cpcPlanName", planName));
		} else {
			assertThat("create cpcPlan error!", "A", equalTo("B"));
		}
	}

	public void deletePlan(String planName) {
		if (queryPlanByAccurate("所有状态", planName)) {
			planPage.selectPlanList();
			planPage.clickOnMoreOpstatButton();
			String tips = planPage.clickOnDeleteButton();
			assertThat(
					"delete cpcPlan error!",
					tips,
					equalTo("您确定要删除选中的推广计划吗？点击确定将同时删除计划下的全部推广组及组内的关键词、创意和附加创意。删除操作不可恢复！"));
		} else {
			assertThat("计划不存在！", "A", equalTo("B"));
		}
		if (!queryPlanByAccurate("所有状态", planName)) {
			assertThat("删除计划失败！", "", anything());
		} else {
			assertThat("删除计划失败！", "A", equalTo("B"));
		}
	}
}
