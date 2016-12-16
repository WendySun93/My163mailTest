/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.scenario;

import org.testng.annotations.Test;

import com.sogou.bizqa.seleniumxuri.action.CommonGrp;
import com.sogou.bizqa.seleniumxuri.action.CommonIdea;
import com.sogou.bizqa.seleniumxuri.action.CommonKey;
import com.sogou.bizqa.seleniumxuri.action.CommonPlan;
import com.sogou.bizqa.seleniumxuri.base.BaseTest;

/**
 * @author wangfan
 *
 */
public class TestSceneCpc extends BaseTest {

	private CommonPlan commonPlan = new CommonPlan();
	private CommonGrp commonGrp = new CommonGrp();
	private CommonIdea commonIdea = new CommonIdea();
	private CommonKey commonKey = new CommonKey();

	private String planName1 = "测试计划_" + System.currentTimeMillis();
	private String planName2 = "测试计划_"+System.currentTimeMillis();
	private String grpName = "测试组_" + System.currentTimeMillis();
	private String ideaTitle = "测试创意_标题_" + System.currentTimeMillis();
	private String ideaDesc1 = "测试创意_描述1_" + System.currentTimeMillis();
	private String ideaDesc2 = "测试创意_描述2_" + System.currentTimeMillis();
	private String keyWord1 = "测试关键词-"+System.currentTimeMillis();
	private String keyWord2 = "测试关键词-"+System.currentTimeMillis();
	private String mobilePrice = "1";
	private String knowledgeCubicPrice = "2";
	private String grpPrice = "2";
	private String ideaVisitUrl = "www.bjlinhua.com";
	private String ideaShowUrl = "www.bjlinhua.com";
	private String ideaMobileVisitUrl = "www.bjlinhua.com";
	private String ideaMobileShowUrl = "www.bjlinhua.com";

	public void clearTest() {
		if (basePage.webDriver != null) {
			basePage.webDriver.quit();
		}
	}
	
	@Test
	public void test1CreatePlan() {
		System.out.println("新建推广计划测试！");
		basePage.wait.waitOfThread();
		commonPlan.createPlan(planName1, mobilePrice, knowledgeCubicPrice);
	}

	@Test
	public void test2CreateGrp() {
		System.out.println("新建推广组测试！");
		basePage.wait.waitOfThread();
		commonGrp.createGrp(planName1, grpName, grpPrice);
	}

	@Test
	public void test3CreateIdea() {
		System.out.println("新建创意测试！");
		basePage.wait.waitOfThread();
		commonIdea.createIdea(planName1, grpName, ideaTitle, ideaDesc1,
				ideaDesc2, ideaVisitUrl, ideaShowUrl, ideaMobileVisitUrl,
				ideaMobileShowUrl);
	}
	
/*	@Test
	public void test4CreateKey(){
		System.out.println("新建关键词测试！");
		basePage.wait.waitOfThread();
		commonKey.createKey(planName1, grpName, keyWord1);
	}
	*/
	@Test
	public void test5CreateKeyByPhoenix(){
		System.out.println("通过phoenix新建关键词测试！");
		basePage.wait.waitOfThread();
		commonKey.createKeyByPhoenix(planName1, grpName, keyWord2);
	}
	
	@Test
	public void test6DeleteKey(){
		System.out.println("删除关键词测试！");
		basePage.wait.waitOfThread();
		commonKey.deleteKey(keyWord2);
	}
	
	@Test
	public void test7DeleteIdea(){
		System.out.println("删除创意测试！");
		basePage.wait.waitOfThread();
		commonIdea.deleteIdea(ideaTitle);
	}
	
	@Test
	public void test8DeleteGrp(){
		System.out.println("删除推广组测试！");
		basePage.wait.waitOfThread();
		commonGrp.deleteGrp(grpName);
	}
	
	@Test
	public void test9DeletePlan(){
		System.out.println("删除推广计划测试！");
		basePage.wait.waitOfThread();
		commonPlan.deletePlan(planName1);
	}
}
