/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.action;

import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;

import com.sogou.bizqa.seleniumxuri.page.CpcAdInexPage;
import com.sogou.bizqa.seleniumxuri.page.CpcAdOverviewPage;
import com.sogou.bizqa.seleniumxuri.page.KeyPage;
import com.sogou.bizqa.seleniumxuri.page.ideapage.CreateIdeaPage;
import com.sogou.bizqa.seleniumxuri.page.keyPage.CreateKeyPage;

/**
 * @author wangfan
 *
 */
public class CommonKey {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static CpcAdOverviewPage cpcAdOverviewPage;
	public static CpcAdInexPage cpcAdInexPage;
	public static KeyPage keyPage;
	public static CreateKeyPage createKeyPage;

	/**
	 * 获取关键词列表
	 * 
	 * @param rowCount
	 * @return
	 */
	public static ArrayList<Map> keyList(int rowCount) {
		return keyPage.getKeyList(rowCount);
	}

	/**
	 * 精确查询关键词
	 * @param status
	 * @param keyWord
	 * @return
	 */
	public boolean queryKeyByAccurate(String status, String keyWord) {
		cpcAdOverviewPage = new CpcAdOverviewPage();
		cpcAdInexPage = new CpcAdInexPage();
		keyPage = new KeyPage();
		keyPage.selectKeyStatusOption(status);
		keyPage.typeQueryKeyInputBox(keyWord);
		keyPage.selectKeyMatchType();
		keyPage.clickOnQueryButton();
		ArrayList<Map> keyListFirstLine = keyList(1);
		if (keyListFirstLine == null) {
			return false;
		}
		Map<String, String> keyMap = keyListFirstLine.get(0);
		if (keyMap == null) {
			return false;
		}
		assertThat("查询关键词失败！", keyMap, hasEntry("keyWord", keyWord));
		return true;
	}
	
	/**
	 * 新建关键词
	 * @param planName
	 * @param grpName
	 * @param keyWord
	 */
	public void createKey(String planName,String grpName,String keyWord){
		cpcAdOverviewPage = new CpcAdOverviewPage();
		cpcAdInexPage = new CpcAdInexPage();
		keyPage = new KeyPage();
		createKeyPage = new CreateKeyPage(false);
		createKeyPage.selectPlanNameOption(planName);
		createKeyPage.selectGrpNameOption(grpName);
		createKeyPage.typeKeyWordInputBox(keyWord);
		createKeyPage.clickOnSaveKeyWordButton();
		if(queryKeyByAccurate("所有状态", keyWord)){
			Map<String , String> keyMap = keyList(1).get(0);
			assertThat("新建关键词失败！", keyMap, hasEntry("keyWord", keyWord));
			assertThat("新建关键词失败！",keyMap ,hasEntry("cpcPlanName", planName));
			assertThat("新建关键词失败！", keyMap,hasEntry("cpcGrpName", grpName));
		}else{
			assertThat("新建关键词失败！", "A", equalTo("B"));
		}
	}

	public void createKeyByPhoenix(String planName,String grpName,String keyWord){
		cpcAdInexPage = new CpcAdInexPage();
		keyPage = new KeyPage();
		createKeyPage = new CreateKeyPage();
		createKeyPage.typeKeyWordInputBox(keyWord);
		createKeyPage.clickOnAddKeyButton();
		createKeyPage.selectSelPlanOption(planName);
		createKeyPage.selectSelGrpOption(grpName);
		createKeyPage.clickOnSubmitButton();
		//createKeyPage.waitForCreateKey();
	/*	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(queryKeyByAccurate("所有状态", keyWord)){
			Map<String , String> keyMap = keyList(1).get(0);
			assertThat("新建关键词失败！", keyMap, hasEntry("keyWord", keyWord));
			assertThat("新建关键词失败！",keyMap ,hasEntry("cpcPlanName", planName));
			assertThat("新建关键词失败！", keyMap,hasEntry("cpcGrpName", grpName));
		}else{
			assertThat("新建关键词失败！", "A", equalTo("B"));
		}
	}
	
	/**
	 * 删除关键词
	 * @param keyWord
	 */
	public void deleteKey(String keyWord){
		if(queryKeyByAccurate("所有状态", keyWord)){
			keyPage.selectKeyList();
			keyPage.clickOnMoreOpstatButton();
			String tips = keyPage.clickOnDeleteButton();
			assertThat("删除关键词失败！", tips, equalTo("您确定删除选中的关键词吗？"));
		}else{
			assertThat("删除关键词失败！", "A", equalTo("B"));
		}
		if(!queryKeyByAccurate("所有状态", keyWord)){
			assertThat("删除关键词失败！", "", anything());
		}else{
			assertThat("删除关键词失败！", "A",equalTo("B"));
		}
	}
}
