package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public static WebDriver driver = null;
	public Properties prop;
	public static Logger log = null;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\NJ\\eclipse-workspace\\Flight\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// firefox
			System.setProperty("webdriver.gecko.driver", prop.getProperty("FireFoxDriverPath"));
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			// IE
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEDriverPath"));
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Browser not supported");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;

	}

	public Logger log() {
		log = LogManager.getLogger(base.class.getName());
		return log;
	}

	public void getScreenshot(String result) throws IOException, InterruptedException {
		System.out.println("File path:" + result);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println("Current Timestamp:" + timeStamp);
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcScreenshot, new File(".//Screenshots//" + result + "-" + timeStamp + "-screenshot.png"));

	}

}
