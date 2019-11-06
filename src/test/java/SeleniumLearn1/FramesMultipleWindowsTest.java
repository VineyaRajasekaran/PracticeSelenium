package SeleniumLearn1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.Base1;
import com.pageobject.TheInternet;

public class FramesMultipleWindowsTest extends Base1 {
	
	private static final Logger log = LogManager.getLogger(FramesMultipleWindowsTest.class.getName());
	private TheInternet i;
	
	
	@Test
	public void MultipleWindows() throws IOException {
		driver = CallBrowser();
		driver.get(prop.getProperty("url3"));
		log.debug("URL OF TheInternet : " + prop.getProperty("url3"));
		
		i = new TheInternet(driver);
		i.getMultipleWindow().click();
		i.getclickHere().click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		// it.next();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		String childtext = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		driver.close();
		driver.switchTo().window(parentwindow);
		String parenttext = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		System.out.println(parenttext);
		driver.close();
	}
	
	@Test
	public void FramesPractice() throws IOException {
		driver = CallBrowser();
		driver.get(prop.getProperty("url3"));
		log.debug("URL OF TheInternet : " + prop.getProperty("url3"));
		
		i.getFramesbutton().click();
		i.getNestedFrames().click();
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//html/frameset")));
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
	String text =driver.findElement(By.xpath("//div[@id='content']")).getText();
	
		log.debug("the text in the frames is " +text);
		Assert.assertEquals(text, "MIDDLE");
		driver.close();
		
	}
	
	

}
