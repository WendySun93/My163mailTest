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
import com.sogou.bizqa.seleniumxuri.po.IdeaList;

/**
 * @author wangfan
 *
 */
public class IdeaPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");
	public IdeaList ideaList = new IdeaList();

	public static String CPCIDEA_TAB = "推广管理.创意";
	public static String CPCIDEA_IDEATABLE = "创意.创意列表";
	public static String CPCIDEA_MOREOPSTAT_BUTTON = "创意.更多操作";
	public static String CPCIDEA_DELETE_BUTTON = "创意.删除创意";
	public static String CPCIDEA_QUERYIDEA_INPUTBOX = "创意.搜索框";
	public static String CPCIDEA_IDEASTATUS_SELECT = "创意.状态框";
	public static String CPCIDEA_QUERY_BUTTON = "创意.查询";

	public IdeaPage() {
		super();
		basePage.wait.waitOfThread();
		basePage._Element(CPCIDEA_TAB).click();
		while(basePage.isAlert()){
			basePage._Alert().accept();
			basePage.wait.waitOfThread();
		}
		basePage.wait.waitIdeaTableNotVisibility();
	}

	/**
	 * 获取创意列表内容
	 * 
	 * @param rowCount
	 * @return
	 */
	public ArrayList<Map> getIdeaList(int rowCount) {
		basePage.wait.waitOfThread();
		ArrayList<Map> aList = new ArrayList<Map>();
		if (basePage.value.getText(CPCIDEA_IDEATABLE).equals("")) {
			aList = null;
		} else {
			for (int row = 0; row < rowCount; row++) {
				Map<String, String> ideaMap = new HashMap<String, String>();
				Field[] fields = ideaList.getClass().getDeclaredFields();
				for (int col = 0; col < fields.length; col++) {
					Field f = fields[col];
					f.setAccessible(true);
					String key = f.getName();
					String value = basePage.value.getText(basePage
							.getTableList(CPCIDEA_IDEATABLE, col + 1, row));
					ideaMap.put(key, value);
				}
				aList.add(ideaMap);
			}
		}
		return aList;
	}

	/**
	 * 选择创意第一行
	 */
	public void selectIdeaList() {
		basePage._Element(CPCIDEA_IDEATABLE, 0, 0).click();
	}

	/**
	 * 点击更多操作按钮
	 */
	public void clickOnMoreOpstatButton() {
		basePage._Element(CPCIDEA_MOREOPSTAT_BUTTON).click();
	}

	/**
	 * 选择创意状态
	 * @param status
	 */
	public void selectIdeaStatusOption(String status) {
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCIDEA_IDEASTATUS_SELECT, status);
	}
		
	/**
	 * 点击查询按钮
	 */
	public void clickOnQueryButton(){
		basePage._Element(CPCIDEA_QUERY_BUTTON).click();
	}
	
	/**
	 * 输入创意标题
	 * @param ideaTitle
	 */
	public void typeQueryIdeaInputBox(String ideaTitle){
		basePage._Element(CPCIDEA_QUERYIDEA_INPUTBOX).sendKeys(ideaTitle);
	}
	
	/**
	 * 点击删除按钮
	 * @return 删除时弹出框提示内容
	 */
	public String clickOnDeleteButton(){
		basePage._Element(CPCIDEA_DELETE_BUTTON).click();
		basePage.wait.waitOfThread();
		String text = basePage._Alert().getText();
		basePage._Alert().accept();
		return text;
	}
}
