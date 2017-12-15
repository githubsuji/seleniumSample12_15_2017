package com.facebook.fbtestapp.test.page.home;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.facebook.fbtestapp.test.driver.util.DriverUtil;
import com.facebook.fbtestapp.test.page.home.actions.HomePageActions;

public class LoginTest {
	
	private static WebDriver driver = null;
	public static void initTest()
	{
		DriverUtil.initWebDriver();
		driver = DriverUtil.driver;
	}

	public static void wrongUserRightPasswordCase()
	{
		String url = "https://www.facebook.com/";
		driver.get(url);
		DriverUtil.applyWaitInMilliSeconds(3000);
		boolean isloginpage = LoginTestUtil.isLoginPageLoaded(driver);
		if(isloginpage){
			System.out.println("Login Page - loaded");
			LoginTestUtil.inputUserName(Constant.WRONG_USER_NAME, driver);
			LoginTestUtil.inputPassword(Constant.RIGHT_PASSWORD, driver);
			LoginTestUtil.doLoginAction(driver);
			DriverUtil.applyWaitInMilliSeconds(2000);
			boolean isimproperPage = LoginTestUtil.isIncorrectPageLoaded(driver);
			if(isimproperPage) {
				System.out.println("Test pass - assertion pass");
			}
			else {
				System.out.println("Test failed - assertion failed");
			}
		}
		else {
		System.out.println("Test failed - loging page not loaded");
		driver.close();
		}
	}
	
	public static void rightUserRightPasswordCase () 
	{
		String url = "https://www.facebook.com/";
		driver.get(url);
		DriverUtil.applyWaitInMilliSeconds(3000);
		boolean isloginPage = LoginTestUtil.isLoginPageLoaded(driver);
		if (isloginPage) {
			System.out.println("Login Page Loaded Successfully");
			LoginTestUtil.inputUserName(Constant.RIGHT_USER_NAME, driver);
			LoginTestUtil.inputPassword(Constant.RIGHT_PASSWORD, driver);
			LoginTestUtil.doLoginAction(driver);
			DriverUtil.applyWaitInMilliSeconds(3000);
			boolean isrightpage = LoginTestUtil.isRightPageLoaded(driver);
			if(isrightpage) {
				System.out.println("Testcase Pass - Assertion Pass");
			} else {
				System.out.println("Testcase Fail - Assertion Fail");
			}			
		} else {
			System.out.println("Testcase fail - login page fail");
		}
		System.out.println("now 4 logout testing");
		DriverUtil.applyWaitInMilliSeconds(10000);
		HomePageActions.doLogout(driver);
		driver.close();
		driver.quit();
//		DriverUtil.killProcess();
		
	} 
	
    public static void rightUserWrongPasswordCase()
    {
		
	}
	
	public static void wrongUserWrongPasswordCase ()
	{
		
	} 
	
	public static void trials()
	{
		String url = "https://www.facebook.com/";
		driver.get(url);
		String cmpurl = driver.getCurrentUrl();
		System.out.println(cmpurl);
		String title = "Facebook – log in or sign up";
		String cmptitle = driver.getTitle();
		System.out.println(cmptitle);
		//String pgsource =driver.getPageSource();
		//System.out.println(pgsource);
		//String windowhandler = driver.getWindowHandle();
		//System.out.println(windowhandler);
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println("less than jdk8");
		for (String s : windowhandles) {
			System.out.println(s);
		}
}
	
}
