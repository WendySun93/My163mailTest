/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.base;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sogou.bizqa.seleniumxuri.elements.Driver;
import com.sogou.bizqa.seleniumxuri.elements.Element;
import com.sogou.bizqa.seleniumxuri.elements.IsExist;
import com.sogou.bizqa.seleniumxuri.elements.MyEventListener;
import com.sogou.bizqa.seleniumxuri.elements.ResultList;
import com.sogou.bizqa.seleniumxuri.elements.Value;
import com.sogou.bizqa.seleniumxuri.elements.Wait;
import com.sogou.bizqa.seleniumxuri.utils.CommonUtil;
import com.sogou.bizqa.seleniumxuri.utils.PropertiesParse;
import com.sogou.test.controls.Select;
import com.sogou.test.controls.TextBox;
import com.sogou.test.controls.er.RadioGroup;
import com.sogou.test.element.Operate;

/**
 * @author wangfan
 *
 */
public class BasePage {

	private static class BasePageHolder {
		private static final BasePage INSTANCE = new BasePage();
	}

	private BasePage() {
	}

	public static final BasePage getInstance() {
		return BasePageHolder.INSTANCE;
	}

	public String explorerType;
	public String propertieFilepath;
	public String ip;
	public String driverType;

	public WebDriver webDriver;

	public Driver dr;
	public Element element;
	public IsExist isExist;
	public MyEventListener myEventListener;
	public ResultList resultList;
	public Operate operate;
	public Wait wait;
	public CommonUtil commonUtil;
	public PropertiesParse propertiesParse;
	public Value value;
	public Util util;

	public String getExplorerType() {
		return explorerType;
	}

	public void setExplorerType(String explorerType) {
		this.explorerType = explorerType;
	}

	public String getPropertieFilepath() {
		return propertieFilepath;
	}

	public void setPropertieFilepath(String propertieFilepath) {
		this.propertieFilepath = propertieFilepath;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDriverType() {
		return driverType;
	}

	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}

	public Driver getDr() {
		return dr;
	}

	public void setDr(Driver dr) {
		this.dr = dr;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public IsExist getIsExist() {
		return isExist;
	}

	public void setIsExist(IsExist isExist) {
		this.isExist = isExist;
	}

	public MyEventListener getMyEventListener() {
		return myEventListener;
	}

	public void setMyEventListener(MyEventListener myEventListener) {
		this.myEventListener = myEventListener;
	}

	public ResultList getResultList() {
		return resultList;
	}

	public void setResultList(ResultList resultList) {
		this.resultList = resultList;
	}

	public Operate getOperate() {
		return operate;
	}

	public void setOperate(Operate operate) {
		this.operate = operate;
	}

	public Wait getWait() {
		return wait;
	}

	public void setWait(Wait wait) {
		this.wait = wait;
	}

	public CommonUtil getCommonUtil() {
		return commonUtil;
	}

	public void setCommonUtil(CommonUtil commonUtil) {
		this.commonUtil = commonUtil;
	}

	public PropertiesParse getPropertiesParse() {
		return propertiesParse;
	}

	public void setPropertiesParse(PropertiesParse propertiesParse) {
		this.propertiesParse = propertiesParse;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Util getUtil() {
		return util;
	}

	public void setUtil(Util util) {
		this.util = util;
	}

	public Alert _Alert() {
		// TODO Auto-generated method stub
		try {
			return webDriver.switchTo().alert();
		} catch (Exception e) {
			operate.captureSnapShot();
		}
		return null;
	}
	
	public boolean isAlert(){
		try{
			webDriver.switchTo().alert();
			return true;
		}catch (NoAlertPresentException Ex) {
			// TODO: handle exception
			return false;
		}
	}

	/**
	 * 生成Element对象，会首先等待这个元素加载完成，然后再生成
	 * 
	 * @param by
	 *            By对象作为参数
	 * @return
	 */
	public WebElement _Element(By by) {
		wait.waitElement(by);
		return webDriver.findElement(by);
	}

	public WebElement _Element(String xpath) {
		// TODO Auto-generated method stub
		wait.waitElement(xpath);
		return webDriver.findElement(By.xpath(propertiesParse.getValue(xpath)));
	}

	/**
	 * 生成有相同xpath前缀的element列表
	 * 
	 * @param by
	 *            By
	 * @return
	 */
	public List<WebElement> _ElementList(By by) {
		return webDriver.findElements(by);
	}

	/**
	 * 页面单选radio，生成表示radio组合的对象
	 * 
	 * @param xpath
	 *            radio的父节点xpath，property定义
	 * @return
	 */
	public RadioGroup _RadioGroup(String xpath) {
		RadioGroup r = new RadioGroup(webDriver, By.xpath(propertiesParse
				.getValue(xpath)));
		r.init();
		return r;
	}

	/**
	 * 将页面上select元素生成对象
	 * 
	 * @param by
	 *            By
	 * @return Select
	 */
	public Select _Select(By by) {
		return new Select(webDriver, by);
	}

	/**
	 * 将页面上select元素生成对象
	 * 
	 * @param xpath
	 *            property定义的xpath
	 * @return Select
	 */
	public Select _Select(String xpath) {
		return new Select(webDriver, By.xpath(propertiesParse.getValue(xpath)));
	}

	/**
	 * 生成输入框
	 * 
	 * @param by
	 * @return
	 */
	public TextBox _TextBox(By by) {
		return new TextBox(webDriver, by);
	}

	/**
	 * 键盘操作
	 * 
	 * @param wd
	 * @param key
	 */
	public void enterKey(Keys keysToSend) {
		Actions act = new Actions(webDriver);
		act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * 根据radio的name属性，选择radio value属性值是value的一个
	 * 
	 * @param name
	 *            radio name属性
	 * @param value
	 *            选择的radio的value属性值
	 */
	public void selectRadioByValue(String name, String value) {
		List<WebElement> webElements = webDriver.findElements(By.name(name));
		for (WebElement we : webElements) {
			if (we.getAttribute("value").equals(value)) {
				if (!we.isSelected())
					we.click();
			}
		}
	}

	/**
	 * radio选择第index个
	 */
	public void selectRadioByIndex(String name, int index) {
		List<WebElement> webElements = webDriver.findElements(By.name(name));
		WebElement we = webElements.get(index);
		if (!we.isSelected())
			we.click();
	}

	public void selectByValue(String selectXpath, String value) {
		webDriver.findElement(By.xpath(selectXpath)).click();
		if (value != null) {
			// waitIsDisplayed(wd, "//option[@value='" + value + "']");
			new WebDriverWait(webDriver, 15).until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//option[@value='"
							+ value + "']")));
		}
		org.openqa.selenium.support.ui.Select sel = new org.openqa.selenium.support.ui.Select(
				webDriver.findElement(By.xpath(selectXpath)));
		sel.selectByValue(value);
		enterKey(Keys.ENTER);
	}

