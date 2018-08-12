package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='/images/masts/mast_signon.gif']")
	WebElement imgSignOn;

	@FindBy(xpath="//div[contains(text(),'Mercury Interactive')]")
	WebElement pageFooter;
	
	@FindBy(name="userName")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="login")
	WebElement loginBtn;
	
	public WebElement enterUserName() {
		return txtUserName;
	}
	
	public WebElement enterPassword() {
		return txtPassword;
	}

	public WebElement clickLogin() {
		return loginBtn;
	}
	
	public WebElement imgSignOn() {
		return imgSignOn;
	}
	
	public String getPageFooterText() {
		return pageFooter.getText();
	}

}
