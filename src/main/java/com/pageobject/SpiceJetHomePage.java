package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpiceJetHomePage {

	public WebDriver driver;

	public SpiceJetHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXTaction")
	WebElement Departure;

	public WebElement getDeparture() {
		return Departure;
	}

	@FindBy(id = "ctl00_mainContent_view_date1")
	WebElement departDate;

	public WebElement getdepartDate() {
		return departDate;
	}

	@FindBy(id = "ctl00_mainContent_rbtnl_Trip_1")
	WebElement roundTrip;

	public WebElement getroundTrip() {
		return roundTrip;
	}

	@FindBy(id = "ctl00_mainContent_view_date2")
	WebElement returnDate;

	public WebElement getreturnDate() {
		return returnDate;
	}
	
	
	
	@FindBy(id = "divpaxinfo")
	WebElement passengers;

	public WebElement getpassengers() {
		return passengers;
	}
	
	
	
	@FindBy(id = "ctl00_mainContent_ddl_Adult")
	WebElement adult;

	public WebElement getadult() {
		return adult;
	}
	
	@FindBy(id = "ctl00_mainContent_ddl_Child")
	WebElement child;

	public WebElement getchild() {
		return child;
	}
	
	@FindBy(id = "ctl00_mainContent_ddl_Infant")
	WebElement infant;

	public WebElement getinfant() {
		return infant;
	}
	
	
	
	@FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
	WebElement fromCity;

	public WebElement getfromCity() {
		return fromCity;
	}
	
	@FindBy(xpath = "//a[@value='MAA']")
	WebElement selectFromCity;

	public WebElement getselectFromCity() {
		return selectFromCity;
	}
	
	
	@FindBy(xpath = "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")
	WebElement selecToCity;

	public WebElement getselecToCity() {
		return selecToCity;
	}
	
	@FindBy(id = "ctl00_mainContent_DropDownListCurrency")
	WebElement currency;

	public WebElement getcurrency() {
		return currency;
	}
	
	@FindBy(id = "ctl00_mainContent_chk_friendsandfamily")
	WebElement checkbox_Family;

	public WebElement getcheckbox_Family() {
		return checkbox_Family;
	}
	
	@FindBy(xpath = "//li[@id='header-addons']/a")
	WebElement addOns;

	public WebElement getaddOns() {
		return addOns;
	}
	
}
