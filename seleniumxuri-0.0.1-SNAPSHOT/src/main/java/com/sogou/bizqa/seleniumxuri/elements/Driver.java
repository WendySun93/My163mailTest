/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.elements;

/**
 * @author wangfan
 *
 */
public class Driver extends com.sogou.test.element.Driver{
	private static class DriverHolder{
		private static final Driver INSTANCE = new Driver();
	}
	private Driver(){}
	public static final Driver getInstance(){
		return DriverHolder.INSTANCE;
	}
}
