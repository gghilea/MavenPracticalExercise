package pages.demoqa;

import pages.BasePage;

public class Tabs3Page extends BasePage{
	public boolean verifyMyAccountPage() {
		boolean elem = findObject("logout", "className", true).isDisplayed();
		return elem;
	} 

}
