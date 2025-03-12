package DemoMaven;
import Browser.Browser;
import Pages.Page1;
import Pages.Page2;
import Screenshot.Capture;
public class Demo {
public static void main(String[] args) throws Exception {
	Browser.openBrowser();
	Browser.navigateToUrl();
	Page1.enterusername("Admin");
	Capture.screenShot("username");
	Page1.enterpassword("admin123");
	if(Page1.Title().equals("OrangeHRM"))
	{
		System.out.println("Title matched with expected");
	}
	else
	{
		System.out.println("Title is not matched with expected");
		
	}
	Page1.click();
	
	if(Page2.Username().equals("manda user"))
	{
		System.out.println("user matched with expected");
	}
	else
	{
		System.out.println("user is not matched with expected");
		
	}
	Capture.screenShot("page2");
	Page2.optionclick("time");
	
	Browser.closeBrowser();
}

}
