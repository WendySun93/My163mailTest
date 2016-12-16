/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

import com.sogou.bizqa.seleniumxuri.base.AppContext;
import com.sogou.bizqa.seleniumxuri.base.BasePage;
import com.sogou.bizqa.seleniumxuri.po.PlanList;

/**
 * @author wangfan
 *
 */
public class PlanPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");
	public PlanList planList = new PlanList();

	public static String CPCPLAN_TAB = "推广管理.推广计划";
	public static String CPCPLAN_PLANTABLE = "推广计划.计划列表";
	public static String CPCPLAN_MOREOPSTAT_BUTTON = "推广计划.更多操作";
	public static String CPCPLAN_DELETE_BUTTON = "推广计划.删除";
	public static String CPCPLAN_QUERYPLAN_INPUTBOX = "推广计划.搜索框";
	public static String CPCPLAN_PLANSTATUS_SELECT = "推广计划.状态框";
	public static String CPCPLAN_PLANMATCH_TYPE = "推广计划.精确查询";
	public static String CPCPLAN_QUERY_BUTTON = "推广计划.查询";

	public PlanPage() {
		super();
		basePage.wait.waitOfThread();
		basePage._Element(CPCPLAN_TAB).click();
		basePage.wait.waitPlanTableNotVisibility();
	}

	public ArrayList<Map> getPlanList(int rowCount) {
		basePage.wait.waitOfThread();
		ArrayList<Map> aList = new ArrayList<Map>();
		if (basePage.value.getText(CPCPLAN_PLANTABLE).equals("")) {
			aList = null;
		} else {
			for (int row = 0; row < rowCount; row++) {
				Map<String, String> planMap = new HashMap<String, String>();
				Field[] fields = planList.getClass().getDeclaredFields();
				
				System.err.println("fields.length::"+fields.length);
				for (int col = 0; col < fields.length; col++) {
					Field f = fields[col];
					f.setAccessible(true);
					String key = f.getName();
//					System.out.println("key:"+key);
					String value = basePage.value.getText(basePage
							.getTableList(CPCPLAN_PLANTABLE, col + 1, row));
					System.out.println("key="+key+":value="+value);
					planMap.put(key, value);
				}
				aList.add(planMap);
			}
		}
		return aList;
	}

	public void selectPlanList() {
		basePage._Element(CPCPLAN_PLANTABLE, 0, 0).click();
	}

	public void clickOnMoreOpstatButton() {
		basePage._Element(CPCPLAN_MOREOPSTAT_BUTTON).click();
	}

	public void selectPlanStatusOption(String status) {
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCPLAN_PLANSTATUS_SELECT, status);
	}

	public void selectPlanMatchType() {
		basePage._Element(CPCPLAN_PLANMATCH_TYPE).click();
	}

	public void clickOnQueryButton() {
		basePage._Element(CPCPLAN_QUERY_BUTTON).click();
	}

	public void typeQueryPlanInputBox(String planName) {
		basePage._Element(CPCPLAN_QUERYPLAN_INPUTBOX).sendKeys(planName);
	}

	public String clickOnDeleteButton() {
		basePage._Element(CPCPLAN_DELETE_BUTTON).click();
		basePage.wait.waitOfThread();
		String text = basePage._Alert().getText();
		basePage._Alert().accept();
		return text;
	}

}
