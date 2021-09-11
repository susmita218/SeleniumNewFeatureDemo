import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox=driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());
		
		//identify below statement
		WebElement DOBlabel=driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(withTagName("input").below(DOBlabel)).sendKeys("12/23/2000");
		
		WebElement Icecream=driver.findElement(By.xpath("//label[@class='form-check-label']"));
		driver.findElement(withTagName("input").toLeftOf(Icecream)).click();
		
		WebElement empstatus=driver.findElement(By.cssSelector("#inlineRadio1"));
		System.out.println(driver.findElement(withTagName("label").toRightOf(empstatus)).getText());
				
	}

}
