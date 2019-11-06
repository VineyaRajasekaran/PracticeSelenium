package SeleniumLearn1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.TestBase.Base1;
import com.pageobject.rahulshettyacademy;

public class SortingArrayTest extends Base1 {
	private static final Logger log = LogManager.getLogger(SortingArrayTest.class.getName());
	
	@Test
	public void sortingOfArray() throws IOException {
		driver = CallBrowser();
		driver.get(prop.getProperty("url4"));
		log.debug("URL OF SortingArrayTest in RahulShettyAcademy website : " + prop.getProperty("url4"));
		
		WebDriverWait wait = new WebDriverWait(driver, 6000L);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Top Deals')]")));
		rahulshettyacademy rs = new rahulshettyacademy(driver);
		rs.getTopDeals().click();
		// go to child window
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parentwindow = it.next();
		
			String childwindow = it.next();
			driver.switchTo().window(childwindow);

		
		rs.getVegetableHeader().click();
		rs.getVegetableHeader().click();
		int count = driver.findElements(By.xpath("//tr//td[2]")).size();

		ArrayList<String> originalArray = new ArrayList<String>();

		for (int i = 0; i < count; i++) {
			originalArray.add(driver.findElements(By.xpath("//tr//td[2]")).get(i).getText());

		}
		System.out.println(originalArray);

		ArrayList<String> copiedArray = new ArrayList<String>();
		for (String s : originalArray) {
			copiedArray.add(s);
		}
		System.out.println(copiedArray);

		Collections.sort(copiedArray);
		Assert.assertEquals(originalArray, copiedArray);
		driver.close();
		driver.switchTo().window(parentwindow).close();
	}

	@Test
	public void addToCartItems() throws InterruptedException, IOException {
		driver = CallBrowser();
		driver.get(prop.getProperty("url4"));
		log.debug("URL OF SortingArrayTest in RahulShettyAcademy website : " + prop.getProperty("url4"));
		rahulshettyacademy rs= new rahulshettyacademy(driver);

		ArrayList<String> items = new ArrayList<String>();
		items.add("Carrot");
		items.add("Capsicum");
		items.add("Corn");
		AddItemsToCart(items);
		rs.getCart().click();
		rs.getCheckout().click();
		rs.getpromoCode().sendKeys("rahulshettyacademy");
		rs.getApply().click();
		String text = driver.findElement(By.cssSelector("span[class='promoInfo']")).getText();
		System.out.println("promo info " +text);
		log.debug("promo info " +text);
		driver.close();
		
	}
	
	
	
	

	public void AddItemsToCart(ArrayList<String> items) {

		
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		int count = driver.findElements(By.cssSelector(".product-name")).size();
		
		int j = 0;

		for (int i = 0; i < count; i++) {

			String[] Vegetables = products.get(i).getText().split("-");

			String itemsInLoop = Vegetables[0].trim();
			
			if (items.contains(itemsInLoop)) {

				j++;
				driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();
				if (j == items.size()) {
					break;

				}

			}
		}

		
		
		
	}
	
	
	

}
