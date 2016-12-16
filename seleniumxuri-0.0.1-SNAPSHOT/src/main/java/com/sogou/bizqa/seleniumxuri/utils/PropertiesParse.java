/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.utils;

/**
 * @author wangfan
 *
 */
public class PropertiesParse extends com.sogou.test.util.PropertiesParse{
	private static class PropertiesParseHolder{
		private static final PropertiesParse INSTANCE = new PropertiesParse();
	}
	private PropertiesParse(){}
	public static final PropertiesParse getInstance(){
		return PropertiesParseHolder.INSTANCE;
	}
}
