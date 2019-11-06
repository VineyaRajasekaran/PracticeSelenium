package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class qaclickacademy {
	public WebDriver driver;

	public qaclickacademy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gh-search-input")
	WebElement searchButton;

	public WebElement getsearchButton() {
		return searchButton;
	}
	

}
