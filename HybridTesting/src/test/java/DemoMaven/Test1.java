package DemoMaven;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Browser.Browser;
import Locators.Page2Objects;
import Pages.Page1;
import Pages.Page2;
import Screenshot.Capture;
public class Test1 {

	@BeforeMethod
	public void openbrowser()
	{
		
		Browser.init("Testcase1Report");
		Browser.openBrowser();
		Browser.navigateToUrl();
		
		
	}
	
	@DataProvider(name="title")
	public Object[] data()
	{
		Object[] obj= {"OrangeHRM"};
		return obj;
	}
	
	@Test(priority=1 ,dataProvider = "title")
	public void TestTitle(String title) throws InterruptedException 
	{
		Assert.assertEquals(Page1.Title(), title);
//		Capture.screenShot("title");
//		Reporter.log("Screenshot taken by name title");
	}
	
	@AfterMethod
	public void closebrowser()
	{
		Browser.closeBrowser();
	}

}
