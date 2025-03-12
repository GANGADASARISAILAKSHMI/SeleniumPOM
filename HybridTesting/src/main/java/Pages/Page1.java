package Pages;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Browser.Browser;
import Browser.Utility;
import Locators.Page1Objects;
import Screenshot.Capture;
public class Page1 extends Browser{
	public static String Title() throws InterruptedException
	{
		extent.attachReporter(reporter);
	Logger1=extent.createTest("Title");
	Logger1.log(Status.INFO, "Screenshot");
	Thread.sleep(5000);
	Logger1.addScreenCaptureFromPath(Capture.screenShot("Title"));
	extent.flush();

		return driver.getTitle();
	}
	public static void enterusername(String str) 
	{
		try 
		{	
				Page1Objects.username().sendKeys(str);
		}
		catch(Exception E)
		{
			System.out.println("Username :"+E);
		}
		
	}
	public static void enterpassword(String str) 
		{
			try
			{
				Page1Objects.password().sendKeys(str);
			}
			catch(Exception E)
			{
				System.out.println("Password :"+E);
			}
			
			
		}
	public static void click() 
	{
		try
		{
			Page1Objects.login().click();
		}
		catch(Exception E)
		{
			System.out.println("Click :"+E);
		}
	}
}

