package SeleniumLearn1;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.Base1;
import com.pageobject.BestBuyHomePage;

public class LinksCountTest extends Base1 {
	private static final Logger log = LogManager.getLogger(LinksCountTest.class.getName());
	private 	BestBuyHomePage bp;
	
	
	@BeforeTest
	public void browserCall() throws IOException {

		driver = CallBrowser();
		driver.get(prop.getProperty("url1"));
		log.debug("URL OF bestBuy : " + prop.getProperty("url1"));
		bp = new BestBuyHomePage(driver);
		bp.getclose().click();
	}

	@Test
	public void LinkCounts() {
		int linkscount = driver.findElements(By.tagName("a")).size();
		log.debug("Links Count in whole page is : " + linkscount);
		System.out.println("Links Count in whole page is : " + linkscount);
		WebElement footer = driver.findElement(By.id("large-footer"));
		int footerLinksCount = footer.findElements(By.tagName("a")).size();
		log.debug("Links Count in footer is  : " + footerLinksCount);
		System.out.println("Links Count in footer is  : " + footerLinksCount);
		WebElement ordersColumn = footer
				.findElement(By.xpath("\r\n" + "//div[@class='col-xs-3'] //ul[@aria-label='Orders & Returns']"));
		int ordersColumnCount = ordersColumn.findElements(By.tagName("a")).size();
		System.out.println("ordersColumnCount " + ordersColumnCount);
		for (int i = 0; i < ordersColumnCount; i++) {
			ordersColumn.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL, Keys.ENTER);

		}
	
		Set<String> windowid = driver.getWindowHandles();
		Iterator<String> it = windowid.iterator();
		String parentWindow = it.next();
		while (it.hasNext()) {

			String childTitle = driver.switchTo().window(it.next()).getTitle();
			System.out.println("Title of Child Window is : " + childTitle);
			log.debug("Title of Child Window is : " + childTitle);
			driver.close();
		}

		String parentTitle = driver.switchTo().window(parentWindow).getTitle();
		System.out.println("Title of parent  Window is : " + parentTitle);
		log.debug("Title of parent  Window is : " + parentTitle);
		
	}
	
	@Test
	public void ActionsClassPrctice() throws IOException {
		
		Actions a = new Actions(driver);
		driver.findElement(By.id("gh-search-input")).sendKeys("Mobile");

		// enter in capital
		a.moveToElement(bp.getsearchButton()).click().keyDown(Keys.SHIFT).sendKeys("Samsung").doubleClick().build()
				.perform();
		// right click on element
		a.moveToElement(bp.getgiftCards()).contextClick().build().perform();
	}

	@AfterTest
	public void TearDown()
	{
		driver.close();
		driver=null;
	}

}
