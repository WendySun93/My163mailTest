/**
 * Project: biz-atlas
 * 
 * File Created at 2011-8-12
 * $Id$
 * 
 * Copyright 2011 sogou.com Corporation Limited.
 * All rights reserved.
 *
 */
package com.sogou.bizqa.seleniumxuri.base;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO Comment of AppContext
 * 
 * @author Administrator
 *
 */
public class AppContext {
	private static AppContext ctx = new AppContext();
	private static AbstractXmlApplicationContext context;

	public AppContext() {
		context = new ClassPathXmlApplicationContext(
				new String[] { "appContext-xuri.xml" });
	}

	public static synchronized AppContext getInstance() {
		return ctx;
	}

	public static synchronized AbstractXmlApplicationContext getAppCtx() {
		return context;
	}
}
