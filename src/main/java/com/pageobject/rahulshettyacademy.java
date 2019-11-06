package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rahulshettyacademy {
	public WebDriver driver;

	public rahulshettyacademy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
/**	@FindBy(css="tr th:nth-child(2)")
	WebElement VegetableHeader;
	
	public WebElement getVegetableHeader()
	{
		return VegetableHeader;
	}**/
	

	@FindBy(xpath="//tr//th[2]")
	WebElement VegetableHeader;
	
	public WebElement getVegetableHeader()
	{
		return VegetableHeader;
	}
	@FindBy(xpath="//a[contains(text(),'Top Deals')]")
	WebElement TopDeals;
	
	public WebElement getTopDeals()
	{
		return TopDeals;
	}
	
	@FindBy(css="img[alt='Cart']")
	WebElement Cart;
	
	public WebElement getCart()
	{
		return Cart;
	}
	 
	@FindBy(xpath="//button[contains(text(),'PROCEED TO CHECKOUT')]")
	WebElement Checkout;
	
	public WebElement getCheckout()
	{
		return Checkout;
	}
	
	@FindBy(css="input[class='promoCode']")
	WebElement promoCode;
	
	public WebElement getpromoCode()
	{
		return promoCode;
	}


	@FindBy(css="button[class='promoBtn']")
	WebElement apply;
	
	public WebElement getApply()
	{
		return apply;
	}
}
