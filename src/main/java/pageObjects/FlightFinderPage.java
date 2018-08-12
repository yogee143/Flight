package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage {

	public WebDriver driver;

	public FlightFinderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='/images/masts/mast_flightfinder.gif']")
	WebElement imgFlightFinder;

	@FindBy(xpath = "//select[@name='passCount']")
	WebElement sPassangerCount;

	@FindBy(xpath = "//input[@name='tripType' and @value='oneway']")
	WebElement tripTypeOneWay;

	@FindBy(xpath = "//input[@name='tripType' and @value='roundtrip']")
	WebElement tripTypeRound;

	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement sFromPort;

	@FindBy(xpath = "//select[@name='fromMonth']")
	WebElement sFromMonth;

	@FindBy(xpath = "//select[@name='fromDay']")
	WebElement sFromDate;

	@FindBy(xpath = "//select[@name='toPort']")
	WebElement sToPort;

	@FindBy(xpath = "//select[@name='toMonth']")
	WebElement sToMonth;

	@FindBy(xpath = "//select[@name='toDay']")
	WebElement sToDate;

	
	@FindBy(xpath="//input[@name='servClass' and @value='Coach']")
	WebElement serviceClassEconomy;
	
	@FindBy(xpath="//input[@name='servClass' and @value='Business']")
	WebElement serviceClassBusiness;
	
	@FindBy(xpath="//input[@name='servClass' and @value='First']")
	WebElement serviceClassFirst;
		
	@FindBy(xpath="//select[@name='airline']")
	WebElement sAirlinePreference;
	
	@FindBy(xpath = "//input[@name='findFlights']")
	WebElement btnContinue;

	

	public Select getAirlines() {
		return new Select(sAirlinePreference);
	}

	public void setAirlines(String byValue) {
		getAirlines().selectByVisibleText(byValue);
	}

	
	public void setEconomyClass() {
		serviceClassEconomy.click();
	}

	public void setBusinessClass() {
		serviceClassBusiness.click();
	}

	public void setFirstClass() {
		serviceClassFirst.click();
	}

	public void setRoundTrip() {
		tripTypeRound.click();
	}
	
	public void setOneWayTrip() {
		tripTypeOneWay.click();
	}
	
	public Select getPassengerSelect() {
		return new Select(sPassangerCount);
	}

	public void setPassenger(String byValue) {
	
		getPassengerSelect().selectByValue(byValue);
	}

	public Select getDepartingFrom() {
		return new Select(sFromPort);
	}

	public void setDepartingFrom(String byValue) {
		getDepartingFrom().selectByValue(byValue);
	}


	public Select getDepartingMonth() {
		return new Select(sFromMonth);
	}

	public void setDepartingMonth(String byValue) {
		System.out.println("byValue"+byValue);
		getDepartingMonth().selectByVisibleText(byValue);
	}

	
	public Select getDepartingDate() {
		return new Select(sFromDate);
	}

	public void setDepartingDate(String byValue) {
		getDepartingDate().selectByVisibleText(byValue);
	}

	
	public Select getArrivingTo() {
		return new Select(sToPort);
	}

	public void setArrivingTo(String byValue) {
		getArrivingTo().selectByVisibleText(byValue);
	}

	public Select getReturnMonth() {
		return new Select(sToMonth);
	}

	public void setReturnMonth(String byValue) {
		getReturnMonth().selectByVisibleText(byValue);
	}

	public Select getReturnDate() {
		return new Select(sToDate);
	}

	public void setReturnDate(String byValue) {
		getReturnDate().selectByVisibleText(byValue);
	}

	
	public WebElement btnContinue() {
		return btnContinue;	
	}
	
	public WebElement flightfinder() {
		return imgFlightFinder;
	}
	
}
