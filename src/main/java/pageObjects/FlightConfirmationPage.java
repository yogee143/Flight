package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage {

	public WebDriver driver;
	
	public FlightConfirmationPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='/images/masts/mast_confirmation.gif']")
	WebElement imgFlightConfirmation;
	
	@FindBy(xpath="//font[contains(text(),'Confirmation #')]")
	WebElement flightTicktNo;

	public WebElement ticketConfirmation() {
		return flightTicktNo; 
	}
	
	public String getTicketNo() {
		return flightTicktNo.getText();
	}
}
