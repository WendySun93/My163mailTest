/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.scenario;

import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;





import com.sogou.bizqa.seleniumxuri.action.CommonPlan;
import com.sogou.bizqa.seleniumxuri.base.BaseTest;


/**
 * @author wangfan
 *
 */
public class TestScenePlan extends BaseTest {	
	private CommonPlan commonPlan = new CommonPlan();
	private String planName = "测试计划_"+System.currentTimeMillis();
	private String mobilePrice = "1";
	private String knowledgeCubicPrice = "2";
	

//	public void clearTest(){
// 		if (basePage.webDriver != null)
//			basePage.webDriver.quit();
// 		System.out.println("#####关闭######");
//	}
	
	@Test
	public void testCreatePlan(){
		
		basePage.wait.waitOfThread();
		commonPlan.createPlan(planName, mobilePrice, knowledgeCubicPrice);
		System.out.println("新建计划测试完毕！");
	}
	
	@Test
	public void testDeletePlan(){
		commonPlan.deletePlan(planName);
		System.out.println("删除计划测试完毕！");
	}
}
