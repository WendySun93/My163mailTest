/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.scenario;

import org.testng.annotations.Test;

import com.sogou.bizqa.seleniumxuri.action.CommonGrp;
import com.sogou.bizqa.seleniumxuri.action.CommonKey;
import com.sogou.bizqa.seleniumxuri.action.CommonPlan;
import com.sogou.bizqa.seleniumxuri.base.BaseTest;

/**
 * @author wangfan
 *
 */
public class TestSceneKey extends BaseTest{
	private CommonKey commonKey = new CommonKey();
	private CommonGrp commonGrp = new CommonGrp();
	private CommonPlan commonPlan = new CommonPlan();
	
	private String planName = "测试计划_"+System.currentTimeMillis();
	private String grpName = "测试组_"+System.currentTimeMillis();
	private String grpPrice = "2";
	private String mobilePrice = "1";
	private String knowledgeCubicPrice = "2";
	private String keyWord = "测试关键词-"+System.currentTimeMillis();
	
	public void init(){
		commonPlan.createPlan(planName, mobilePrice, knowledgeCubicPrice);
		commonGrp.createGrp(planName, grpName, grpPrice);
	}
	
/*	public void clearTest(){
		if(basePage.webDriver!=null){
			basePage.webDriver.quit();
		}
	}*/
	
/*	public void tearDownTest(){
		System.out.println("释放测试！");
		commonGrp.deleteGrp(grpName);
		commonPlan.deletePlan(planName);
	}*/
	
	@Test
	public void test1CreateKey(){
		System.out.println("新建关键词测试！");
		basePage.wait.waitOfThread();
		commonKey.createKey(planName, grpName, keyWord);
		System.out.println("======新建关键词测试成功======！");
	}
	
	@Test(enabled=false)
	public void test2DeleteKey(){
		System.out.println("删除关键词测试！");
		commonKey.deleteKey(keyWord);
		System.out.println("=======删除关键词测试成功=====！");
	}
	
	@Test(enabled=false)
	public void test3CreateKeyByPhoniex(){
		System.out.println("通过Phoenix新建关键词测试！");
		basePage.wait.waitOfThread();
		commonKey.createKeyByPhoenix(planName, grpName, keyWord);
		System.out.println("=======通过Phoenix新建关键词测试成功=======！");
	}
	
	@Test(enabled=false)
	public void test4DeleteKey(){
		System.out.println("删除关键词测试！");
		commonKey.deleteKey(keyWord);
		System.out.println("=======删除关键词测试成功=======！");
	}
}
