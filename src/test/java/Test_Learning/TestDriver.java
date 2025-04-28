package Test_Learning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import page_objects.Flipkartpages;

public class TestDriver {
	WebDriver driver;
	Flipkartpages flipkartpages;

	@BeforeMethod
	public void setup() {
		// initialize the Chrome Browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void OpenAmazon() throws Exception {
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
	}

	@Test
	public void OpenFlipkart() throws Exception {
		driver.get("https://www.flipkart.com/");
		flipkartpages = new Flipkartpages(driver);

		flipkartpages.closeLoginPopupIfPresent();
		
		flipkartpages.Dropdownwithlinks();
		Thread.sleep(3000);
		
//		flipkartpages.clickOnMobiles();
//		Thread.sleep(3000);
//
//		String text = flipkartpages.getHeaderText();
//		System.out.println("Text ->" + text);
		
		// Locate in the GitHub Repository
		
		// Locate in the GitHub Repository
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
