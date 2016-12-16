/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.page;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.base.AppContext;
import com.sogou.bizqa.seleniumxuri.base.BasePage;
import com.sogou.bizqa.seleniumxuri.po.GroupList;
import com.sogou.bizqa.seleniumxuri.po.PlanList;

/**
 * @author wangfan
 *
 */
public class GroupPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");
	public GroupList groupList = new GroupList();

	public static String CPCGROUP_TAB = "推广管理.推广组";
	public static String CPCGROUP_GROUPTABLE = "推广组.组列表";
	public static String CPCGROUP_MOREOPSTAT_BUTTON = "推广组.更多操作";
	public static String CPCGROUP_DELETE_BUTTON = "推广组.删除";
	public static String CPCGROUP_QUERYGRP_INPUTBOX = "推广组.搜索框";
	public static String CPCGROUP_GRPSTATUS_SELECT = "推广组.状态框";
	public static String CPCGROUP_GRPMATCH_TYPE = "推广组.精确查询";
	public static String CPCGROUP_QUERY_BUTTON = "推广组.查询";

	public GroupPage() {
		super();
		basePage.wait.waitOfThread();
		basePage._Element(CPCGROUP_TAB).click();
		basePage.wait.waitOfThread();
		while(basePage.isAlert()){
			basePage._Alert().accept();
			basePage.wait.waitOfThread();
		}
		basePage.wait.waitPlanTableNotVisibility();
	}

	/**
	 * 获取推广组列表内容
	 * 
	 * @param rowCount
	 * @return
	 */
	public ArrayList<Map> getGroupList(int rowCount) {
		basePage.wait.waitOfThread();
		ArrayList<Map> aList = new ArrayList<Map>();
		if (basePage.value.getText(CPCGROUP_GROUPTABLE).equals("")) {
			aList = null;
		} else {
			for (int row = 0; row < rowCount; row++) {
				Map<String, String> groupMap = new HashMap<String, String>();
				Field[] fields = groupList.getClass().getDeclaredFields();
				for (int col = 0; col < fields.length; col++) {
					Field f = fields[col];
					f.setAccessible(true);
					String key = f.getName();
					String value = basePage.value.getText(basePage
							.getTableList(CPCGROUP_GROUPTABLE, col + 1, row));
					groupMap.put(key, value);
				}
				aList.add(groupMap);
			}
		}
		return aList;
	}

	/**
	 * 选择推广组第一行
	 */
	public void selectGroupList() {
		basePage._Element(CPCGROUP_GROUPTABLE, 0, 0).click();
	}

	/**
	 * 点击更多操作按钮
	 */
	public void clickOnMoreOpstatButton() {
		basePage._Element(CPCGROUP_MOREOPSTAT_BUTTON).click();
	}

	/**
	 * 选择推广组状态
	 * 
	 * @param status
	 *            状态
	 */
	public void selectGrpStatusOption(String status) {
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCGROUP_GRPSTATUS_SELECT, status);
	}

	/**
	 * 勾选精确查询
	 */
	public void selectGrpMatchType() {
		basePage._Element(CPCGROUP_GRPMATCH_TYPE).click();
	}

	/**
	 * 点击查询按钮
	 */
	public void clickOnQueryButton() {
		basePage._Element(CPCGROUP_QUERY_BUTTON).click();
	}

	/**
	 * 输入推广组名称
	 * 
	 * @param grpName
	 *            推广组名称
	 */
	public void typeQueryGrpInputBox(String grpName) {
		basePage._Element(CPCGROUP_QUERYGRP_INPUTBOX).sendKeys(grpName);
	}

	/**
	 * 点击删除按钮
	 * 
	 * @return 删除时弹出框提示内容
	 */
	public String clickOnDeleteButton() {
		basePage._Element(CPCGROUP_DELETE_BUTTON).click();
		basePage.wait.waitOfThread();
		String text = basePage._Alert().getText();
		basePage._Alert().accept();
		return text;
	}
}
