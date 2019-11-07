package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoItHomePage {
	public WebDriver driver;

	public AutoItHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[3]//a[1]")
	WebElement firstPage;

	public WebElement getfirstPage() {
		return firstPage;
	}
	

}
