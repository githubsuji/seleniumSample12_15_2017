package com.facebook.fbtestapp.test.page.home;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.facebook.fbtestapp.test.driver.util.DriverUtil;

public class LoginTestUtil {

	public static boolean isLoginPageLoaded(WebDriver wd) {
		String actual_pg_id = wd.getTitle();
		return DriverUtil.assertMatch(actual_pg_id, Constant.LOGIN_PAGE_ID);
		
	}
	
	public static boolean isIncorrectPageLoaded(WebDriver wd) {
		String actual_pg_id = wd.getPageSource();
		return DriverUtil.assertIndMatch(actual_pg_id, Constant.INCRRT_PAGE_ID);
	}
	
	public static boolean isRightPageLoaded(WebDriver wd) {
		String actual_pg_id = wd.getPageSource();
		return DriverUtil.assertIndMatch(actual_pg_id, Constant.RIGHT_PAGE_ID);		
	}
	
	public static void inputUserName(String user,WebDriver wd) {
		try {
		WebElement username_txt_box = wd.findElement(By.name(Constant.USER_NAME_TXT_BOX_ID));
		username_txt_box.sendKeys(user);
		} catch (NoSuchElementException e) {
			System.out.println("Test failed - No such element found");
		} catch (Exception e) {
			System.out.println("Test Failed - Inputing text value has not occured");
		}
		System.out.println("Username entered successfully");
	}
	public static void inputPassword(String pass,WebDriver wd) {
		try {
		WebElement username_txt_box = wd.findElement(By.name(Constant.PASSWORD_TXT_BOX_ID));
		username_txt_box.sendKeys(pass);
		} catch (NoSuchElementException e) {
			System.out.println("Test failed - No such element found");
		} catch (Exception e) {
			System.out.println("Test Failed - Inputing text value has not occured");
		}
		System.out.println("Password entered successfully");
	}
	public static void doLoginAction(WebDriver wd) {
		try {
			WebElement login_button = wd.findElement(By.xpath(Constant.LOGIN_BUTTON_ID));
			login_button.click();
		} catch (NoSuchElementException e) {
			System.out.println("No such element found");
		} catch (Exception e) {
			System.out.println("Inputing text value has not occured");
		}
			System.out.println("Button click has done sucessfully");
	}
	
	
	
}
