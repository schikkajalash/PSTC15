package com.vmware.sanity;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vmware.core.WebDriverDirector;

public class LaunchBrowser {
	WebDriver driver = null;

	@BeforeClass
	public void oneTimeSetUp() throws Exception{
		WebDriverDirector WDDir = new WebDriverDirector();
		driver = WDDir.invokeWebDriver("Internet Explorer");
	}
	
	@Test
	public void assertTitle(){
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
	}
	
	@AfterClass	
	public void tearDown(){
		driver.close();
		driver.quit();
	}
}
