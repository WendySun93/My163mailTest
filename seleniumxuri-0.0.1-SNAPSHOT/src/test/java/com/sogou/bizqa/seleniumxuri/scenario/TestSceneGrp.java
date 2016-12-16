/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.scenario;


import org.testng.annotations.Test;

import com.sogou.bizqa.seleniumxuri.action.CommonGrp;
import com.sogou.bizqa.seleniumxuri.action.CommonPlan;
import com.sogou.bizqa.seleniumxuri.base.BaseTest;
import com.sogou.test.cases.TestBase;

/**
 * @author wangfan
 *
 */
public class TestSceneGrp extends BaseTest{
	private CommonGrp commonGrp = new CommonGrp();
	private CommonPlan commonPlan = new CommonPlan();
	
	private String planName = "测试计划_"+System.currentTimeMillis();
	private String grpName = "测试组_"+System.currentTimeMillis();
	private String grpPrice = "2";
	private String mobilePrice = "1";
	private String knowledgeCubicPrice = "2";
	
/*	public void clearTest(){
		if(basePage.webDriver!=null)
			basePage.webDriver.quit();
	}*/
	
	
	
	@Test(priority=1)
	public void testCreateGrp(){
		System.out.println("新建推广组测试！");
		basePage.wait.waitOfThread();
		//basePage._Alert().accept();
		commonPlan.createPlan(planName, mobilePrice, knowledgeCubicPrice);
		commonGrp.createGrp(planName, grpName, grpPrice);
		System.out.println("新建推广组测试完毕！");
	}
	
	@Test(priority=2,dependsOnMethods={"testCreateGrp"})
	public void testDeleteGrp(){
		System.out.println("开始删除推广组测试！");
		commonGrp.deleteGrp(grpName);
		System.out.println("删除推广组测试完毕！");
	}
	
	@Test(priority=3,dependsOnMethods={"testDeleteGrp"})
	public void tearDelPlanTest(){
		System.err.println("#########"+planName);
		System.out.println("释放测试！删除计划");
		commonPlan.deletePlan(planName);
		System.out.println("释放计划成功！");
	}
}
