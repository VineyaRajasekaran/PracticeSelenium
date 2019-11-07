package SeleniumLearn1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.TestBase.Base1;


public class FileUploadTest extends Base1 {
	private static final Logger log = LogManager.getLogger(FileUploadTest.class.getName());
		
	@Test
	public void fileUpload() throws IOException, InterruptedException {
		driver = CallBrowser();
		driver.get(prop.getProperty("url8"));
		log.debug("URL OF pdftoJpg : " + prop.getProperty("url8"));
		WebDriverWait wait = new WebDriverWait(driver,1000L);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='advanced_pdf_file']")));
		driver.findElement(By.xpath("//button[@id='advanced_pdf_file']")).click();
		Thread.sleep(3000L);
		Runtime.getRuntime().exec("C:\\Users\\dinav\\Documents\\Mydata_SQL\\filedownload.exe");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='convert_pdf_to_jpg_button']")));
	//	driver.findElement(By.xpath("//input[@id='convert_pdf_to_jpg_button']")).click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[3]//a[1]")));
	//	AutoItHomePage ap= new AutoItHomePage(driver);
	//	ap.getfirstPage().click();
		
	}

}
