package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);
	}

	public void tearDown() {
		driver.close();
		if (!driver.equals(null))
			driver.quit();
	}

	public void navigateTo(String url) {
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

	// helper function
	public static WebElement findObject(String elementName, String elementFindBy, boolean elementMandatory) {
		// method is not void, will return a WebElement
		// Initialize a WebElement type object
		WebElement elementFindObject = null;
		try {
			// in if-else if we choose all the selectors
			if (elementFindBy == "css")
				elementFindObject = driver.findElement(By.cssSelector(elementName));
			else if (elementFindBy == "xpath")
				elementFindObject = driver.findElement(By.xpath(elementName));
			else if (elementFindBy == "id")
				elementFindObject = driver.findElement(By.id(elementName));
			else if (elementFindBy == "className")
				elementFindObject = driver.findElement(By.className(elementName));

		} catch (Exception ex) {
			System.out.println("Element " + elementName + " was not found on page");
		}
		// if an element is found then return that element
		if (elementFindObject == null && elementMandatory == true) {
			System.out.println("The mandatory element " + elementName + " was not found on the page");
		}
		// if the element is not mandatory
		return elementFindObject;
	}

	// click on element after finding the element/object
	public static void clickElementOnFindObject(String elementName, String elementFindBy, boolean elementMandatory) {
		findObject(elementName, elementFindBy, elementMandatory).click();
	}

	// send keys element after findObject: sendKeysOnFindObject
	public static void sendKeysOnFindObject(String elementName, String elementFindBy, boolean elementMandatory,
			String keys) {
		WebElement element = findObject(elementName, elementFindBy, elementMandatory);
		try {
			element.sendKeys(keys);
		} catch (Exception e) {
			System.out.println("Error sending keys");
			e.printStackTrace();
		}
	}

	// get text element
	public static String getTextElement(String elementName, String elementFindBy, boolean elementMandatory) {
		WebElement findObject = findObject(elementName, elementFindBy, elementMandatory);
		String text = findObject.getText();
		return text;
	}
}