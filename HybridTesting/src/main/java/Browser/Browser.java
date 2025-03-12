package Browser;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Browser {
	public static WebDriver driver;
	public static WebElement element;
	public static WebDriverWait wait;
	public static Actions act;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest Logger1;
	public static void init(String reportName) {
		extent=new ExtentReports();
		reporter=new ExtentSparkReporter
		(System.getProperty("user.dir")+"//target//ExtentReport//"+reportName+".html");
		}
	
	public static void openBrowser()  {
		extent.attachReporter(reporter);
		Logger1=extent.createTest("Open Browser");
		Logger1.log(Status.INFO,"Opening the Browser");
		try {
			String choice = Utility.properties("browser"); 
			if (choice.equalsIgnoreCase("Chrome"))
				driver = new ChromeDriver();
			else if (choice.equalsIgnoreCase("Edge"))
				driver = new EdgeDriver();
			Logger1.log(Status.PASS, "Browser Opened Successfully");
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Browser - openBrowser "+e);
			Logger1.log(Status.FAIL, "FAILED Opening Successfully");
		}
		extent.flush();
	}
	public static void navigateToUrl() {
		extent.attachReporter(reporter);
		Logger1=extent.createTest("Navigate URL");
		Logger1.log(Status.INFO,"Navigating to URL");
		try {
			String Url = Utility.properties("url");
			driver.get(Url); 
			driver.manage().window().maximize();
			act = new Actions(driver);
			String title=driver.getTitle();
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs(title));
			Logger1.log(Status.PASS, "Navigated to URL successfully and found title");

		} catch (Exception e) {
			System.out.println("Browser - navigatetoUrl "+e);
			Logger1.log(Status.FAIL, "Unable to navigate and get title");

		}
		extent.flush();
	}
	public static void closeBrowser() {
		extent.attachReporter(reporter);
		Logger1=extent.createTest("Quit Browser");
		Logger1.log(Status.INFO,"Closing the Browser");
		try {
			driver.quit();
			Logger1.log(Status.PASS, "Browser closed sucessfully");

		} catch (Exception e) {
			System.out.println("Browser - closeBrowser "+e);
			Logger1.log(Status.FAIL, "Unable to close the browser");

		}
		extent.flush();

	}
	

}

