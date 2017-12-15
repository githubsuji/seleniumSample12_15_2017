package com.facebook.fbtestapp.test.page.home.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.facebook.fbtestapp.test.driver.util.DriverUtil;
import com.facebook.fbtestapp.test.page.home.Constant;

public class HomePageActions {
	public static void doLogout(WebDriver wd) {
		try {
			WebElement logout_button = wd.findElement(By.id(Constant.LOGOUT_DROP_DOWN));
			logout_button.click();
		} catch (NoSuchElementException e) {
			System.out.println("No such element found");
		} catch (Exception e) {
			System.out.println("Log out has not occured");
		}
			System.out.println("Logout Button click has done sucessfully");
	    try {
	    	//ul/li[12]
	    	////div/div/div/div
	    	DriverUtil.applyWaitInMilliSeconds(10000);
	    	//*[@id=\"BLUE_BAR_ID_DO_NOT_USE\"]/div/div/div/div/div/ul/li[12]
	    	
	    	WebElement logout_menu = wd.findElement(By.xpath("//*[@id=\"BLUE_BAR_ID_DO_NOT_USE\"]/div/div/div/div/div/ul/li[12]"));
	    	System.out.println(logout_menu.getAttribute("innerHTML"));
	    	logout_menu.click();
	    	System.out.println("Logout Menu option Click done sucessfully");
	    } catch (NoSuchElementException e) {
			System.out.println("No such element found");
		} catch (Exception e) {
			System.out.println("Log out has not occured");
		}
	    	
	}
}
