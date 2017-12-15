package com.facebook.fbtestapp.test.driver.util;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverUtil {
	
	public static WebDriver driver = null;
	public static String browserId = null;
	public static void initWebDriver() {
		if (browserId.equals("chrome"))
			initChrome();
		else if (browserId.equals("firefox")) {
			initFirefox();
		}
	}
    public static void initFirefox() {
    	System.setProperty("webdriver.gecko.driver","D:\\Selenium\\selenium3.6.0\\driver\\geckodriver.exe");
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    	capabilities.setCapability("marionette",true);
    	FirefoxOptions options = new FirefoxOptions(capabilities);
    	driver = new FirefoxDriver(options);
    	
    }
    public static void initChrome() {
    	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\selenium3.6.0\\driver\\chromedriver.exe");
    	 ChromeOptions options = new ChromeOptions();
    	/* Run regedit command using window+r shortcut.

    	 Registry Editor will opens then perform below mentioned.

    	 There is a setting in the registry that's causing it.In the registry it's 
    	 under HKEY_CURRENT_USER\Software\Google\Chrome\TriggeredReset

    	 Delete the TriggeredReset key and then close regedit.

    	 */
    	
    	  options.addArguments(Arrays.asList("--test-type","test-type=browser","--disable-default-apps","--enable-precise-memory-info",
    			  "--js-flags=--expose-gc","--disable-infobars","--start-maximized",  "--ignore-certificate-errors",
    			  "--disable-popup-blocking", "--allow-running-insecure-content","--disable-notifications",
    			  "--disable-save-password","--disable-translate", "--always-authorize-plugins"));

    	driver = new ChromeDriver(options);
    }
    public static void applyWaitInMilliSeconds(long time) //apply wait
    {
    	try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static boolean assertMatch(String actual, String expected) {
    	if (null != actual&& actual.equals(expected)){
		return true;
    	}
    	return false;
    }
    public static boolean assertIndMatch(String actual,String expected) {
    	if (null != actual&& actual.indexOf(expected) > -1)
    	{
    		return true;
        	}
        	return false;
        }
    public static void killProcess(){
    	//https://superuser.com/questions/877346/how-to-kill-a-specific-java-process-by-application-name
    	String windowsCommand = "taskkill /F /FI chromedriver.exe /T";
    	Runtime rt = Runtime.getRuntime();
    	  if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
			try {
				rt.exec(windowsCommand);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   //else
    	     //rt.exec("kill -9 " +....);
    }
}
	