package Pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Browser.Browser;
import Locators.Page2Objects;
public class Page2 extends Browser {
		public static String Username()
		{
			return Page2Objects.username().getText();
		}
		public static void optionclick(String str) 
		{
			try{
				List<WebElement> list=Page2Objects.menuelements();
				for(WebElement e:list)
				{
					if(e.getText().equalsIgnoreCase(str))
					{	e.click();
						break; }
				}
				}
			
			catch(Exception E)
			{
				System.out.println("Click :"+E);
			}	
		}
		
		public static String MenuName()
		{
			return Page2Objects.menuName().getText();
		}
}

