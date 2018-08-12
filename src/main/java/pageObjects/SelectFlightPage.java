package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {

	public WebDriver driver;

	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='/images/masts/mast_selectflight.gif']")
	WebElement imgSelectFlight;

	@FindBy(xpath = "(//input[@name='outFlight'])[1]")
	WebElement rdDepartFlight1;

	@FindBy(xpath = "(//input[@name='outFlight'])[2]")
	WebElement rdDepartFlight2;

	@FindBy(xpath = "(//input[@name='outFlight'])[3]")
	WebElement rdDepartFlight3;

	@FindBy(xpath = "(//input[@name='outFlight'])[4]")
	WebElement rdDepartFlight4;

	@FindBy(xpath = "(//input[@name='inFlight'])[1]")
	WebElement rdReturnFlight1;

	@FindBy(xpath = "(//input[@name='inFlight'])[2]")
	WebElement rdReturnFlight2;

	@FindBy(xpath = "(//input[@name='inFlight'])[3]")
	WebElement rdReturnFlight3;

	@FindBy(xpath = "(//input[@name='inFlight'])[4]")
	WebElement rdReturnFlight4;

	@FindBy(xpath = "//input[@name='reserveFlights']")
	WebElement btnContinue;

	public void setDepartFlight(String flightName) {
		switch (flightName) {
			case "Blue Skies Airlines 360":	rdDepartFlight1.click(); break;
			case "Blue Skies Airlines 361":	rdDepartFlight2.click(); break;
			case "Pangaea Airlines 362":	rdDepartFlight3.click(); break;
			case "Unified Airlines 363":	rdDepartFlight4.click(); break;
		}
	}

	public void setReturnFlight(String flightName) {
		switch (flightName) {
			case "Blue Skies Airlines 630":	rdReturnFlight1.click();break;
			case "Blue Skies Airlines 631": rdReturnFlight2.click();break;
			case "Pangea Airlines 632":rdReturnFlight3.click();	break;
			case "Unified Airlines 633":rdReturnFlight4.click();break;
		}

	}
	
	public WebElement btnSelectFlight() {
		return btnContinue;
	}

	public WebElement selectFlight() {
		return imgSelectFlight;
	}
}

