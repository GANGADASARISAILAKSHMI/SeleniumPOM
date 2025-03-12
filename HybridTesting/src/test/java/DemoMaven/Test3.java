package DemoMaven;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browser.Browser;
import Locators.Page2Objects;
import Pages.Page1;
import Pages.Page2;
import Screenshot.Capture;
public class Test3 {
	@BeforeMethod
	public void openbrowser()
	{
		Browser.init("Testcase3Report");
		Browser.openBrowser();
		Browser.navigateToUrl();
		
	}
		
	@Test
	public void TestMenu()
	{
		Page1.enterusername("Admin");
		Page1.enterpassword("admin123");
		Page1.click();
		Page2.optionclick("leave");
		Assert.assertEquals(Page2Objects.menuName().getText(),"Leave");
	}
	
	@AfterMethod
	public void closebrowser()
	{
		Browser.closeBrowser();
	}


}
