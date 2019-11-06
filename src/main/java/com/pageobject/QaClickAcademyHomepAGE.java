package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaClickAcademyHomepAGE {
	public WebDriver driver;

	public QaClickAcademyHomepAGE(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="alertbtn")
	WebElement alertbtn;
	
	public WebElement getalertbtn()
	{
		return alertbtn;
	}
	
	
	@FindBy(id="confirmbtn")
	WebElement confirmbtn;
	
	public WebElement getconfirmbtn()
	{
		return confirmbtn;
	}
	
	@FindBy(xpath="//input[@id='checkBoxOption2']")
	WebElement checkBox2;
	
	public WebElement getcheckBox2()
	{
		return checkBox2;
	}
	
	@FindBy(id="dropdown-class-example")
	WebElement dropDown;
	
	public WebElement getdropDown()
	{
		return dropDown;
	}
	
	@FindBy(id="name")
	WebElement AlertName;
	
	public WebElement getAlertName()
	{
		return AlertName;
	}
	
	
	
	@FindBy(id="product")
	WebElement Table;
	
	public WebElement getTable()
	{
		return Table;
	}
	
	@FindBy(id="autocomplete")
	WebElement AutoDropDown;
	
	public WebElement getAutoDropDown()
	{
		return AutoDropDown;
	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']/li[5]")
	WebElement practice;
	
	public WebElement getpractice()
	{
		return practice;
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement login;
	
	public WebElement getlogin()
	{
		return login;
	}
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement email;
	
	public WebElement getemail()
	{
		return email;
	}
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement pwd;
	
	public WebElement getpwd()
	{
		return pwd;
	}
	@FindBy(xpath="//input[@name='commit']")
	WebElement loginuser;
	
	public WebElement getloginUser()
	{
		return loginuser;
	}
	
	
	@FindBy(xpath="//nav[@class='navbar-collapse collapse']")
	WebElement Navigationbar;
	
	public WebElement getNavigationbar()
	{
		return Navigationbar;
	}
	
	@FindBy(xpath="//input[@id='name']")
	WebElement alertTextBox;
	
	public WebElement getalertTextBox()
	{
		return alertTextBox;
	}
}
