/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.elements;


/**
 * @author wangfan
 *
 */
public class ResultList extends com.sogou.test.element.ResultList{
	private static class ResultListHolder{
		private static final ResultList INSTANCE = new ResultList();
	}
	private ResultList(){}
	public static final ResultList getInstance(){
		return ResultListHolder.INSTANCE;
	}
}
