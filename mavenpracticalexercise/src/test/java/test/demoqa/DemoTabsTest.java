package test.demoqa;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoqa.DemoTabsPage;
import test.BaseTest;

public class DemoTabsTest extends BaseTest {

	@Test
	public void tabsPageLoaded() {
		navigateTo("http://demoqa.com");
		DemoTabsPage.tabsPageLoaded();
		Assert.assertEquals(driver.getCurrentUrl(), "http://demoqa.com/tabs/");
		System.out.println("Validation of Tabs page from Demo-Tabs");
		
	}
}
