package pages.demoqa;

import org.openqa.selenium.By;
import pages.BasePage;

public class DemoTabsPage extends BasePage {
	
	public static String tabsPageLoaded() {
		driver.findElement(By.cssSelector(".dropdown-toggle")).click();
		driver.findElement(By.xpath(".//*[@id='menu-item-153']/a")).click();
		return driver.getCurrentUrl();
	}

	

}
