package test.demoqa;

import org.testng.annotations.Test;

import pages.demoqa.DemoTabsPage;
import test.BaseTest;

public class Tabs3Test extends BaseTest {
	
	@Test
	public void validationMyAccountPage() {
		navigateTo("http://demoqa.com");
		DemoTabsPage.tabsPageLoaded(); 
//		Assert.assertTrue(logpage.verifyMyAccountPage());
	}

}
