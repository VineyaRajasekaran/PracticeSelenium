package SeleniumLearn1;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.TestBase.Base1;

public class MiscellaneousTest extends Base1 {
	
	private static final Logger log = LogManager.getLogger(MiscellaneousTest.class.getName());
	
	@Test
	public void TableGrid() throws IOException {
		driver = CallBrowser();
		driver.get(prop.getProperty("url5"));
		log.debug("URL OF cricinfo : " + prop.getProperty("url5"));
		WebElement table = driver.findElement(By.xpath("//div[@id='gp-inning-00']"));
		int sum = 0;
		List<WebElement> rows = table.findElements(By.cssSelector("div[class='wrap batsmen'] div:nth-child(3)"));
		for (int i = 0; i < rows.size(); i++) {
			String runs = rows.get(i).getText();
			int int_run = Integer.parseInt(runs);
			sum = sum + int_run;
		}

		String extra = driver.findElement(By.xpath("//div[@id='gp-inning-00']//div[@class='wrap extras']/div[2]"))
				.getText();
		String[] extra1 = extra.split(" ");

		int extra2 = Integer.parseInt(extra1[0].trim());

		log.info("extra2 " + extra2);
		System.out.println(extra2);

		String total = driver.findElement(By.xpath("//div[@id='gp-inning-00']//div[@class='wrap total']/div[2]"))
				.getText();
		String[] total1 = total.split("a");
		log.info("total1 " + total1[0].trim());
		log.debug("total1 " + total1[0].trim());
		String total2 = total1[0].trim();

		int totalInt = Integer.parseInt(total2);

		int finaltotal = sum + extra2;
		log.info("finaltotal" + finaltotal);

		Assert.assertEquals(totalInt, finaltotal);
		log.error("error");
		log.fatal("fatal");
		log.debug("debug");


	}
	
	

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
	}
	
	

}
