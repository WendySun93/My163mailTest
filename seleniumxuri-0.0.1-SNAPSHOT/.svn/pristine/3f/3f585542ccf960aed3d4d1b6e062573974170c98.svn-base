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
import com.sogou.bizqa.seleniumxuri.po.KeyList;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @author wangfan
 *
 */
public class KeyPage {
	public BasePage basePage = (BasePage) AppContext.getAppCtx().getBean(
			"basePage");
	
	public KeyList keyList = new KeyList();
	
	public static String CPCKEY_TAB ="推广管理.关键词";
	public static String CPCKEY_KEYTABLE= "关键词.关键词列表";
	public static String CPCKEY_MOREOPSTAT_BUTTON = "关键词.更多操作";
	public static String CPCKEY_DELETE_BUTTON = "关键词.删除";
	public static String CPCKEY_QUERYKEY_INPUTBOX = "关键词.搜索框";
	public static String CPCKEY_KEYSTATUS_SELECT ="关键词.状态框";
	public static String CPCKEY_KEYMATCH_TYPE = "关键词.精确查询";
	public static String CPCKEY_QUERY_BUTTON = "关键词.查询";
	
	public KeyPage(){
		super();
		basePage.wait.waitOfThread();
		basePage._Element(CPCKEY_TAB).click();
		while(basePage.isAlert()){
			basePage._Alert().accept();
			basePage.wait.waitOfThread();
		}
		basePage.wait.waitKeyTableNotVisibility();
	}
	
	/**
	 * 获取关键词列表内容
	 * @param rowCount
	 * @return
	 */
	public ArrayList<Map> getKeyList(int rowCount){
		basePage.wait.waitOfThread();
		ArrayList<Map> aList = new ArrayList<Map>();
		if(basePage.value.getText(CPCKEY_KEYTABLE).equals("")){
			aList = null;
		}else{
			for(int row =0;row<rowCount;row++){
				Map<String, String> keyMap = new HashMap<String, String>();
				Field[]fields = keyList.getClass().getDeclaredFields();
				for(int col=0;col<fields.length;col++){
					Field f = fields[col];
					f.setAccessible(true);
					String key = f.getName();
					String value = basePage.value.getText(basePage.getTableList(CPCKEY_KEYTABLE, col+1, row));
					keyMap.put(key, value);
				}
				aList.add(keyMap);
			}
		}
		return aList;
	}
	
	/**
	 * 选择关键词第一行
	 */
	public void selectKeyList(){
		basePage._Element(CPCKEY_KEYTABLE,0,0).click();
	}
	
	/**
	 * 点击更多操作按钮
	 */
	public void clickOnMoreOpstatButton(){
		basePage._Element(CPCKEY_MOREOPSTAT_BUTTON).click();
	}
	
	/**
	 * 选择关键词状态
	 * @param status
	 */
	public void selectKeyStatusOption(String status){
		basePage.wait.waitOfThread();
		basePage.selectByText(CPCKEY_KEYSTATUS_SELECT, status);
	}
	
	/**
	 * 勾选精确查询
	 */
	public void selectKeyMatchType(){
		basePage._Element(CPCKEY_KEYMATCH_TYPE).click();
	}
	
	/**
	 * 点击查询按钮
	 */
	public void clickOnQueryButton(){
		basePage._Element(CPCKEY_QUERY_BUTTON).click();
	}
	
	/**
	 * 输入关键词
	 * @param keyWord
	 */
	public void typeQueryKeyInputBox(String keyWord){
		basePage._Element(CPCKEY_QUERYKEY_INPUTBOX).sendKeys(keyWord);
	}
	
	/**
	 * 点击删除按钮
	 * @return
	 */
	public String clickOnDeleteButton(){
		basePage._Element(CPCKEY_DELETE_BUTTON).click();
		basePage.wait.waitOfThread();
		String text = basePage._Alert().getText();
		basePage._Alert().accept();
		return text;
	}
}
