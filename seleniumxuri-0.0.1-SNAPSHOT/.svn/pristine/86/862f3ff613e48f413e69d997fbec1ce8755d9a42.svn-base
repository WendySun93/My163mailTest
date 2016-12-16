/**
 * 
 */
package com.sogou.bizqa.seleniumxuri.elements;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.SeleniumException;

/**
 * @author wangfan
 *
 */
public class Wait extends com.sogou.test.element.Wait {
	private static class WaitHolder {
		private static final Wait INSTANCE = new Wait();
	}

	private Wait() {
	}

	public static final Wait getInstance() {
		return WaitHolder.INSTANCE;
	}

	ScheduledThreadPoolExecutor executor = null;

	public boolean waitForelementDisplay(String locator, String time)
			throws InterruptedException {
		SheduleEntity entity = new SheduleEntity(Integer.valueOf(time));
		this.shedule(entity);
		int tempTime = 1000;
		while (!entity.isTimeout()) {
			if (IsExist.getInstance().elementIsExist(locator)) {
				this.shutdownAndwaitTermination(executor);
				return true;
			}
			Thread.sleep(tempTime);
		}
		throw new SeleniumException("ERROR: wait for '" + locator + "' " + time
				+ "s time out!");
	}

	private void shedule(final SheduleEntity shedule) {
		executor = new ScheduledThreadPoolExecutor(1);
		executor.schedule(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				shedule.setTimeout(true);
			}
		}, shedule.getTempTime(), TimeUnit.SECONDS);
	}

	private void shutdownAndwaitTermination(ExecutorService pool) {
		pool.shutdown();
		try {
			if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
				pool.shutdownNow();
				if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
					System.err.println("Pool did not terminate");
				}
			}
		} catch (InterruptedException ie) {
			pool.shutdown();
			Thread.currentThread().interrupt();
		}
	}

	class SheduleEntity {
		private boolean isTimeout = false;
		private int tempTime;

		public SheduleEntity(int tempTime) {
			this.tempTime = tempTime;
		}

		public void setTimeout(boolean isTimeout) {
			this.isTimeout = isTimeout;
		}

		public boolean isTimeout() {
			return isTimeout;
		}

		public int getTempTime() {
			return tempTime;
		}
	}
	
	/**
	 * @author wangfan
	 * @category 等待atlas首页数据区域的"数据读取中，请稍后" 处理完毕
	 * @param By locator
	 */
	public void wait4PageLoad(){
		new WebDriverWait(driver, 10);
	}
	
	public void waitOfThread(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
