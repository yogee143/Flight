package FlightPortal;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class ValidateSignOnTest extends base{


	@BeforeTest
	public void initalize() throws IOException {
		driver = initializeDriver();
		log().info("Initalise the driver");
		driver.get(prop.getProperty("url"));
		log().info("Get the URL :"+prop.getProperty("url"));
		log().info("Page Title : "+ driver.getTitle());
	}
	
	@Test
	public void validateSignOnImage() {
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.imgSignOn().isDisplayed());
		log.info("Sign On image present");
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
	
}
