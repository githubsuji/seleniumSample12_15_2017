package com.facebook.fbtestapp.test.page.home;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;

import com.facebook.fbtestapp.test.driver.util.DriverUtil;

public class SignUpTest {
	
	private static WebDriver driver = null;
	public static void initTest()
	{
		DriverUtil.initWebDriver();
		driver = DriverUtil.driver;
	}
	public static void trials() {
		
		driver.get("http://toolsqa.com/automation-practice-form");
		WebElement continent=driver.findElement(By.className("input-xlarge"));
		
		Select s=new Select(continent);
		s.selectByVisibleText("Australia");
		
		WebElement wd=s.getFirstSelectedOption();
		String s1=wd.getText();//Both s1 and s2 same
		String s2=wd.getAttribute("innerHTML");
		DriverUtil.applyWaitInMilliSeconds(2000);
		
		System.out.println(s1);
		System.out.println(s2);
		
		s.selectByIndex(4);
		WebElement wd1=s.getFirstSelectedOption();
		String s3=wd1.getText();
		System.out.println(s3);
		
		
		List<WebElement> optionlist=s.getOptions();
		for(WebElement option :optionlist)
		{
			System.out.println(option.getText());
		}
	}

}
