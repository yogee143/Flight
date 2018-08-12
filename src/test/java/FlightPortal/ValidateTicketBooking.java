package FlightPortal;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BookFlightPage;
import pageObjects.FlightConfirmationPage;
import pageObjects.FlightFinderPage;

import pageObjects.LoginPage;
import pageObjects.SelectFlightPage;
import resources.base;

public class ValidateTicketBooking extends base{


	@BeforeTest
	public void initalize() throws IOException {
		driver = initializeDriver();
		log().info("Initalise the driver");
		driver.get(prop.getProperty("url"));
		log().info("Get the URL :"+prop.getProperty("url"));
		log().info("Page Title : "+ driver.getTitle());
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String noOfPass,int tripType, String fromPort , String fromMonth, String fromDate ,String toPort , String returnMonth, String returnDate, int serviceClass, String airline , String departFlight , String returnFlight , String passFirstName , String passLastName , String passCreditCardNo  ) throws IOException {
	

		log().info("Page Title : "+ driver.getTitle());	
		LoginPage lp = new LoginPage(driver) ;
		lp.enterUserName().sendKeys(username);
		lp.enterPassword().sendKeys(password);
		lp.clickLogin().click();
		log().info("Entering the user credentials");
		
		//FIND FLIGHT
		log().info("Page Title : "+ driver.getTitle());
		FlightFinderPage fp = new FlightFinderPage(driver);
		Assert.assertTrue(fp.flightfinder().isDisplayed(),"IN FLIGHT FINDER PAGE");
		
		
		fp.setPassenger(noOfPass);
		fp.setOneWayTrip();
		
		if(tripType==1) {
			fp.setOneWayTrip();
		}
		else {
			fp.setRoundTrip();
		}
		
		fp.setDepartingFrom(fromPort);
		fp.setDepartingMonth(fromMonth);
		fp.setDepartingDate(fromDate);

		fp.setArrivingTo(toPort);
		fp.setReturnMonth(returnMonth);
		fp.setReturnDate(returnDate);

		if(serviceClass==1) {
			fp.setEconomyClass();
		}
		else if(serviceClass==2) {
			fp.setBusinessClass();
		}
		else if (serviceClass==3) {
			fp.setFirstClass();
		}	
		
		fp.setAirlines(airline);
		
		fp.btnContinue().click();
		log().info("Flight Finder Continue button clicked");
		//SELECT FLIGHT
		
		SelectFlightPage sfp = new SelectFlightPage(driver);
		Assert.assertTrue(sfp.selectFlight().isDisplayed());
		log.info("in SELECT FLIGHT page");
		
		sfp.setDepartFlight(departFlight);
		sfp.setReturnFlight(returnFlight);
		sfp.btnSelectFlight().click();
		
		//System.out.println(driver.getPageSource());
		
		//BOOK A FLIGHT
		log().info("Page Title : "+ driver.getTitle());
		BookFlightPage bfp = new BookFlightPage(driver);
		Assert.assertTrue(bfp.imgBookFlight().isDisplayed());
		log().info("in BOOK A FLIGHT page");
		bfp.passFirstName().sendKeys(passFirstName);
		bfp.passLastName().sendKeys(passLastName);
		bfp.passCreditCardNo().sendKeys(passCreditCardNo);
		bfp.btnSecurePurchse().click();
		
		//FLIGHT CONFIRMATION		
		log().info("Page Title : "+ driver.getTitle());
		FlightConfirmationPage fcp = new FlightConfirmationPage(driver);
		Assert.assertTrue(fcp.ticketConfirmation().isDisplayed(),"TICKET BOOKED SUCCESSFULLY");
		log().info("TICKET BOOKED SUCESSFULLY:"+fcp.getTicketNo());
		
	}
	
	@AfterTest
	public void closeDriver() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {

		// Row stands for how many different data types test should run
		// column stands how many values per each test

		Object[][] data = new Object[1][17];

		// 0th row -> Restricted user
		data[0][0] = "yogee143";				// username
		data[0][1] = "Iloveyou143";				// password
		data[0][2] = "1";						// no. of passenger
		data[0][3] = 2;							// triptype 1=oneway, 2=Roundtrip
		data[0][4] = "Paris";					// Departing From
		data[0][5] = "March";					// Departing Month
		data[0][6] = "15";						// Departing Date
		data[0][7] = "Sydney";					// Arriving to	
		data[0][8] = "November";				// Returning Month
		data[0][9] = "20";						// Returning Date
		data[0][10] = 1;						// Service class 1.Economy 2.Business 3.First 
		data[0][11] = "Blue Skies Airlines";	// Airline
		data[0][12] = "Unified Airlines 363";	// Departing Flight
		data[0][13] = "Pangea Airlines 632";	// Return Flight
		data[0][14] = "YOGESH";					// Passenger First Name
		data[0][15] = "JATTI";					// Passenger Last Name
		data[0][16] = "1111222233334444";		// Passenger Credit Card No
		
		return data;
	}
}
