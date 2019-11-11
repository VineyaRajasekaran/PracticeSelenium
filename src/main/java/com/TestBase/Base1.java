package com.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;



public class Base1 {
	public static WebDriver driver;
	public Properties prop;
	
	

	public WebDriver CallBrowser() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resourcesNew\\mydata.properties");
		prop.load(fis);
		if(System.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resourcesNew\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(System.getProperty("browser").contains("headless")) 
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		else if(System.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resourcesNew\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3000L, TimeUnit.SECONDS);
		return driver;
		
	}
	
	
	public void TakeScreenShot(String failedTestCase) throws IOException
	{
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File("C:\\Users\\dinav\\Pictures\\"+failedTestCase+"Screenshots.png"));
		
	}
}
