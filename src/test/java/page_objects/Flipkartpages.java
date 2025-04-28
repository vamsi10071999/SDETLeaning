package page_objects;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkartpages {

	WebDriver driver;

	// Constructor
	public Flipkartpages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements

	// WebElement Mobiles = findElement(By.xpath("//span[text()='Mobiles']"));
	@FindBy(xpath = "//span[text()='Mobiles']")
	WebElement mobilesLink;

	@FindBy(xpath = "//h1[text()='Mobile Phones']")
	WebElement mobilePhonesHeader;

	@FindBy(xpath = "//span[text()='✕']")
	WebElement closeLoginPopup;

	@FindBy(xpath = "//img[@class=\"-dOa_b\"]")
	WebElement Dropdownwithmorehelplinks;

	// Actions
	public void clickOnMobiles() {
		mobilesLink.click();
	}

	public String getHeaderText() {
		return mobilePhonesHeader.getText();
	}

	public void closeLoginPopupIfPresent() {
		try {
			if (closeLoginPopup.isDisplayed()) {
				// Fluent Wait
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(20))
						.pollingEvery(Duration.ofSeconds(2))
						.ignoring(NoSuchElementException.class);

				WebElement element = fluentWait.until(ExpectedConditions.visibilityOf(closeLoginPopup));
				element.click();
			}
		} catch (Exception e) {
			// Popup not present, continue
			System.out.println("Login Popup not displayed.");
		}
	}

	public void Dropdownwithlinks() {
		Dropdownwithmorehelplinks.click();
	}
}
