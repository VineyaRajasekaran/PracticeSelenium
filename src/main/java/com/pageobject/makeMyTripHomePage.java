package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class makeMyTripHomePage {
	
	WebDriver driver;
	
	public makeMyTripHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="fromCity")
	WebElement fromCity;
	
	public WebElement getFromCity()
	{
		return fromCity;
	}

	
}
