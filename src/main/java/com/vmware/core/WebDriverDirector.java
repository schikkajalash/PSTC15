package com.vmware.core;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverDirector {

	public WebDriver invokeWebDriver(String BrowserName) throws Exception{
		WebDriver wd = null;
		  try
		    {
		      System.out.println("Entered into invokeSeleniumLocally");
		      if (BrowserName.equalsIgnoreCase("Firefox"))
		      {
		        FirefoxProfile firefoxProfile = new FirefoxProfile();
		        System.out.println("about to create firefoxdriver");
		        wd = new FirefoxDriver(firefoxProfile);
		      }
		      else if (BrowserName.equalsIgnoreCase("Internet Explorer"))
		      {
		    	URL DriverURL = ClassLoader.getSystemResource("./Drivers/IEDriverServer.exe");
		    	String Path = DriverURL.toURI().toString().substring(6).replace("/", "\\");
		    	System.out.println(Path);
		        File file = new File(Path);
		        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		        wd = new InternetExplorerDriver();
		      }
		      else if (BrowserName.equalsIgnoreCase("Safari"))
		      {
		        wd = new SafariDriver();
		      }
		      else if (BrowserName.equalsIgnoreCase("Chrome"))
		      {
			    	URL DriverURL = ClassLoader.getSystemResource("./Drivers/chromedriver.exe");
			    	String Path = DriverURL.toURI().toString().substring(6).replace("/", "\\");
			    	File file = new File(Path);
		        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		        wd = new ChromeDriver();
		      }
		      else if (BrowserName.equalsIgnoreCase("HtmlUnitDriver"))
		      {
		        wd = new HtmlUnitDriver();
		      }
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		    }
		return wd;
	}
}
