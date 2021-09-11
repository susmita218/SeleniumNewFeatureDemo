import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//invoke new tab 
		driver.switchTo().newWindow(WindowType.TAB);
				
		//identify window ids of both child and parent window
		Set<String> handles=driver.getWindowHandles();
		
		//identify window id of each
		Iterator<String> tabs=handles.iterator();
		String parentid=tabs.next();//for parent window
		String childid=tabs.next();//for child window
		
		//from child window pass url and store the 1st course name 
		driver.switchTo().window(childid);
		driver.get("https://rahulshettyacademy.com/#/index");
String coursename=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

//go to parent window -> pass the stored course name under name field
driver.switchTo().window(parentid);
WebElement name=driver.findElement(By.cssSelector("input[name='name']"));
name.sendKeys(coursename);

//taking screenshot
File src=name.getScreenshotAs(OutputType.FILE); //webelement specific screenshot concept came with 4.0v
File src2=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //present in previous version
FileUtils.copyFile(src, new File("1.jpg"));
FileUtils.copyFile(src2, new File("2.jpg"));

//get height and width
System.out.println(name.getRect().getDimension().getHeight());
System.out.println(name.getRect().getDimension().getWidth());

//after performing all actions close all the windows or tab invoked by selenium
driver.quit();


	
	}

}
