package SeleniumLearn1;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.Base1;
import com.pageobject.SpiceJetHomePage;

public class SpiceJetTest extends Base1 {
	private static final Logger log = LogManager.getLogger(SpiceJetTest.class.getName());
	SpiceJetHomePage sp;
	@BeforeTest
	public void browserCall() throws IOException {

		driver = CallBrowser();
		driver.get(prop.getProperty("url"));
		log.debug("URL OF SpiceJet : " + prop.getProperty("url"));
	}

	@Test
	public void RoundTrip() throws IOException, InterruptedException {

		sp = new SpiceJetHomePage(driver);
		sp.getroundTrip().click();
		// FROMCITY
		sp.getfromCity().click();
		sp.getselectFromCity().click();
		sp.getselecToCity().click();

		// departure date
		sp.getdepartDate().click();
		int date = driver.findElements(By.cssSelector("a[class='ui-state-default']")).size();
		System.out.println("date is " + date);
		int month = driver.findElements(By.cssSelector("span[class='ui-datepicker-month']")).size();
		System.out.println(month);
		// select month
		while (!driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText().contains("January")) {
			System.out.println(driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText());
			driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		// select date
		for (int i = 0; i < date; i++) {
			if (driver.findElements(By.cssSelector("a[class='ui-state-default']")).get(i).getText().contains("16")) {
				driver.findElements(By.cssSelector("a[class='ui-state-default']")).get(i).click();
				break;
			}
		}
		// return date

		Thread.sleep(4000);

		sp.getreturnDate().click();
		// select month
		while (!driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText()
				.contains("February")) {
			System.out.println(driver.findElement(By.cssSelector("span[class='ui-datepicker-month']")).getText());
			driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		// select date
		for (int i = 0; i < date; i++) {
			if (driver.findElements(By.cssSelector("a[class='ui-state-default']")).get(i).getText().contains("21")) {
				driver.findElements(By.cssSelector("a[class='ui-state-default']")).get(i).click();
				break;
			}
		}

		Thread.sleep(4000);
		sp.getpassengers().click();
		Thread.sleep(4000);
		Select s = new Select(sp.getadult());
		s.selectByIndex(1);
		Select s1 = new Select(sp.getchild());
		s1.selectByIndex(2);
		Select s2 = new Select(sp.getinfant());
		s2.selectByIndex(0);
		sp.getcurrency().click();
		Select s4 = new Select(sp.getcurrency());
		s4.selectByValue("INR");
		//checkbox
		int checkbox_count = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		log.debug("checkbox count is  " +checkbox_count);
		//is checkbox enabled
		Boolean value = sp.getcheckbox_Family().isSelected();
		log.debug("checkbox isEnabled  " +value);
		System.out.println(value);
		sp.getcheckbox_Family().click();
		//to cheeck whether the return date is in enabled node during OneWay
		Boolean enabled = driver.findElement(By.id("spclearDate")).getAttribute("style").contains("display: block;");
		if(enabled) {
			Assert.assertTrue(true);
			log.debug("Return date is enabled");
		}
		else
			Assert.assertFalse(false);
			
		
	}
	
	@Test
	public void MouseOverActions()
	{
		 sp = new SpiceJetHomePage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(sp.getaddOns()).build().perform();
		
	}

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}
}
