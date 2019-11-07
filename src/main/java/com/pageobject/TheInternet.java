package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheInternet {
	WebDriver driver;
	
	public TheInternet (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[text()='Multiple Windows']")
	WebElement MultipleWindow;
	
	public WebElement getMultipleWindow()
	{
		return MultipleWindow;
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Click Here')]")
	WebElement clickHere;
	
	public WebElement getclickHere()
	{
		return clickHere;
	}
	
	
	@FindBy(xpath="//a[text()='Frames']")
	WebElement Framesbutton;
	
	public WebElement getFramesbutton()
	{
		return Framesbutton;
	}
	
	@FindBy(xpath="//a[contains(text(),'Nested Frames')]")
	WebElement NestedFrames;
	
	public WebElement getNestedFrames()
	{
		return NestedFrames;
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Basic Auth')]")
	WebElement WindowAuthentication;
	
	public WebElement getWindowAuthentication()
	{
		return WindowAuthentication;
	}
	
	
}


