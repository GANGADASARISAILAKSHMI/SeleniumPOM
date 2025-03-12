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
import Excel.Login;
import Locators.Page2Objects;
import Pages.Page1;
import Pages.Page2;
import Screenshot.Capture;
public class Test2 {
	@BeforeMethod
	public void openbrowser()
	{
		Browser.init("Testcase2Report");
		Browser.openBrowser();
		Browser.navigateToUrl();
		
	}
	
	@DataProvider(name="dp1")
	public Object[][] data() throws Exception
	{
		Object[][] obj=Login.readExcel(0);
		return obj;
		
	}
	
	@Test(dataProvider = "dp1")
	public void Testloginbutton(String name,String password,String expected)
	{
		Page1.enterusername(name);
		Page1.enterpassword(password);
		Page1.click();
		Assert.assertEquals(Page2.MenuName(),expected);


	}
	
	@AfterMethod
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		Browser.closeBrowser();
	}


}




