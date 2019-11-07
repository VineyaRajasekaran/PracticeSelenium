package SeleniumLearn1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.TestBase.Base1;
import com.pageobject.TheInternet;

public class WindowAuthenticationTest extends Base1{
	private static final Logger log = LogManager.getLogger(WindowAuthenticationTest.class.getName());
	@Test
	public void WindowAuthentication() throws IOException {
		driver = CallBrowser();
		driver.get(prop.getProperty("url7"));
		log.debug("URL OF WindowAuthentication TheInternet : " + prop.getProperty("url7"));
		TheInternet i = new TheInternet(driver);
		i.getMultipleWindow().click();
		driver.close();
		
	}
	

}
