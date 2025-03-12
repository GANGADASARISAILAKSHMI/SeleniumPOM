package Locators;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Browser.Browser;
public class Page1Objects extends Browser{
	public static By searchusername=By.name("username");
	public static By searchpassword=By.name("password");
	public static By searchlogin=By.cssSelector("[type=\"submit\"]");
	public static WebElement username()
	{
		wait=new WebDriverWait(Browser.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchusername));
		return driver.findElement(searchusername);
	}
	public static WebElement password()
	{
		return driver.findElement(searchpassword);
	}
	public static WebElement login()
	{
		return driver.findElement(searchlogin);
	}
}
