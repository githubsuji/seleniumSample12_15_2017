package com.faceboo.fbtestapp.test.runner;
import com.facebook.fbtestapp.test.driver.util.DriverUtil;
import com.facebook.fbtestapp.test.page.home.*;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DriverUtil.browserId="chrome";
		LoginTest.initTest();
		//DriverUtil.applyWaitInMilliSeconds(3000);
		//LoginTest.wrongUserRightPasswordCase();
		//LoginTest.rightUserRightPasswordCase();
		//LoginTest.trials();
		//*[@id="js_df"]/div/div
		//*[@class="uiScrollableAreaContent"][0]/ul/li[12]
		SignUpTest.initTest();
		SignUpTest.trials();
	}

}
