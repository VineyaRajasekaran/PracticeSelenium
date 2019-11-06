package SeleniumLearn1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.Base1;
import com.pageobject.QaClickAcademyHomepAGE;

public class ParametrizatonTest extends Base1 {
	private static final Logger log = LogManager.getLogger(ParametrizatonTest.class.getName());
	
	private QaClickAcademyHomepAGE qa;
	

	@Test(dataProvider= "getData")
	public void parametrizationExample(String email, String password) throws IOException
	{
		driver=CallBrowser();
		driver.get(prop.getProperty("url6"));
		log.debug("URL OF Login Page QACLICKACADEMY : " +prop.getProperty("url6"));
		qa= new QaClickAcademyHomepAGE(driver);
		qa.getlogin().click();
		qa.getemail().sendKeys(email);
		log.debug("email is: " +email);
		
		qa.getpwd().sendKeys(password);
		log.debug("pwd is: " +password);
		qa.getloginUser().click();
		driver.close();
		
		
		
	}
	
	@DataProvider()
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0]="first@email";
		data[0][1]="first@pwd";
		data[1][0]="second@email";
		data[1][1]="second@pwd";
	
		return data;
	}
	
	
	/**@Test
	public void NavigationBarIsDisplayed() throws IOException {
		QaClickAcademyHomepAGE qa= new QaClickAcademyHomepAGE(driver);
		WebDriverWait wait = new WebDriverWait(driver, 1000L);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='navbar-collapse collapse']")));
		Assert.assertTrue(qa.getNavigationbar().isDisplayed(), "true");
		
	} **/
	
		
}
