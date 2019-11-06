package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestBuyHomePage {
	public WebDriver driver;

	public BestBuyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gh-search-input")
	WebElement searchButton;

	public WebElement getsearchButton() {
		return searchButton;
	}
	
	@FindBy(xpath = "//a[text()='Gift Cards']")
	WebElement giftCards;

	public WebElement getgiftCards() {
		return giftCards;
	}
	

	@FindBy(xpath = "//button[@class='close']")
	WebElement close;

	public WebElement getclose() {
		return close;
	}

}
