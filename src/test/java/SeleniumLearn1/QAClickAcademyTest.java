package SeleniumLearn1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.Base1;
import com.pageobject.BestBuyHomePage;
import com.pageobject.QaClickAcademyHomepAGE;



public class QAClickAcademyTest extends Base1 {
	
	private static final Logger log = LogManager.getLogger(QAClickAcademyTest.class.getName());
	private QaClickAcademyHomepAGE qa;
	
	@BeforeTest
	public void browserCall() throws IOException {

		driver=CallBrowser();
		driver.get(prop.getProperty("url2"));
		log.debug("URL OF QACLICKACADEMY : " +prop.getProperty("url2"));
	}
	
	@Test
	public void AlertExample() throws IOException, InterruptedException
	{
		
		qa= new QaClickAcademyHomepAGE(driver);
		qa.getalertTextBox().sendKeys("Testing");
		Thread.sleep(3000L);
		qa.getalertbtn().click();
		Thread.sleep(3000L);
		String alertext = driver.switchTo().alert().getText();
		log.debug("alert information : "+alertext);
		driver.switchTo().alert().accept();
		Thread.sleep(3000L);
		qa.getalertTextBox().sendKeys("ConfirmButton");
		Thread.sleep(3000L);
		qa.getconfirmbtn().click();
		Thread.sleep(3000L);
		String confirmtext = driver.switchTo().alert().getText();
		log.debug("confirm alert information : "+confirmtext);
		driver.switchTo().alert().dismiss();
		
		
	}
	
	@Test
	public void CheckBoxPractice() throws IOException
	{
		
		
	
		qa.getcheckBox2().click();
		String value = qa.getcheckBox2().getAttribute("value");
		System.out.println(value);
		Select s= new Select(qa.getdropDown());
		s.selectByValue(value);
		//alert box
		
		qa.getAlertName().sendKeys(value);
		qa.getalertbtn().click();
		String alertext = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		log.debug("Checkbox alert text  "+alertext);
		Assert.assertEquals("Hello option2, share this practice page and share your knowledge", alertext);
		
	}
	
	
		 @Test
	public void TablesRowColumnCount() throws IOException
	{
		int rowCount = driver.findElements(By.xpath("//div[@class='block large-row-spacer']//tr")).size();
		log.debug("Row count is :" +rowCount);
		int columnCount = driver.findElements(By.xpath("//table[@id='product']//th")).size();
		log.debug("Col count is :" +columnCount);
		
		for (int i=0; i<rowCount; i++) {
			if(i==2)
			{
				String text= driver.findElements(By.xpath("//div[@class='block large-row-spacer']//tr")).get(i).getText();
			
			log.debug("Tables Test" +text);
			break;
			}
			
		}
		
	}
	
	
	@Test
	public void AutoSuggestive() throws InterruptedException, IOException
	{
		String text;
		
		qa.getAutoDropDown().sendKeys("Unite");
		Thread.sleep(2000);//this is very important otherwise code doesnt work 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script ="return document.getElementById(\"autocomplete\").value;";
		text = (String) js.executeScript(script);
		int i=0;
		while(!text.equalsIgnoreCase("United States"))
		{
			i++;
			Thread.sleep(2000L);
			qa.getAutoDropDown().sendKeys(Keys.ARROW_DOWN);
			text = (String) js.executeScript(script);
			log.debug("text in loop of AutoSuggestiveDropdown" +text);
			if(i>10)
				break;
			
		}
		log.debug("Final text in  AutoSuggestiveDropdown" +text);
		Assert.assertEquals(text, "United States");
		
		
		
	}
	
	
	
	
	
	

	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}
	
	
}
