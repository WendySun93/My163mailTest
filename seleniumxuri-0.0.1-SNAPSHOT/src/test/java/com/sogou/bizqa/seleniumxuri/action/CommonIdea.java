/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.action;

import java.util.ArrayList;
import java.util.Map;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty7.client.webdav.WebdavListener;

import com.sogou.bizqa.seleniumxuri.page.CpcAdInexPage;
import com.sogou.bizqa.seleniumxuri.page.CpcAdOverviewPage;
import com.sogou.bizqa.seleniumxuri.page.IdeaPage;
import com.sogou.bizqa.seleniumxuri.page.ideapage.CreateIdeaPage;
import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;

/**
 * @author wangfan
 *
 */
public class CommonIdea {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static CpcAdOverviewPage cpcAdOverviewPage;
	public static CpcAdInexPage cpcAdInexPage;
	public static IdeaPage ideaPage;
	public static CreateIdeaPage createIdeaPage;

	/**
	 * 获取创意列表
	 * 
	 * @param rowCount
	 * @return
	 */
	public static ArrayList<Map> ideaList(int rowCount) {
		return ideaPage.getIdeaList(rowCount);
	}

	/**
	 * 精确查询创意
	 * 
	 * @param status
	 * @param ideaTitle
	 * @return
	 */
	public boolean queryIdeaByAccurate(String status, String ideaTitle) {
		ideaPage = new IdeaPage();
		ideaPage.selectIdeaStatusOption(status);
		ideaPage.typeQueryIdeaInputBox(ideaTitle);
		ideaPage.clickOnQueryButton();
		ArrayList<Map> ideaListFirstLine = ideaList(1);
		if (ideaListFirstLine == null) {
			return false;
		}
		Map<String, String> ideaMap = ideaListFirstLine.get(0);
		if (ideaMap == null) {
			return false;
		}
		assertThat("查询创意失败！", ideaMap.get("cpcIdeaTitle"), startsWith(ideaTitle));
		return true;
	}

	/**
	 * 新建创意
	 * 
	 * @param planName
	 * @param grpName
	 * @param ideaTitle
	 * @param ideaDesc1
	 * @param ideaDesc2
	 * @param visitUrl
	 * @param showUrl
	 * @param mobileVisitUrl
	 * @param mobileShowUrl
	 */
	public void createIdea(String planName, String grpName, String ideaTitle,
			String ideaDesc1, String ideaDesc2, String ideaVisitUrl,
			String ideaShowUrl, String ideaMobileVisitUrl,
			String ideaMobileShowUrl) {
		cpcAdOverviewPage = new CpcAdOverviewPage();
		cpcAdInexPage = new CpcAdInexPage();
		ideaPage = new IdeaPage();
		createIdeaPage = new CreateIdeaPage(false);
		createIdeaPage.selectPlanNameOption(planName);
		createIdeaPage.selectGrpNameOption(grpName);
		createIdeaPage.typeIdeaTitleInputBox(ideaTitle);
		createIdeaPage.typeIdeaDesc1InputBox(ideaDesc1);
		createIdeaPage.typeIdeaDesc2InputBox(ideaDesc2);
		createIdeaPage.typeIdeaVisitUrlInputBox(ideaVisitUrl);
		createIdeaPage.typeIdeaShowUrlInputBox(ideaShowUrl);
		createIdeaPage.typeIdeaMobileVisitUrlInputBox(ideaMobileVisitUrl);
		createIdeaPage.typeIdeaMobileShowUrlInputBox(ideaMobileShowUrl);
		createIdeaPage.clickOnSaveIdeaButton();
		if (queryIdeaByAccurate("所有状态", ideaTitle)) {
			Map<String, String> ideaMap = ideaList(1).get(0);
			assertThat("新建创意失败！", ideaMap.get("cpcIdeaTitle"), startsWith(ideaTitle));
			assertThat("新建创意失败！", ideaMap, hasEntry("cpcPlanName", planName));
			assertThat("新建创意失败！", ideaMap, hasEntry("cpcGrpName", grpName));
		} else {
			assertThat("新建创意失败！", "A", equalTo("B"));
		}
	}

	public void createIdea2EmptyIdeaList(String planName, String grpName, String ideaTitle,
			String ideaDesc1, String ideaDesc2, String ideaVisitUrl,
			String ideaShowUrl, String ideaMobileVisitUrl,
			String ideaMobileShowUrl) {
		cpcAdOverviewPage = new CpcAdOverviewPage();
		cpcAdInexPage = new CpcAdInexPage();
		ideaPage = new IdeaPage();
		createIdeaPage = new CreateIdeaPage(true);
		createIdeaPage.selectPlanNameOption(planName);
		createIdeaPage.selectGrpNameOption(grpName);
		createIdeaPage.typeIdeaTitleInputBox(ideaTitle);
		createIdeaPage.typeIdeaDesc1InputBox(ideaDesc1);
		createIdeaPage.typeIdeaDesc2InputBox(ideaDesc2);
		createIdeaPage.typeIdeaVisitUrlInputBox(ideaVisitUrl);
		createIdeaPage.typeIdeaShowUrlInputBox(ideaShowUrl);
		createIdeaPage.typeIdeaMobileVisitUrlInputBox(ideaMobileVisitUrl);
		createIdeaPage.typeIdeaMobileShowUrlInputBox(ideaMobileShowUrl);
		createIdeaPage.clickOnSaveIdeaButton();
		if (queryIdeaByAccurate("所有状态", ideaTitle)) {
			Map<String, String> ideaMap = ideaList(1).get(0);
			assertThat("新建创意失败！", ideaMap.get("cpcIdeaTitle"), startsWith(ideaTitle));
			assertThat("新建创意失败！", ideaMap, hasEntry("cpcPlanName", planName));
			assertThat("新建创意失败！", ideaMap, hasEntry("cpcGrpName", grpName));
		} else {
			assertThat("新建创意失败！", "A", equalTo("B"));
		}
	}
	
	
	/**
	 * 删除创意
	 * 
	 * @param ideaTitle
	 */
	public void deleteIdea(String ideaTitle) {
		if (queryIdeaByAccurate("所有状态", ideaTitle)) {
			ideaPage.selectIdeaList();
			ideaPage.clickOnMoreOpstatButton();
			String tips = ideaPage.clickOnDeleteButton();
			assertThat("删除创意失败！", tips, equalTo("您确定要删除选中的创意吗？"));
		} else {
			assertThat("创意不存在！", "A", equalTo("B"));
		}
		if (!queryIdeaByAccurate("所有状态", ideaTitle)) {
			assertThat("删除创意失败！", "", anything());
		} else {
			assertThat("删除创意失败！", "A", equalTo("B"));
		}
	}
}
