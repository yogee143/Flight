package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPage {

	public WebDriver driver;

	public BookFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebElement lblFromCity;
	WebElement lblToCity;

	WebElement lblArrrivalDate;
	WebElement lblReturnDate;

	WebElement lblDepratureFlightName;
	WebElement lblReturnFlightName;

	WebElement lblFlightClass;

	@FindBy(xpath = "//img[@src='/images/masts/mast_book.gif']")
	WebElement imgBookFlight;

	@FindBy(xpath = "//input[@name='passFirst0']")
	WebElement passFirstName1;

	@FindBy(xpath = "//input[@name='passLast0']")
	WebElement passLastName1;

	@FindBy(xpath = "//select[@name='pass.0.meal']")
	WebElement passMeal1;

	@FindBy(xpath = "//select[@name='creditCard']")
	WebElement ccCardType;

	@FindBy(xpath = "//input[@name='creditnumber']")
	WebElement ccCardNumber;

	@FindBy(xpath = "//select[@name='cc_exp_dt_mn']")
	WebElement ccCardExpiryMonth;

	@FindBy(xpath = "//select[@name='cc_exp_dt_yr']")
	WebElement ccCardExpiryYear;

	@FindBy(xpath = "//input[@name='cc_frst_name']")
	WebElement ccFirstName;

	@FindBy(xpath = "//input[@name='cc_mid_name']")
	WebElement ccMiddleName;

	@FindBy(xpath = "//input[@name='cc_last_name']")
	WebElement ccLastName;

	@FindBy(xpath = "(//input[@name='ticketLess'])[1]")
	WebElement chkTicketlessTravel;

	@FindBy(xpath = "//input[@name='billAddress1']")
	WebElement billingAddress1;

	@FindBy(xpath = "//input[@name='billAddress2']")
	WebElement billingAddress2;

	@FindBy(xpath = "//input[@name='billCity']")
	WebElement billingCity;

	@FindBy(xpath = "//input[@name='billState']")
	WebElement billingState;

	@FindBy(xpath = "//input[@name='billZip']")
	WebElement billingPostal;

	@FindBy(xpath = "//select[@name='billCountry']")
	WebElement billingCountry;

	@FindBy(xpath = "(//input[@name='ticketLess'])[2]")
	WebElement chkSameAsBilling;

	@FindBy(xpath = "//input[@name='delAddress1']")
	WebElement deliveryAddress1;

	@FindBy(xpath = "//input[@name='delAddress2']")
	WebElement deliveryAddress2;

	@FindBy(xpath = "//input[@name='delCity']")
	WebElement deliveryCity;

	@FindBy(xpath = "//input[@name='delState']")
	WebElement deliveryState;

	@FindBy(xpath = "//input[@name='delZip']")
	WebElement deliveryPostal;

	@FindBy(xpath = "//select [@name='delCountry']")
	WebElement deliveryCountry;

	@FindBy(xpath = "//input[@name='buyFlights']")
	WebElement btnSecurePurchase;

	public WebElement passFirstName() {
		return passFirstName1;
	}

	public WebElement passLastName() {
		return passLastName1;
	}

	public WebElement passCreditCardNo() {
		return ccCardNumber;
	}

	public WebElement btnSecurePurchse() {
		return btnSecurePurchase;
	}

	public WebElement imgBookFlight() {
		return imgBookFlight;
	}

}
