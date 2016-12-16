/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.scenario;

import org.testng.annotations.Test;

import com.sogou.bizqa.seleniumxuri.action.CommonGrp;
import com.sogou.bizqa.seleniumxuri.action.CommonIdea;
import com.sogou.bizqa.seleniumxuri.action.CommonPlan;
import com.sogou.bizqa.seleniumxuri.base.BaseTest;

/**
 * @author wangfan
 *
 */
public class TestSceneIdea extends BaseTest{
	private CommonIdea commonIdea = new CommonIdea();
	private CommonGrp commonGrp = new CommonGrp();
	private CommonPlan commonPlan = new CommonPlan();
	
	private String planName = "测试计划_"+System.currentTimeMillis();
	private String grpName = "测试组_"+System.currentTimeMillis();
	private String grpPrice = "2";
	private String mobilePrice = "1";
	private String knowledgeCubicPrice = "2";
	private String ideaTitle = "测试创意_标题_"+System.currentTimeMillis();
	private String ideaDesc1 = "测试创意_描述1_"+System.currentTimeMillis();
	private String ideaDesc2 = "测试创意_描述2_"+System.currentTimeMillis();
	private String ideaVisitUrl = "www.bjlinhua.com";
	private String ideaShowUrl = "www.bjlinhua.com";
	private String ideaMobileVisitUrl = "www.bjlinhua.com";
	private String ideaMobileShowUrl = "www.bjlinhua.com";
	
	public void init(){
		commonPlan.createPlan(planName, mobilePrice, knowledgeCubicPrice);
		commonGrp.createGrp(planName, grpName, grpPrice);
	}
	
	public void clearTest(){
		if(basePage.webDriver!=null){
			basePage.webDriver.quit();
		}
	}
	
	public void tearDownTest(){
		System.out.println("释放测试！");
		commonGrp.deleteGrp(grpName);
		commonPlan.deletePlan(planName);
	}
	
	@Test
	public void testCreateIdea(){
		System.out.println("新建创意测试！");
		basePage.wait.waitOfThread();
		commonIdea.createIdea(planName, grpName, ideaTitle, ideaDesc1, ideaDesc2, ideaVisitUrl, ideaShowUrl, ideaMobileVisitUrl, ideaMobileShowUrl);
	}
	
	@Test
	public void testDeleteIdea(){
		System.out.println("删除创意测试！");
		commonIdea.deleteIdea(ideaTitle);
	}
	
}