	public void selectByText(String selectXpath, String text) {
		// webDriver.findElement(By.xpath(selectXpath)).click();
		webDriver.findElement(By.xpath(propertiesParse.getValue(selectXpath)))
				.click();
		if (text != null) {
			// waitIsDisplayed(wd, "//option[@value='" + value + "']");
			new WebDriverWait(webDriver, 15).until(ExpectedConditions
					.presenceOfElementLocated(By
							.xpath("//option[contains(text()," + text + ")]")));
		}
		org.openqa.selenium.support.ui.Select sel = new org.openqa.selenium.support.ui.Select(
				webDriver.findElement(By.xpath(propertiesParse
						.getValue(selectXpath))));
		sel.selectByVisibleText(text);
		// enterKey(Keys.ENTER);
	}

	public void selectRadioByText(String name, String text) {
		// TODO Auto-generated method stub
		List<WebElement> webElements = webDriver.findElements(By.name(name));
		for (WebElement we : webElements) {
			if (value.getText(explorerType, we).trim().equals(text)) {
				if (!we.isSelected())
					we.click();
			}
		}
	}

	public String table(String xpath, String col, String row) {
		return propertiesParse.getValue(xpath) + "/descendant::*[@col='" + col
				+ "' and @row='" + row
				+ "']/descendant-or-self::*[@type='checkbox']";
	}

	public WebElement _Element(String xpath, int col, int row) {
		// TODO Auto-generated method stub
		wait.waitElement(xpath);
		return webDriver.findElement(By.xpath(propertiesParse.getValue(xpath)
				+ "/descendant::*[@col='" + String.valueOf(col)
				+ "' and @row='" + String.valueOf(row)
				+ "']/descendant-or-self::*[@type='checkbox']"));
	}

	/**
	 * 生成Element对象，会首先等待这个元素加载完成，然后再生成
	 * 
	 * @param id
	 *            property文件中记录的linkText
	 * @return WebElement
	 */
	public WebElement _ElementByLinkText(String id) {
		wait.waitElementByLinkText(id);
		return webDriver.findElement(By.linkText(propertiesParse.getValue(id)));
	}

	public void setScroll(WebElement elment) {
		try {
			// String setscroll = arguments[0].scrollIntoView();

			JavascriptExecutor jse = (JavascriptExecutor) webDriver;
			jse.executeScript("arguments[0].scrollIntoView()", elment);
		} catch (Exception e) {
			System.out.println("Fail to set the scroll.");
		}
	}

	public WebElement getTableList(String xpath, int col, int row) {
		WebElement ele=webDriver.findElement(By.xpath(propertiesParse.getValue(xpath)
				+ "/descendant::*[@col='" + col + "' and @row='" + row + "']"));
		System.err.println(By.xpath(propertiesParse.getValue(xpath)
				+ "/descendant::*[@col='" + col + "' and @row='" + row + "']"));
		return ele;
	}

	public Select selectTableList(String xpath, int row) {
		System.out.println(propertiesParse.getValue(xpath)
				+ "/descendant::*[@col='0' and @row='" + row
				+ "']/descendant-or-self::*[@type='checkbox']");
		return new Select(webDriver, By.xpath(propertiesParse.getValue(xpath)
				+ "/descendant::*[@col='0' and @row='" + row
				+ "']/descendant-or-self::*[@type='checkbox']"));
	}

}
