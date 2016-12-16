/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.base;

import java.math.BigDecimal;

import com.sogou.test.util.AntStart;
import com.sogou.test.util.Arith;
import com.sogou.test.util.CommonUtil;
import com.sogou.test.util.Constant;
import com.sogou.test.util.DateUtil;
import com.sogou.test.util.Dom4JParser;
import com.sogou.test.util.ExcelParse;
import com.sogou.test.util.ExcelUtil;
import com.sogou.test.util.MailClient;
import com.sogou.test.util.PropertiesParse;
import com.sogou.test.util.ReadText;
import com.sogou.test.util.Snapshot;
import com.sogou.test.util.StrToSuanshi;

/**
 * @author wangfan
 *
 */
public class Util {
	private static class UtilHolder{
		private static final Util INSTANCE = new Util();
	}
	private Util(){}
	public static final Util getInstance(){
		return UtilHolder.INSTANCE;
	}
	
	public String string2Float(String str){
        BigDecimal n = new BigDecimal(str);
        BigDecimal f = n.setScale(2, BigDecimal.ROUND_FLOOR);
        return String.valueOf(f);
	}
	
}
